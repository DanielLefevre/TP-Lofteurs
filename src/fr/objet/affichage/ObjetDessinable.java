/**
 * 
 */
package fr.objet.affichage;

import java.awt.Graphics;

/**
 * interface des objets dessinables ; ils devront simplement implanter une
 * m�thode de dessin � partir d'un contexte graphique pass� par l'application
 * 
 * @author moreau
 */
public interface ObjetDessinable {

    /**
     * fonction de dessin ; � surcharger
     * 
     * @param g
     *            le contexte graphique
     */
    public void dessinerObjet(Graphics g);
}
