package fr.objet.neuneu;

import fr.objet.affichage.ObjetDessinable;
import fr.objet.general.Case;
import fr.objet.general.Loft;
import fr.objet.sustentation.Mangeable;

/**
 * Implémente une abstraction de neuneu. La méthode cycle de vie dépend du type
 * de neuneu et doit être implémentée par chaque neuneu.
 * 
 * @author Daniel Lefèvre
 * 
 */
public abstract class AbstractNeuneu implements Mangeable, ObjetDessinable {

    /**
     * Energie du neuneu.
     */
    private int energie;

    /**
     * Case actuelle où est le neuneu.
     */
    private Case caseActuelle;

    /**
     * Référence vers le loft.
     */
    private Loft loft;
    /**
     * Energie de départ par défaut du neuneu.
     */
    protected static final int ENERGIE_DEPART = 10;
    /**
     * Energie nécessaire pour se reproduire.
     */
    public static final int ENERGIE_REPRODUCTION = 10;

    /**
     * Constructeur à partir de la case et du loft.
     * 
     * @param loftIn
     *            le loft
     * @param caseActuelleIn
     *            la case de départ du neuneu
     */
    public AbstractNeuneu(final Loft loftIn, final Case caseActuelleIn) {
        this.caseActuelle = caseActuelleIn;
        this.loft = loftIn;
        this.energie = AbstractNeuneu.ENERGIE_DEPART;
    }
    /**
     * Constructeur à partir des coordonnées de la case et du loft.
     * 
     * @param loftIn
     *            le loft
     * @param x
     *            l'abscisse
     * @param y
     *            l'ordonnée
     */
    public AbstractNeuneu(final Loft loftIn, final int x, final int y) {
        this.loft = loftIn;
        this.caseActuelle = loftIn.getCase(x, y);
        this.energie = AbstractNeuneu.ENERGIE_DEPART;
    }

    /**
     * Ajout d'énergie à un neuneu.
     * 
     * @param energieIn
     *            l'énergie à ajouter
     */
    public final void addEnergie(final int energieIn) {
        this.energie += energieIn;
    }

    /**
     * Faire bouger le neuneu dans une autre case. Ne bouge pas si l'autre case
     * est déjà occupée.
     * 
     * @param newCase
     *            la nouvelle case
     */
    public final void changerCase(final Case newCase) {
        if (!newCase.hasNeuneu()) {
            // Sortir de la case actuelle.
            this.caseActuelle.removeNeuneu(this);
            // Aller dans l'autre case.
            newCase.addNeuneu(this);
            // Changer la référence vers la nouvelle case.
            this.caseActuelle = newCase;
        }
        // S'il n'y a pas de place à côté, on ne bouge pas.
    }

    /*
     * (non-Javadoc)
     * 
     * @see fr.objet.sustentation.Mangeable#consommerEnergie(int)
     */
    @Override
    public final void consommerEnergie(final int energieConsommee) {
        this.energie -= energieConsommee;
    }

    /**
     * Lance le cycle de vie du neuneu : manger, se reproduire, boire, bouger.
     * L'ordre de ces étapes diffère selon le type de neuneu.
     */
    public abstract void cycleDeVie();

    /**
     * Décrémente l'énergie.
     */
    public final void decEnergie() {
        this.energie--;
    }

    /**
     * Recherche la nourriture la plus proche et la case voisine pour y aller.
     * 
     * @return la case voisine de la case actuelle qui est du côté de la
     *         nourriture la plus proche
     */
    public final Case determinerCaseVersNourriture() {
        double distanceMin = this.loft.getHauteur() * this.loft.getLargeur();
        Case but = null;
        for (Case[] ligne : this.loft.getListeCases()) {
            for (Case c : ligne) {
                if (c.hasNourriture()
                        && c.distance(this.caseActuelle) < distanceMin) {
                    distanceMin = c.distance(this.caseActuelle);
                    but = c;
                }
            }
        }

        if (but == null) {
            // S'il n'y a plus de nourriture.
            return null;
        }

        // idéale est la case la plus proche avec de la nourriture. Il faut
        // maintenant trouver comment y aller.
        Case ideale = null;
        for (Case c : this.caseActuelle.getVoisins()) {
            if (c.distance(but) < distanceMin) {
                distanceMin = c.distance(but);
                ideale = c;
            }
        }
        return ideale;
    }

