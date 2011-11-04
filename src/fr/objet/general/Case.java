package fr.objet.general;

import java.util.ArrayList;

import fr.objet.neuneu.AbstractNeuneu;
import fr.objet.sustentation.AbstractNourriture;
import fr.objet.sustentation.Boisson;

public class Case {

    private ArrayList<AbstractNourriture> nourriture;
    private ArrayList<Boisson> boissons;
    private AbstractNeuneu neuneu;

    public void setNeuneu(AbstractNeuneu neuneuIn) {
        this.neuneu = neuneuIn;
    }

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
        return this.boissons;
    }

    @SuppressWarnings("unused")
    public void removeNeuneu(AbstractNeuneu abstractNeuneu) {
        // TODO Auto-generated method stub

    }

    @SuppressWarnings("unused")
    public void addNeuneu(AbstractNeuneu abstractNeuneu) {
        // TODO Auto-generated method stub

    }

    public AbstractNeuneu getNeuneu() {
        return this.neuneu;
    }

    public boolean hasNeuneu() {
        return this.neuneu != null;
    }
}
