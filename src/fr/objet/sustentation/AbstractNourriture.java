package fr.objet.sustentation;

import java.awt.Color;

public abstract class AbstractNourriture implements Mangeable {

    protected int valeurEnergetique;

    public AbstractNourriture(int valeurEnergetiqueIn) {
        this.valeurEnergetique = valeurEnergetiqueIn;
    }

    @Override
    public void consommerEnergie(int energie) {
        this.valeurEnergetique -= energie;
    }

    @Override
    public int getEnergie() {
        return this.valeurEnergetique;
    }

    public int getValeurEnergetique() {
        return this.valeurEnergetique;
    }

    public abstract Color returnColor();

    public void setValeurEnergetique(int valeurEnergetiqueIn) {
        this.valeurEnergetique = valeurEnergetiqueIn;
    }
}
