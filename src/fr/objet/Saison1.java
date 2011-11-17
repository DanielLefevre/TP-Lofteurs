package fr.objet;

import fr.objet.affichage.ZoneGraphique;
import fr.objet.general.Loft;
import fr.objet.neuneu.Cannibale;
import fr.objet.neuneu.Erratique;
import fr.objet.neuneu.Vorace;

public class Saison1 {

    public static int nombreLofteurs = 10;
    public static int tailleLoft = 30;
    public static float proportionErratique = 0f;
    public static float proportionVorace = 1f;
    public static float proportionCannibale = 0f;

    public static void main(String[] args) throws InterruptedException {
	ZoneGraphique zone = new ZoneGraphique("Mon premier loft");
	Loft loft = new Loft(tailleLoft, zone);
	loft.remplissageAleatoire(0.1f);
	zone.ajouterObjet(loft);

	for (int i = 0; i < nombreLofteurs; i++) {
	    double x = Math.random();
	    if (x < proportionVorace) {
		loft.add(new Vorace(loft, (int) (Math.random() * 29),
			(int) (Math.random() * 29)));
	    } else {
		x -= proportionVorace;
		if (x < proportionErratique) {
		    loft.add(new Erratique(loft, (int) (Math.random() * 29),
			    (int) (Math.random() * 29)));
		} else {
		    x -= proportionErratique;
		    if (x < proportionCannibale) {
			loft.add(new Cannibale(loft,
				(int) (Math.random() * 29), (int) (Math
					.random() * 29)));
		    }
		}
	    }
	}
	loft.go();
    }
}