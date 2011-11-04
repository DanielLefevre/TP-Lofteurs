/**
 * 
 */
package fr.objet.affichage;

import java.awt.Graphics;

/**
 * interface des objets dessinables ; ils devront simplement implanter une
 * méthode de dessin à partir d'un contexte graphique passé par l'application
 * 
 * @author moreau
 * 
 */
public interface ObjetDessinable {
    /**
     * fonction de dessin ; à surcharger
     * 
     * @param g
     *            le contexte graphique
     */
    public void dessinerObjet(Graphics g);

}
