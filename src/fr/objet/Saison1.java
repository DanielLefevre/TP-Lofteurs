package fr.objet;

import fr.objet.affichage.ZoneGraphique;
import fr.objet.general.Loft;
import fr.objet.neuneu.Cannibale;
import fr.objet.neuneu.Erratique;
import fr.objet.neuneu.Lapin;
import fr.objet.neuneu.Vorace;

/**
 * Classe contenance le main.
 * 
 * @author Daniel Lefèvre
 * 
 */
public final class Saison1 {

    /**
     * Nombre de lofteurs à la création.
     */
    private static final int NOMBRE_LOFTEURS = 30;
    /**
     * Taille du loft.
     */
    private static final int TAILLE_LOFT = 30;
    /**
     * Proportion d'erratiques à la création.
     */
    private static final float PROPORTION_ERRATIQUE = 0f;
    /**
     * Proportion de voraces à la création.
     */
    private static final float PROPORTION_VORACE = 0f;
    /**
     * Proportion de cannibales à la création.
     */
    private static final float PROPORTION_CANNIBALE = 0f;
    /**
     * Proportion de lapins à la création.
     */
    private static final float PROPORTION_LAPIN = 1f;
    /**
     * Proportion de remplissage en nourriture du loft à la création.
     */
    private static final float PROPORTION_NOURRITURE = 0.1f;
    /**
     * Nombre de tours de la partie.
     */
    private static final int NOMBRE_TOURS = 500;

    /**
     * Private useless constructor.
     */
    private Saison1() {
    }

    /**
     * Main.
     * 
     * @param args
     *            not used
     * @throws InterruptedException
     *             if threads sleep doesn't feel good
     */
    public static void main(final String[] args) throws InterruptedException {
        ZoneGraphique zone = new ZoneGraphique("Mon premier loft");
        Loft loft = new Loft(TAILLE_LOFT, zone);
        loft.remplissageAleatoire(PROPORTION_NOURRITURE);
        zone.ajouterObjet(loft);

        for (int i = 0; i < NOMBRE_LOFTEURS; i++) {
            double x = Math.random();
            if (x < PROPORTION_VORACE) {
                loft.add(new Vorace(loft, (int) (Math.random()
                        * Saison1.TAILLE_LOFT - 1), (int) (Math.random()
                        * Saison1.TAILLE_LOFT - 1)));
            } else {
                x -= PROPORTION_VORACE;
                if (x < PROPORTION_ERRATIQUE) {
                    loft.add(new Erratique(loft, (int) (Math.random()
                            * Saison1.TAILLE_LOFT - 1), (int) (Math.random()
                            * Saison1.TAILLE_LOFT - 1)));
                } else {
                    x -= PROPORTION_ERRATIQUE;
                    if (x < PROPORTION_CANNIBALE) {
                        loft.add(new Cannibale(loft, (int) (Math.random()
                                * Saison1.TAILLE_LOFT - 1), (int) (Math
                                .random() * Saison1.TAILLE_LOFT - 1)));
                    } else {
                        x -= PROPORTION_CANNIBALE;
                        if (x < PROPORTION_LAPIN) {
                            loft.add(new Lapin(loft, (int) (Math.random()
                                    * Saison1.TAILLE_LOFT - 1), (int) (Math
                                    .random() * Saison1.TAILLE_LOFT - 1)));
                        }
                    }
                }
            }
        }
        loft.go(Saison1.NOMBRE_TOURS);
    }
}
