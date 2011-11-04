package fr.objet.neuneu;

import fr.objet.general.Case;
import fr.objet.general.Loft;
import fr.objet.sustentation.Mangeable;

public class Cannibale extends AbstractNeuneu {

    public Cannibale(Case caseActuelleIn, Loft loftIn) {
        super(caseActuelleIn, loftIn);
    }

    @Override
    public void seDeplacer() {
        Case newCase = this.determinerCaseAleatoire();
        if (newCase.hasNeuneu() && Math.random() < 0.3) {
            this.manger(newCase.getNeuneu());
        }
    }

    @Override
    public void manger(Mangeable bouffe) {
        if (bouffe.getClass() == AbstractNeuneu.class) {
            AbstractNeuneu neuneu = (AbstractNeuneu) bouffe;
            this.addEnergie(neuneu.getEnergie());
            neuneu.setEnergie(0);
        } else {
            bouffe.diminuerEnergie(30);
        }
    }
}
