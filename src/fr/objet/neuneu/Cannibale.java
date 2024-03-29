package fr.objet.neuneu;

import java.awt.Color;
import java.awt.Graphics;

import fr.objet.affichage.ObjetDessinable;
import fr.objet.general.Case;
import fr.objet.general.Loft;

/**
 * Implémente un cannibale : recherche de la nourriture, et mange les neuneu
 * voisins s'il en trouve. Peu de reproduction.
 * 
 * @author Daniel Lefèvre
 * 
 */
public class Cannibale extends AbstractNeuneu {

    /**
     * Probabilité pour un cannibale de se reproduire.
     */
    private static final float PROBA_REPRODUCTION = 0.05f;

    /**
     * Constructeur d'un cannibale.
     * 
     * @param loftIn
     *            le loft
     * @param x
     *            l'abscisse de la case
     * @param y
     *            l'ordonnée de la case
     */
    public Cannibale(final Loft loftIn, final int x, final int y) {
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
                newCase = this.determinerCaseVersNourriture();
            }
            if (newCase == null) {
                newCase = this.determinerCaseVoisineAleatoire();
            }

            if (newCase.hasNeuneu() && !newCase.getNeuneu().isDead()) {
                // Cannibalisme
                this.changerCase(newCase);
                this.manger(newCase.getNeuneu());

            } else if (this.getEnergie() > AbstractNeuneu.ENERGIE_REPRODUCTION
                    && newCase.hasNeuneu() && newCase.getNeuneu() != this
                    && !newCase.getNeuneu().isDead()
                    && Math.random() < Cannibale.PROBA_REPRODUCTION) {
                // Reproduction
                this.seReproduire(newCase.getNeuneu());

            } else if (!newCase.hasNeuneu() || (newCase.getNeuneu() == this)) {
                // Changement de case
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
        if (this.getEnergie() > 0) {
            g.setColor(Color.RED);
        } else {
            g.setColor(Color.BLACK);
        }
        g.fillOval(this.getCaseActuelle().getX() * ObjetDessinable.TAILLE_CASE,
                this.getCaseActuelle().getY() * ObjetDessinable.TAILLE_CASE,
                ObjetDessinable.TAILLE_CERCLE_NEUNEU,
                ObjetDessinable.TAILLE_CERCLE_NEUNEU);
        g.setColor(c);
    }
}
