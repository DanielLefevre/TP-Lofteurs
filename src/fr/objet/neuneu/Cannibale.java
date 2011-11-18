package fr.objet.neuneu;

import java.awt.Color;
import java.awt.Graphics;

import fr.objet.general.Case;
import fr.objet.general.Loft;

public class Cannibale extends AbstractNeuneu {

    public Cannibale(Loft loftIn, int x, int y) {
        super(loftIn, x, y);
    }

    @Override
    public void cycleDeVie() {
        if (this.energie > 0) {
            Case newCase = this.determinerNeuneuLePlusProche();
            if (newCase == null) {
                newCase = this.determinerCaseVersNourriture();
            }
            if (newCase == null) {
                newCase = this.determinerCaseVoisineAleatoire();
            }
            if (newCase.hasNeuneu() && !newCase.getNeuneu().isDead()) {
                this.changerCase(newCase);
                this.manger(newCase.getNeuneu());
            } else if (!newCase.hasNeuneu() && newCase.hasNourriture()) {
                // Recherche de nourriture
                this.changerCase(newCase);
                this.manger(newCase);
            } else if (this.energie > 10 && newCase.hasNeuneu()
                    && Math.random() < 0.05) {
                // Reproduction
                this.seReproduire(newCase.getNeuneu());
            } else if (!newCase.hasNeuneu()) {
                // Changement aléatoire de case
                this.changerCase(newCase);
                if (newCase.hasNourriture()) {
                    this.manger(newCase);
                }
            }
            this.energie--;
        }
    }

    @Override
    public void dessinerObjet(Graphics g) {
        Color c = g.getColor();
        if (this.energie == 0) {
            g.setColor(Color.BLACK);
        } else {
            g.setColor(Color.RED);
        }
        g.fillOval(this.caseActuelle.getX() * 20,
                this.caseActuelle.getY() * 20, 10, 10);
        g.setColor(c);
    }
}
