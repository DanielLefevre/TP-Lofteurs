package fr.objet.neuneu;

import java.awt.Color;
import java.awt.Graphics;

import fr.objet.general.Case;
import fr.objet.general.Loft;

public class Cannibale extends AbstractNeuneu {

    public Cannibale(Loft loftIn, int x, int y) {
	super(loftIn, x, y);
	// TODO Auto-generated constructor stub
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

    @Override
    public void cycleDeVie() {
	if (this.energie > 0) {
	    Case newCase = this.determinerCaseVersNourriture();
	    if (newCase == null) {
		newCase = this.determinerCaseVoisineAleatoire();
	    }
	    if (this.energie > 10 && newCase.hasNeuneu()) {
		this.changerCase(newCase);
		this.seReproduire(newCase.getNeuneus().get(0));
	    } else if (!newCase.hasNeuneu() && newCase.hasNourriture()) {
		this.changerCase(newCase);
		this.manger(newCase);
	    } else if (newCase.hasNeuneu()) {
		this.changerCase(newCase);
		this.manger(newCase.getNeuneus().get(0));
	    } else if (!newCase.hasNeuneu()) {
		this.changerCase(newCase);
		if (newCase.hasNourriture()) {
		    this.manger(newCase);
		}
	    }
	    this.energie--;
	}
    }
}
