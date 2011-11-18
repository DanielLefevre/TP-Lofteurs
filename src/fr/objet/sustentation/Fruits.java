package fr.objet.sustentation;

import java.awt.Color;

public class Fruits extends AbstractNourriture {

    public Fruits(int valeurEnergetiqueIn) {
        super(valeurEnergetiqueIn);
    }

    @Override
    public Color returnColor() {
        return Color.PINK;
    }
}
