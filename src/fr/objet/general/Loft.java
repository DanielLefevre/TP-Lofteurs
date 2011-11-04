package fr.objet.general;

public class Loft {

    private Case[][] listeCases;
    private int hauteur;
    private int largeur;

    public Case[][] getListeCases() {
        return this.listeCases;
    }

    public void setListeCases(Case[][] listeCasesIn) {
        this.listeCases = listeCasesIn;
    }

    public int getLargeur() {
        return this.largeur;
    }

    public void setLargeur(int largeurIn) {
        this.largeur = largeurIn;
    }

    public int getHauteur() {
        return this.hauteur;
    }

    public void setHauteur(int hauteurIn) {
        this.hauteur = hauteurIn;
    }
}
