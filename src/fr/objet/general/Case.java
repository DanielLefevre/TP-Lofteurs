package fr.objet.general;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import fr.objet.neuneu.AbstractNeuneu;
import fr.objet.sustentation.AbstractNourriture;

public class Case {

    private AbstractNourriture nourriture;
    private List<AbstractNeuneu> neuneus = new ArrayList<>();
    private Loft loft;
    private int x;
    private int y;

    public Case(Loft loftIn, int xIn, int yIn) {
        this.loft = loftIn;
        this.x = xIn;
        this.y = yIn;
    }

    public void addNeuneu(AbstractNeuneu abstractNeuneu) {
        this.neuneus.add(abstractNeuneu);
    }

    public void dessinerObjet(Graphics g) {
        if (this.nourriture != null && this.nourriture.getEnergie() > 0) {
            Color c = g.getColor();
            g.setColor(this.nourriture.returnColor());
            g.fillOval(this.x * 20, this.y * 20, 8, 8);
            g.setColor(c);
        }
    }

    public double distance(Case c) {
        return Math.sqrt(Math.pow(this.x - c.x, 2) + Math.pow(this.y - c.y, 2));
    }

    public AbstractNeuneu getNeuneu() {
        return this.neuneus.get(0);
    }

    public List<AbstractNeuneu> getNeuneus() {
        return this.neuneus;
    }

    public AbstractNourriture getNourriture() {
        return this.nourriture;
    }

    public ArrayList<Case> getVoisins() {
        ArrayList<Case> voisins = new ArrayList<>();
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (this.loft.isInBounds(this.x + i, this.y + j)
                        && (i != 0 || j != 0)) {
                    if (this.loft.getCase(this.x + i, this.y + j) == null) {
                        System.out.println();
                    }
                    voisins.add(this.loft.getCase(this.x + i, this.y + j));
                }
            }
        }
        return voisins;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public boolean hasNeuneu() {
        return !this.neuneus.isEmpty();
    }

    public boolean hasNourriture() {
        return this.nourriture != null && this.nourriture.getEnergie() > 0;
    }

    public void removeNeuneu(AbstractNeuneu abstractNeuneu) {
        this.neuneus.remove(abstractNeuneu);
    }

    public void setNeuneu(ArrayList<AbstractNeuneu> neuneusIn) {
        this.setNeuneus(neuneusIn);
    }

    public void setNeuneus(ArrayList<AbstractNeuneu> neuneusIn) {
        this.neuneus = neuneusIn;
    }

    public void setNourriture(AbstractNourriture nourritureIn) {
        this.nourriture = nourritureIn;
    }

    public void setX(int xIn) {
        this.x = xIn;
    }

    public void setY(int yIn) {
        this.y = yIn;
    }

    public final class NoPlaceForNeuneuException extends Exception {

        private static final long serialVersionUID = 1L;
    }
}
