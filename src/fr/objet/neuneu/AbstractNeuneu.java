package fr.objet.neuneu;

import fr.objet.affichage.ObjetDessinable;
import fr.objet.general.Case;
import fr.objet.general.Loft;
import fr.objet.sustentation.Mangeable;

public abstract class AbstractNeuneu implements Mangeable, ObjetDessinable {

    protected int energie;
    protected Case caseActuelle;
    protected Loft loft;

    public AbstractNeuneu(Loft loftIn, Case caseActuelleIn) {
        this.caseActuelle = caseActuelleIn;
        this.loft = loftIn;
    }

    public AbstractNeuneu(Loft loftIn, int x, int y) {
        this.loft = loftIn;
        this.caseActuelle = loftIn.getCase(x, y);
    }

    public void manger(Mangeable bouffe) {
        if (bouffe.getEnergie() > 20) {
            bouffe.consommerEnergie(20);
            this.addEnergie(20);
        }
    }

    public void manger(Case caseC) {
        this.manger(caseC.getNourriture().get(0));
    }

    public void seReproduire(AbstractNeuneu neuneu) {
        this.consommerEnergie(50);
        neuneu.consommerEnergie(50);
        this.loft.add(new Erratique(this.loft, this.caseActuelle));
    }

    public abstract void cycleDeVie();

    public void changerCase(Case newCase) {
        // Sortir de la case actuelle.
        this.caseActuelle.removeNeuneu(this);
        // Aller dans l'autre case.
        newCase.addNeuneu(this);
        // Changer la référence vers la nouvelle case.
        this.caseActuelle = newCase;
    }

    public Case determinerCaseVoisineAleatoire() {
        // Determiner une case voisine random.
        int x, y;
        do {
            x = (int) (Math.random() * 3) - 1;
            y = (int) (Math.random() * 3) - 1;
            // Tant que les chiffres trouvés ne sont pas dans les bounds.
        } while (!this.loft.isInBounds(this.caseActuelle.getX() + x,
                this.caseActuelle.getY() + y));

        return this.loft.getCase(this.caseActuelle.getX() + x,
                this.caseActuelle.getY() + y);
    }

    public Case determinerCaseVoisineNourriture() {
        for (Case voisin : this.caseActuelle.getVoisins()) {
            if (voisin.hasNourriture()) {
                return voisin;
            }
        }
        return null;
    }

    public Case determinerCaseVoisineNeuneu() {
        for (Case voisin : this.caseActuelle.getVoisins()) {
            if (voisin.hasNeuneu()) {
                return voisin;
            }
        }
        return null;
    }

    public void addEnergie(int energieIn) {
        this.energie += energieIn;
    }

    @Override
    public void consommerEnergie(int energieConsommee) {
        this.energie -= energieConsommee;
    }

    @Override
    public int getEnergie() {
        return this.energie;
    }

    public void setEnergie(int energieIn) {
        this.energie = energieIn;
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
