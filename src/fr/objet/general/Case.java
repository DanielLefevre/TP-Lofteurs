package fr.objet.general;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import fr.objet.neuneu.AbstractNeuneu;
import fr.objet.sustentation.AbstractNourriture;

public class Case {

    private List<AbstractNourriture> nourriture = new ArrayList<>();
    private List<AbstractNeuneu> neuneus = new ArrayList<>();
    private Loft loft;
    private int x;
    private int y;

    public void setNeuneu(ArrayList<AbstractNeuneu> neuneusIn) {
        this.setNeuneus(neuneusIn);
    }

    public Case(Loft loftIn, int xIn, int yIn) {
        this.loft = loftIn;
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

    public List<AbstractNourriture> getNourriture() {
        return this.nourriture;
    }

    public void setNourriture(ArrayList<AbstractNourriture> nourritureIn) {
        this.nourriture = nourritureIn;
    }

    public void removeNeuneu(AbstractNeuneu abstractNeuneu) {
        this.neuneus.remove(abstractNeuneu);
    }

    public void addNeuneu(AbstractNeuneu abstractNeuneu) {
        this.neuneus.add(abstractNeuneu);
        // TODO : gérer les 1 neuneu par Case.
    }

    public boolean hasNeuneu() {
        return !this.neuneus.isEmpty();
    }

    public List<AbstractNeuneu> getNeuneus() {
        return this.neuneus;
    }

    public void setNeuneus(ArrayList<AbstractNeuneu> neuneusIn) {
        this.neuneus = neuneusIn;
    }

    public boolean hasNourriture() {
        return !this.nourriture.isEmpty();
    }

    public void addNourriture(AbstractNourriture nourritureIn) {
        this.nourriture.add(nourritureIn);
    }

    public void dessinerObjet(Graphics g) {
        for (AbstractNourriture nourritureOut : this.nourriture) {
            Color c = g.getColor();
            g.setColor(nourritureOut.returnColor());
            g.fillOval(this.x * 5, this.y * 5, 20, 20);
            g.setColor(c);
        }
    }

    public ArrayList<Case> getVoisins() {
        ArrayList<Case> voisins = new ArrayList<>();
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (this.loft.isInBounds(this.x + i, this.y + j)) {
                    voisins.add(this.loft.getCase(this.x + i, this.y + j));
                }
            }
        }
        return voisins;
    }
}
