package fr.objet.general;

import java.util.ArrayList;

import fr.objet.neuneu.AbstractNeuneu;

public class Case {

    private ArrayList<AbstractNourriture> nourriture;
    private int x;
    private int y;

    public Case(int xIn, int yIn) {
        this.x = xIn;
        this.y = yIn;
    }

    public int getX() {
        return this.x;
    }

    public void setX(int xIn) {
        this.x = xIn;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int yIn) {
        this.y = yIn;
    }

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

    public void removeNeuneu(AbstractNeuneu abstractNeuneu) {
        // TODO Auto-generated method stub

    }

    public void addNeuneu(AbstractNeuneu abstractNeuneu) {
        // TODO Auto-generated method stub

    }
}
