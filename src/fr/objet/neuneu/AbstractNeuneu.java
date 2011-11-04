package fr.objet.neuneu;

import fr.objet.general.Case;
import fr.objet.general.Loft;

public abstract class AbstractNeuneu {

    private int energie;
    private int besoinEnergetique;
    private Case caseActuelle;
    private Loft loft;

    public AbstractNeuneu(Case caseActuelleIn, Loft loftIn) {
        this.caseActuelle = caseActuelleIn;
        this.loft = loftIn;
    }

    public abstract void seDeplacer();

    public abstract void manger();

    public void boire() {

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

}
