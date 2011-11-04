package fr.objet.general;

import java.util.ArrayList;

import fr.objet.nourriture.AbstractNourriture;
import fr.objet.nourriture.Boisson;

public class Case {

    private ArrayList<AbstractNourriture> nourriture;

    public ArrayList<AbstractNourriture> getNourriture() {
        return this.nourriture;
    }

    public void setNourriture(ArrayList<AbstractNourriture> nourritureIn) {
        this.nourriture = nourritureIn;
    }

    public ArrayList<Boisson> getBoissons() {
        ArrayList<Boisson> boissons = new ArrayList<Boisson>();
        for (AbstractNourriture nourriture : this.nourriture) {
            if (nourriture.getClass().equals(Boisson.class)) {
                boissons.add((Boisson) nourriture);
            }
        }
        return boissons;
    }
}