    /**
     * Sélectionne une case voisine de la case actuelle aléatoirement.
     * 
     * @return la case
     */
    public final Case determinerCaseVoisineAleatoire() {
        // Determiner une case voisine random.
        int x, y;
        do {
            x = (int) (Math.random() * (2 + 1)) - 1;
            y = (int) (Math.random() * (2 + 1)) - 1;
            // Tant que les chiffres trouv�s ne sont pas dans les bounds.
        } while (!this.loft.isInBounds(this.caseActuelle.getX() + x,
                this.caseActuelle.getY() + y) || x == 0 || y == 0);

        return this.loft.getCase(this.caseActuelle.getX() + x,
                this.caseActuelle.getY() + y);
    }

    /**
     * Recherche le neuneu le plus proche dans les cases voisines.
     * 
     * @return la case où est le neuneu
     */
    public final Case determinerCaseVoisineNeuneu() {
        for (Case voisin : this.caseActuelle.getVoisins()) {
            if (voisin.hasNeuneu()) {
                return voisin;
            }
        }
        return null;
    }

    /**
     * Recherche le neuneu le plus proche.
     * 
     * @return la case voisine de la case actuelle du côté du neuneu le plus
     *         proche
     */
    public final Case determinerNeuneuLePlusProche() {
        double distanceMin = this.loft.getHauteur() * this.loft.getLargeur();
        Case but = null;
        for (Case[] ligne : this.loft.getListeCases()) {
            for (Case c : ligne) {
                if (c.hasNeuneu()
                        && c.distance(this.caseActuelle) < distanceMin
                        && !c.getNeuneu().isDead()) {
                    distanceMin = c.distance(this.caseActuelle);
                    but = c;
                }
            }
        }

        if (but == null) {
            // S'il n'y a plus de neuneus nul part.
            return null;
        }

        // idéale est la case la plus proche avec un neuneu. Il faut
        // maintenant trouver comment y aller.
        Case ideale = null;
        for (Case c : this.caseActuelle.getVoisins()) {
            if (c.distance(but) < distanceMin) {
                distanceMin = c.distance(but);
                ideale = c;
            }
        }
        return ideale;
    }

    /**
     * Getter.
     * 
     * @return la case actuelle
     */
    public final Case getCaseActuelle() {
        return this.caseActuelle;
    }

    /*
     * (non-Javadoc)
     * 
     * @see fr.objet.sustentation.Mangeable#getEnergie()
     */
    @Override
    public final int getEnergie() {
        return this.energie;
    }

    /**
     * Getter.
     * 
     * @return le loft
     */
    public final Loft getLoft() {
        return this.loft;
    }

    /**
     * Vérifie si le neuneu est mort.
     * 
     * @return true si l'énergie du neuneu est égale à 0, false sinon
     */
    public final boolean isDead() {
        return this.energie == 0;
    }

    /**
     * Mange la nourriture de la case sélectionnée.
     * 
     * @param c
     *            la case où manger
     */
    public final void manger(final Case c) {
        this.manger(c.getNourriture());
    }

    /**
     * Mange l'objet de type mangeable. Diminue l'energie de l'objet, augmente
     * celle du neuneu. Ne peut manger que Mangeable.MAX_MANGEABLE d'énergie à
     * chaque fois.
     * 
     * @param bouffe
     *            l'objet à manger
     */
    public final void manger(final Mangeable bouffe) {
        if (bouffe.getEnergie() > 0) {
            if (bouffe.getEnergie() > Mangeable.MAX_MANGEABLE) {
                this.addEnergie(Mangeable.MAX_MANGEABLE);
                bouffe.consommerEnergie(Mangeable.MAX_MANGEABLE);
            } else {
                this.addEnergie(bouffe.getEnergie());
                bouffe.consommerEnergie(bouffe.getEnergie());
            }
        }
    }

    /**
     * Reproduit le neuneu : consomme de l'énergie chez les deux neuneus, et
     * ajoute un neuneu. Ce neuneu est pour le moment toujours erratique.
     * 
     * @param neuneu
     *            l'autre neuneu avec qui se reproduire
     * @todo créer d'autres types de neuneu à la reproduction
     */
    public final void seReproduire(final AbstractNeuneu neuneu) {
        this.consommerEnergie(AbstractNeuneu.ENERGIE_REPRODUCTION);
        neuneu.consommerEnergie(AbstractNeuneu.ENERGIE_REPRODUCTION);
        this.loft.add(new Erratique(this.loft, this.caseActuelle.getX(),
                this.caseActuelle.getY()));
    }

    /**
     * Setter.
     * 
     * @param caseActuelleIn
     *            la case où va être le neuneu
     */
    public final void setCaseActuelle(final Case caseActuelleIn) {
        this.caseActuelle = caseActuelleIn;
    }

    /**
     * Setter.
     * 
     * @param energieIn
     *            l'énergie à donner au neuneu
     */
    public final void setEnergie(final int energieIn) {
        this.energie = energieIn;
    }
}
