package fr.objet.affichage;

import java.awt.Graphics;

/**
 * Interface des objets dessinables ; ils devront simplement implanter une
 * méthode de dessin à partir d'un contexte graphique passé par l'application.
 * 
 * @author moreau, Daniel Lefèvre
 */
public interface ObjetDessinable {

    /**
     * Taille du cercle représentant de la nourriture.
     */
    int TAILLE_CERCLE_NOURRITURE = 8;
    /**
     * Taille du cercle représentant un neuneu.
     */
    int TAILLE_CERCLE_NEUNEU = 8;
    /**
     * Taille d'une case.
     */
    int TAILLE_CASE = 20;

    /**
     * Fonction de dessin ; à surchager.
     * 
     * @param g
     *            le contexte graphique
     */
    void dessinerObjet(Graphics g);
}
