package fr.objet.neuneu;

import java.awt.Color;
import java.awt.Graphics;

import fr.objet.affichage.ObjetDessinable;
import fr.objet.general.Case;
import fr.objet.general.Loft;

/**
 * Impélémente un lapin : grande capacité de reproduction. Recherche de
 * nourriture inexistante.
 * 
 * @author Daniel Lefèvre
 * 
 */
public class Lapin extends AbstractNeuneu {

    /**
     * Probabilité pour un lapin de se reproduire.
     */
    private static final float PROBA_REPRODUCTION = 0.5f;

    /**
     * Constructeur.
     * 
     * @param loftIn
     *            le loft
     * @param x
     *            l'abscisse
     * @param y
     *            l'ordonnée
     */
    public Lapin(final Loft loftIn, final int x, final int y) {
        super(loftIn, x, y);
    }

    /*
     * (non-Javadoc)
     * 
     * @see fr.objet.neuneu.AbstractNeuneu#cycleDeVie()
     */
    @Override
    public final void cycleDeVie() {
        if (this.getEnergie() > 0) {
            Case newCase = this.determinerNeuneuLePlusProche();

            if (newCase == null) {
                newCase = this.determinerCaseVoisineNeuneu();
            }

            if (newCase == null) {
                newCase = this.determinerCaseVoisineAleatoire();
            }

            if (this.getEnergie() > AbstractNeuneu.ENERGIE_REPRODUCTION
                    && newCase.hasNeuneu()
                    && Math.random() < Lapin.PROBA_REPRODUCTION) {
                this.seReproduire(newCase.getNeuneu());

            } else if (!newCase.hasNeuneu()) {
                this.changerCase(newCase);
                if (newCase.hasNourriture()) {
                    this.manger(newCase);
                }
            }
            this.decEnergie();
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see fr.objet.affichage.ObjetDessinable#dessinerObjet(java.awt.Graphics)
     */
    @Override
    public final void dessinerObjet(final Graphics g) {
        Color c = g.getColor();
        if (this.getEnergie() == 0) {
            g.setColor(Color.BLACK);
        } else {
            g.setColor(Color.GREEN);
        }
        g.fillOval(this.getCaseActuelle().getX() * ObjetDessinable.TAILLE_CASE,
                this.getCaseActuelle().getY() * ObjetDessinable.TAILLE_CASE,
                ObjetDessinable.TAILLE_CERCLE_NEUNEU,
                ObjetDessinable.TAILLE_CERCLE_NEUNEU);
        g.setColor(c);
    }
}
