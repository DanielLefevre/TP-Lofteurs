package fr.objet.nourriture;

public abstract class AbstractNourriture {

    protected int valeurEnergetique;

    public AbstractNourriture(int valeurEnergetiqueIn) {
        this.setValeurEnergetique(valeurEnergetiqueIn);
    }

    public int getValeurEnergetique() {
        return this.valeurEnergetique;
    }

    public void setValeurEnergetique(int valeurEnergetiqueIn) {
        this.valeurEnergetique = valeurEnergetiqueIn;
    }
}
