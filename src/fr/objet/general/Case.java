package fr.objet.general;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import fr.objet.affichage.ObjetDessinable;
import fr.objet.neuneu.AbstractNeuneu;
import fr.objet.sustentation.AbstractNourriture;

/**
 * Implémente une case : objet du loft, elle contient de la nourriture, une
 * liste de neuneus (dont le nombre est normalement égal à 1), ainsi que sa
 * position (x, y), dans le loft.
 * 
 * @author Daniel Lefèvre
 */
public class Case {

    /**
     * Référence vers la nourriture : un seul type de nourriture est permis par
     * case.
     */
    private AbstractNourriture nourriture;
    /**
     * Liste de neuneus présents sur la case : il ne devrait y avoir qu'un seul
     * neuneu en temps normal. Seulement, lors de la reproduction, le nouveau
     * neuneu apparait sur la même case qu'un de ses parents.
     */
    private List<AbstractNeuneu> neuneus = new ArrayList<>();
    /**
     * Référence vers le loft.
     */
    private Loft loft;
    /**
     * Abscisse de la case.
     */
    private int x;
    /**
     * Ordonnée de la case.
     */
    private int y;

    /**
     * Constructeur à partir de la position.
     * 
     * @param loftIn
     *            la référence vers le loft
     * @param xIn
     *            l'abscisse de la case
     * @param yIn
     *            l'ordonnée de la case
     */
    public Case(final Loft loftIn, final int xIn, final int yIn) {
	this.loft = loftIn;
	this.x = xIn;
	this.y = yIn;
    }

    /**
     * Ajouter un neuneu sur la case. Ne vérifie pas le nombre de neuneus
     * présents.
     * 
     * @param abstractNeuneu
     *            le neuneu à ajouter
     */
    public final void addNeuneu(final AbstractNeuneu abstractNeuneu) {
	this.neuneus.add(abstractNeuneu);
    }

    /**
     * Permet de dessiner le contenu de la case : la nourriture s'il y en a.
     * 
     * @param g
     *            le contexte graphique où dessiner
     */
    public final void dessinerObjet(final Graphics g) {
	if (this.nourriture != null && this.nourriture.getEnergie() > 0) {
	    Color c = g.getColor();
	    g.setColor(this.nourriture.returnColor());
	    g.fillOval(this.x * ObjetDessinable.TAILLE_CASE, this.y
		    * ObjetDessinable.TAILLE_CASE,
		    ObjetDessinable.TAILLE_CERCLE_NOURRITURE,
		    ObjetDessinable.TAILLE_CERCLE_NOURRITURE);
	    g.setColor(c);
	}
    }

    /**
     * Calcule la distance entre deux cases.
     * 
     * @param c
     *            la deuxième case
     * @return la distance
     */
    public final double distance(final Case c) {
	return Math.sqrt(Math.pow(this.x - c.x, 2) + Math.pow(this.y - c.y, 2));
    }

    /**
     * Getter.
     * 
     * @return le premier neuneu de la liste
     */
    public final AbstractNeuneu getNeuneu() {
	return this.neuneus.get(0);
    }

    /**
     * Getter.
     * 
     * @return la liste de neuneus
     */
    public final List<AbstractNeuneu> getNeuneus() {
	return this.neuneus;
    }

    /**
     * Getter.
     * 
     * @return la nourriture contenue sur la case. Si elle n'en contient pas,
     *         l'exception NullPointerException est jetée
     */
    public final AbstractNourriture getNourriture() {
	return this.nourriture;
    }

    /**
     * Renvoie la liste de voisins (contenus dans le loft) de la case actuelle.
     * 
     * @return la liste des voisins
     */
    public final ArrayList<Case> getVoisins() {
	ArrayList<Case> voisins = new ArrayList<>();
	for (int i = -1; i < 2; i++) {
	    for (int j = -1; j < 2; j++) {
		if (this.loft.isInBounds(this.x + i, this.y + j)
			&& (i != 0 || j != 0)) {
		    if (this.loft.getCase(this.x + i, this.y + j) == null) {
			System.out.println();
		    }
		    voisins.add(this.loft.getCase(this.x + i, this.y + j));
		}
	    }
	}
	return voisins;
    }

    /**
     * Getter.
     * 
     * @return l'abscisse de la case
     */
    public final int getX() {
	return this.x;
    }

    /**
     * Getter.
     * 
     * @return l'ordonnée de la case
     */
    public final int getY() {
	return this.y;
    }

    /**
     * Vérifie si un neuneu est sur la case.
     * 
     * @return true si au moins un neuneu y est, false sinon
     */
    public final boolean hasNeuneu() {
	return !this.neuneus.isEmpty();
    }

    /**
     * Vérifie si la case contient de la nourriture.
     * 
     * @return true si elle a de la nourriture et que la valeur énergétique de
     *         celle-ci est supérieure à 0, false, sinon
     */
    public final boolean hasNourriture() {
	return this.nourriture != null && this.nourriture.getEnergie() > 0;
    }

    /**
     * Enlève le neuneu de la case.
     * 
     * @param abstractNeuneu
     *            le neuneu à enlever
     */
    public final void removeNeuneu(final AbstractNeuneu abstractNeuneu) {
	this.neuneus.remove(abstractNeuneu);
    }

    /**
     * Setter.
     * 
     * @param nourritureIn
     *            la nourriture à mettre sur la case. Ecrase la nourriture
     *            précédente si elle existe.
     */
    public final void setNourriture(final AbstractNourriture nourritureIn) {
	this.nourriture = nourritureIn;
    }
}
