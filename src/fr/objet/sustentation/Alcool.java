package fr.objet.sustentation;

import java.awt.Color;

public class Alcool extends AbstractNourriture {

    public Alcool(int valeurEnergetiqueIn) {
        super(valeurEnergetiqueIn);
    }

    @Override
    public Color returnColor() {
        return Color.ORANGE;
    }
}
