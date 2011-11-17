package fr.objet.sustentation;

import java.awt.Color;

public class Fruits extends AbstractNourriture {

    public Fruits(int valeurEnergetiqueIn) {
	super(valeurEnergetiqueIn);
	// TODO Auto-generated constructor stub
    }

    @Override
    public Color returnColor() {
	return Color.PINK;
    }
}
