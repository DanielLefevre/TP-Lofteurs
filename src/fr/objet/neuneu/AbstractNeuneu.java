package fr.objet.neuneu;

import fr.objet.general.Case;
import fr.objet.general.Loft;
import fr.objet.sustentation.Mangeable;

public abstract class AbstractNeuneu implements Mangeable {

    private int energie;
    private int besoinEnergetique;
    private Case caseActuelle;
    private Loft loft;

    public AbstractNeuneu(Case caseActuelleIn, Loft loftIn) {
        this.caseActuelle = caseActuelleIn;
        this.loft = loftIn;
    }

    public abstract void seDeplacer();

    public abstract void manger(Mangeable bouffe);

    public void boire() {
        if (!this.caseActuelle.getBoissons().isEmpty()) {
            // this.caseActuelle.getBoissons().get(0).consommer(10);
            // FIXME
        }
    }

    public void seReproduire() {

    }

    public int getEnergie() {
        return this.energie;
    }

    public void setEnergie(int energieIn) {
        this.energie = energieIn;
    }

    public int getBesoinEnergetique() {
        return this.besoinEnergetique;
    }

    public void setBesoinEnergetique(int besoinEnergetiqueIn) {
        this.besoinEnergetique = besoinEnergetiqueIn;
    }

    public Case getCaseActuelle() {
        return this.caseActuelle;
    }

    public void setCaseActuelle(Case caseActuelleIn) {
        this.caseActuelle = caseActuelleIn;
    }

    public Loft getLoft() {
        return this.loft;
    }

    public void setLoft(Loft loftIn) {
        this.loft = loftIn;
    }

    public void changerCase(Case newCase) {
        // Sortir de la case actuelle.
        this.caseActuelle.removeNeuneu(this);
        // Aller dans l'autre case.
        newCase.addNeuneu(this);
        this.caseActuelle = newCase;
    }

    public Case determinerCaseAleatoire() {
        // Determiner une case voisine random.
        int x, y;
        do {
            x = (int) (Math.random() * 3) - 1;
            y = (int) (Math.random() * 3) - 1;
        } while (Loft.isInBounds(x, y));

        return this.loft.getCase(x, y);
    }

    public void addEnergie(int energieIn) {
        this.energie += energieIn;
    }

    @Override
    public void diminuerEnergie(int energieIn) {
        this.energie -= energieIn;
    }
}
