package fr.objet.neuneu;

import java.awt.Color;
import java.awt.Graphics;

import fr.objet.affichage.ObjetDessinable;
import fr.objet.general.Case;
import fr.objet.general.Loft;
import fr.objet.sustentation.Fruits;

/**
 * Implémente un vorace : capacité de recherche de nourriture, reproduction
 * faible.
 * 
 * @author Daniel
 * 
 */
public class Vorace extends AbstractNeuneu {

    /**
     * La probabilité pour un vorace de se reproduire quand il croise un autre
     * neuneu.
     */
    private static final float PROBA_REPRODUCTION = 0.05f;

    /**
     * Constructor.
     * 
     * @param loftIn
     *            le loft
     * @param x
     *            l'abscisse
     * @param y
     *            l'ordonnée
     */
    public Vorace(final Loft loftIn, final int x, final int y) {
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
            Case newCase = this.determinerCaseVersNourriture();
            if (newCase == null) {
                newCase = this.determinerCaseVoisineAleatoire();
            }
            if (this.getEnergie() > AbstractNeuneu.ENERGIE_REPRODUCTION
                    && newCase.hasNeuneu()
                    && Math.random() < Vorace.PROBA_REPRODUCTION) {
                this.seReproduire(newCase.getNeuneu());
            } else if (!newCase.hasNeuneu()) {
                this.changerCase(newCase);
                if (newCase.hasNourriture()
                        && !(newCase.getNourriture() instanceof Fruits)) {
                    this.manger(newCase);
                }
            }
            this.setEnergie(this.getEnergie() - 1);
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
            g.setColor(Color.CYAN);
        }
        g.fillOval(this.getCaseActuelle().getX() * ObjetDessinable.TAILLE_CASE,
                this.getCaseActuelle().getY() * ObjetDessinable.TAILLE_CASE,
                ObjetDessinable.TAILLE_CERCLE_NEUNEU,
                ObjetDessinable.TAILLE_CERCLE_NEUNEU);
        g.setColor(c);
    }
}
