package fr.objet.general;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import fr.objet.affichage.ObjetDessinable;
import fr.objet.affichage.ZoneGraphique;
import fr.objet.neuneu.AbstractNeuneu;
import fr.objet.sustentation.Alcool;
import fr.objet.sustentation.Fruits;

/**
 * Implémente un loft, qui contient une liste de cases, une liste de neuneu,
 * ainsi qu'une référence vers la zone graphique pour l'affichage.
 * 
 * @author Daniel Lefèvre
 */
/**
 * @author Daniel
 * 
 */
public class Loft implements ObjetDessinable {

    /**
     * Temps entre le lancement de deux tours successifs.
     */
    public static final int TIME_WAIT = 400;
    /**
     * Liste des cases.
     */
    private Case[][] listeCases;
    /**
     * Hauteur du loft.
     */
    private int hauteur;
    /**
     * Largeur du loft.
     */
    private int largeur;
    /**
     * Liste des neuneurs. Elle contient aussi ceux qui sont morts.
     */
    private List<AbstractNeuneu> neuneus = new ArrayList<>();
    /**
     * Référence vers la zone graphique pour l'affichage.
     */
    private ZoneGraphique zone;

    /**
     * Constructeur à partir de la taille (on considère que largeur = hauteur)
     * et avec la référence à la zone graphique.
     * 
     * @param tailleIn
     *            côté du loft
     * @param zoneIn
     *            zone graphique
     */
    public Loft(final int tailleIn, final ZoneGraphique zoneIn) {
        this.hauteur = tailleIn;
        this.largeur = tailleIn;
        this.listeCases = new Case[tailleIn][tailleIn];
        for (int i = 0; i < tailleIn; i++) {
            for (int j = 0; j < tailleIn; j++) {
                this.listeCases[i][j] = new Case(this, i, j);
            }
        }
        this.zone = zoneIn;
    }

    /**
     * Ajouter un neuneu dans le loft.
     * 
     * @param neuneu
     *            le neuneu à ajouter
     */
    public final void add(final AbstractNeuneu neuneu) {
        this.neuneus.add(neuneu);
    }

    /*
     * (non-Javadoc)
     * 
     * @see fr.objet.affichage.ObjetDessinable#dessinerObjet(java.awt.Graphics)
     */
    @Override
    public final void dessinerObjet(final Graphics g) {
        for (Case[] cases : this.listeCases) {
            for (Case uneCase : cases) {
                uneCase.dessinerObjet(g);
            }
        }
        for (AbstractNeuneu neuneu : this.neuneus) {
            neuneu.dessinerObjet(g);
        }
    }

    /***
     * Getter.
     * 
     * @param x
     *            l'abscisse
     * @param y
     *            l'ordonnée
     * @return la case correspondant à ces corrdonnées.
     */
    public final Case getCase(final int x, final int y) {
        return this.listeCases[x][y];
    }

    /**
     * Getter.
     * 
     * @return la hauteur du loft
     */
    public final int getHauteur() {
        return this.hauteur;
    }

    /**
     * Getter.
     * 
     * @return la largeur du loft
     */
    public final int getLargeur() {
        return this.largeur;
    }

    /**
     * Getter.
     * 
     * @return la liste des cases
     */
    public final Case[][] getListeCases() {
        return this.listeCases;
    }

    /**
     * Getter.
     * 
     * @return la liste des neuneus
     */
    public final List<AbstractNeuneu> getNeuneus() {
        return this.neuneus;
    }

    /**
     * Lance le programme : démarre une succession de n boucles.
     * 
     * @param nombreTours
     *            le nombre de boucles
     * @throws InterruptedException
     *             si le Thread.sleep() a un problème
     */
    public final void go(final int nombreTours) throws InterruptedException {
        for (int i = 0; i < nombreTours; i++) {
            for (int j = 0; j < this.neuneus.size(); j++) {
                this.neuneus.get(j).cycleDeVie();
            }
            Thread.sleep(Loft.TIME_WAIT);

            this.zone.repaint();
        }
    }

    /**
     * Vérifie si les coordonées x et y correspondent à une case appartenant au
     * loft.
     * 
     * @param x
     *            l'abscisse
     * @param y
     *            l'ordonnée
     * @return true si x est entre 0 et la largeur - 1 et y entre 0 et la
     *         hauteur - 1, false sinon
     */
    public final boolean isInBounds(final int x, final int y) {
        return x >= 0 && x < this.largeur && y >= 0 && y < this.hauteur;
    }

    /**
     * Remplit le loft de nourriture selon le pourcentage.
     * 
     * @param pourcentage
     *            le pourcentage
     */
    public final void remplissageAleatoire(final float pourcentage) {
        for (int i = 0; i < (int) (this.hauteur * this.largeur * pourcentage / 2); i++) {
            this.listeCases[(int) (Math.random() * this.largeur)][(int) (Math
                    .random() * this.hauteur)].setNourriture(new Fruits());
            this.listeCases[(int) (Math.random() * this.largeur)][(int) (Math
                    .random() * this.hauteur)].setNourriture(new Alcool());
        }
    }
}
