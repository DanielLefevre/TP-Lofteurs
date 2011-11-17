package fr.objet.neuneu;

import fr.objet.affichage.ObjetDessinable;
import fr.objet.general.Case;
import fr.objet.general.Loft;
import fr.objet.sustentation.Mangeable;

public abstract class AbstractNeuneu implements Mangeable, ObjetDessinable {

    protected int energie;
    protected Case caseActuelle;
    protected Loft loft;

    protected static final int ENERGIE_DEPART = 20;

    public AbstractNeuneu(Loft loftIn, Case caseActuelleIn) {
	this.caseActuelle = caseActuelleIn;
	this.loft = loftIn;
	this.energie = AbstractNeuneu.ENERGIE_DEPART;
    }

    public AbstractNeuneu(Loft loftIn, int x, int y) {
	this.loft = loftIn;
	this.caseActuelle = loftIn.getCase(x, y);
	this.energie = AbstractNeuneu.ENERGIE_DEPART;
    }

    public void manger(Mangeable bouffe) {
	if (bouffe.getEnergie() > 0) {
	    if (bouffe.getEnergie() > 10) {
		bouffe.consommerEnergie(10);
		this.addEnergie(10);
	    } else {
		this.addEnergie(bouffe.getEnergie());
		bouffe.consommerEnergie(bouffe.getEnergie());
	    }
	}
    }

    public void manger(Case c) {
	this.manger(c.getNourriture());
    }

    public void seReproduire(AbstractNeuneu neuneu) {
	this.consommerEnergie(10);
	neuneu.consommerEnergie(10);
	this.loft.add(new Erratique(this.loft, this.caseActuelle));
    }

    public abstract void cycleDeVie();

    public void changerCase(Case newCase) {
	// Sortir de la case actuelle.
	this.caseActuelle.removeNeuneu(this);
	// Aller dans l'autre case.
	newCase.addNeuneu(this);
	// Changer la référence vers la nouvelle case.
	this.caseActuelle = newCase;
    }

    public Case determinerCaseVoisineAleatoire() {
	// Determiner une case voisine random.
	int x, y;
	do {
	    x = (int) (Math.random() * 3) - 1;
	    y = (int) (Math.random() * 3) - 1;
	    // Tant que les chiffres trouv�s ne sont pas dans les bounds.
	} while (!this.loft.isInBounds(this.caseActuelle.getX() + x,
		this.caseActuelle.getY() + y) || x == 0 || y == 0);

	return this.loft.getCase(this.caseActuelle.getX() + x,
		this.caseActuelle.getY() + y);
    }

    public Case determinerCaseVersNourriture() {
	double distanceMin = this.loft.getHauteur() * this.loft.getLargeur();
	Case but = null;
	for (Case[] ligne : this.loft.getListeCases()) {
	    for (Case c : ligne) {
		if (c.hasNourriture() && c != this.caseActuelle
			&& c.distance(this.caseActuelle) < distanceMin) {
		    distanceMin = c.distance(this.caseActuelle);
		    but = c;
		}
	    }
	}

	if (but == null) {
	    // S'il n'y a plus de nourriture.
	    return null;
	}

	// idéale est la case la plus proche avec de la nourriture. Il faut
	// maintenant trouver comment y aller.
	Case idéale = null;
	for (Case c : this.caseActuelle.getVoisins()) {
	    if (c.distance(but) < distanceMin) {
		distanceMin = c.distance(but);
		idéale = c;
	    }
	}
	return idéale;
    }

    public Case determinerCaseVoisineNeuneu() {
	for (Case voisin : this.caseActuelle.getVoisins()) {
	    if (voisin.hasNeuneu()) {
		return voisin;
	    }
	}
	return null;
    }

    public void addEnergie(int energieIn) {
	this.energie += energieIn;
    }

    @Override
    public void consommerEnergie(int energieConsommee) {
	this.energie -= energieConsommee;
    }

    @Override
    public int getEnergie() {
	return this.energie;
    }

    public void setEnergie(int energieIn) {
	this.energie = energieIn;
    }

    public Case getCaseActuelle() {
	return this.caseActuelle;
    }

    public void setCaseActuelle(Case caseActuelleIn) {
	this.caseActuelle = caseActuelleIn;
    }

    public Loft getLoft() {
	return this.loft;
    }

    public void setLoft(Loft loftIn) {
	this.loft = loftIn;
    }

    public final class NoMoreNourritureException extends Exception {

	private static final long serialVersionUID = 1L;
    }
}
