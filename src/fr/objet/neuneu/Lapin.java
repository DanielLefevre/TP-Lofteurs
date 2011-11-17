package fr.objet.neuneu;

import java.awt.Color;
import java.awt.Graphics;

import fr.objet.general.Case;
import fr.objet.general.Loft;

public class Lapin extends AbstractNeuneu {

    public Lapin(Loft loftIn, int x, int y) {
	super(loftIn, x, y);
	// TODO Auto-generated constructor stub
    }

    @Override
    public void dessinerObjet(Graphics g) {
	Color c = g.getColor();
	if (this.energie == 0) {
	    g.setColor(Color.BLACK);
	} else {
	    g.setColor(Color.GREEN);
	}
	g.fillOval(this.caseActuelle.getX() * 20,
		this.caseActuelle.getY() * 20, 10, 10);
	g.setColor(c);
    }

    @Override
    public void cycleDeVie() {
	if (this.energie > 0) {
	    Case newCase = this.determinerNeuneuLePlusProche();
	    if (newCase == null) {
		newCase = this.determinerCaseVoisineNeuneu();
	    }
	    if (newCase == null) {
		newCase = this.determinerCaseVoisineAleatoire();
	    }
	    if (this.energie > 50 && newCase.hasNeuneu() && Math.random() < 0.5) {
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
}
