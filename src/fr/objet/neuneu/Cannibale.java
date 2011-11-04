package fr.objet.neuneu;

import fr.objet.general.Case;
import fr.objet.general.Loft;

public class Cannibale extends AbstractNeuneu {

    public Cannibale(Case caseActuelleIn, Loft loftIn) {
        super(caseActuelleIn, loftIn);
    }

    @Override
    public void seDeplacer() {
        this.seDeplacerAleatoirement();
    }

    @Override
    public void manger() {

    }

}
