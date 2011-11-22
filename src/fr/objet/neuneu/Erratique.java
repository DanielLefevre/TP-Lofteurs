package fr.objet.neuneu;

import java.awt.Color;
import java.awt.Graphics;

import fr.objet.affichage.ObjetDessinable;
import fr.objet.general.Case;
import fr.objet.general.Loft;

/**
 * Implémente un erratique : aucune recherche de nourriture, ni de reproduction.
 * 
 * @author Daniel Lefèvre
 * 
 */
public class Erratique extends AbstractNeuneu {

    /**
     * Probabilité de reproduction.
     */
    private static final double REPRODUCTION = 0.05;

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
    public Erratique(final Loft loftIn, final int x, final int y) {
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
            Case newCase = this.determinerCaseVoisineAleatoire();

            if (this.getEnergie() > AbstractNeuneu.ENERGIE_REPRODUCTION
                    && newCase.hasNeuneu() && Math.random() < REPRODUCTION) {
                this.seReproduire(newCase.getNeuneu());

            } else if (!newCase.hasNeuneu() || newCase.getNeuneu() != this) {
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
            g.setColor(Color.BLUE);
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
