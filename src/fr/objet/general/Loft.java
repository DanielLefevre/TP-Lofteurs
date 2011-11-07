package fr.objet.general;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import fr.objet.affichage.ObjetDessinable;
import fr.objet.affichage.ZoneGraphique;
import fr.objet.neuneu.AbstractNeuneu;
import fr.objet.sustentation.Fruits;

public class Loft implements ObjetDessinable {

    private Case[][] listeCases;
    private int hauteur;
    private int largeur;
    private List<AbstractNeuneu> neuneus = new ArrayList<>();
    private ZoneGraphique zone;

    public boolean isInBounds(int x, int y) {
        return x > 0 && x < this.largeur && y > 0 && y < this.hauteur;
    }

    public Case getCase(int x, int y) {
        return this.listeCases[x][y];
    }

    public Loft(int tailleIn, ZoneGraphique zoneIn) {
        this.hauteur = tailleIn;
        this.largeur = tailleIn;
        this.listeCases = new Case[tailleIn][tailleIn];
        for (int i = 0; i < tailleIn; i++) {
            for (int j = 0; j < tailleIn; j++) {
                this.listeCases[i][j] = new Case(this, i, j);
            }
        }
        this.zone = zoneIn;
    }

    public int getHauteur() {
        return this.hauteur;
    }

    public int getLargeur() {
        return this.largeur;
    }

    public void setHauteur(int hauteurIn) {
        this.hauteur = hauteurIn;
    }

    public void setLargeur(int largeurIn) {
        this.largeur = largeurIn;
    }

    public void remplissageAleatoire(float pourcentage) {
        for (int i = 0; i < (int) pourcentage * this.hauteur * this.largeur; i++) {
            this.listeCases[(int) (Math.random() * this.largeur)][(int) (Math
                    .random() * this.hauteur)].addNourriture(new Fruits(100));
        }
    }

    public void add(AbstractNeuneu neuneu) {
        this.neuneus.add(neuneu);
    }

    @Override
    public void dessinerObjet(Graphics g) {
        for (Case[] cases : this.listeCases) {
            for (Case uneCase : cases) {
                uneCase.dessinerObjet(g);
            }
        }
        for (AbstractNeuneu neuneu : this.neuneus) {
            neuneu.dessinerObjet(g);
        }
    }

    public List<AbstractNeuneu> getNeuneus() {
        return this.neuneus;
    }

    public void go() {
        for (int i = 0; i < 20; i++) {
            for (AbstractNeuneu neuneu : this.neuneus) {
                neuneu.cycleDeVie();
            }
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            this.zone.repaint();
        }
    }

    public Case[][] getListeCases() {
        return this.listeCases;
    }
}
