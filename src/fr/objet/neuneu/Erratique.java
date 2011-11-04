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
    public void dessinerObjet(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.RED);
        g.fillOval(this.caseActuelle.getX() * 5, this.caseActuelle.getY() * 5,
            10, 10);
        g.setColor(c);
    }

    @Override
    public void cycleDeVie() {
        System.out.println("Erratique moves");
        Case newCase = this.determinerCaseVoisineAleatoire();
        if (this.energie > 50 && newCase.hasNeuneu()) {
            this.changerCase(newCase);
            this.seReproduire(newCase.getNeuneus().get(0));
        } else if (!newCase.hasNeuneu()) {
            this.changerCase(newCase);
            if (newCase.hasNourriture()) {
                this.manger(newCase);
            }
        }
    }
}
