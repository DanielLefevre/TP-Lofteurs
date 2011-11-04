package fr.objet.neuneu;

import java.awt.Color;
import java.awt.Graphics;

import fr.objet.general.Case;
import fr.objet.general.Loft;

public class Vorace extends AbstractNeuneu {

    public Vorace(Loft loftIn, int x, int y) {
        super(loftIn, x, y);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void dessinerObjet(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.RED);
        g.fillOval(this.caseActuelle.getX() * 5, this.caseActuelle.getY() * 5,
            10, 10);
        g.setColor(c);
    }

    @Override
    public void cycleDeVie() {
        System.out.println("Vorace moves");
        Case newCase = this.determinerCaseVoisineNourriture();
        if (newCase == null) {
            newCase = this.determinerCaseVoisineAleatoire();
        }

        if (this.energie > 50 && newCase.hasNeuneu()) {
            this.changerCase(newCase);
            this.seReproduire(newCase.getNeuneus().get(0));
        } else if (!newCase.hasNeuneu() && newCase.hasNourriture()) {
            this.changerCase(newCase);
            this.manger(newCase);
        }
    }
}
