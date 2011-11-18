package fr.objet.neuneu;

import java.awt.Color;
import java.awt.Graphics;

import fr.objet.general.Case;
import fr.objet.general.Loft;

public class Erratique extends AbstractNeuneu {

    public Erratique(Loft loftIn, Case caseActuelleIn) {
        super(loftIn, caseActuelleIn);
    }

    public Erratique(Loft loftIn, int x, int y) {
        super(loftIn, x, y);
    }

    @Override
    public void cycleDeVie() {
        if (this.energie > 0) {
            Case newCase = this.determinerCaseVoisineAleatoire();
            if (this.energie > 10 && newCase.hasNeuneu()
                    && Math.random() < 0.05) {
                this.seReproduire(newCase.getNeuneu());
            } else if (!newCase.hasNeuneu()) {
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
            g.setColor(Color.BLUE);
        }
        g.fillOval(this.caseActuelle.getX() * 20,
                this.caseActuelle.getY() * 20, 10, 10);
        g.setColor(c);
    }
}
