package fr.objet.affichage;

import java.awt.Graphics;
import java.util.LinkedList;

import javax.swing.JPanel;

/**
 * un panneau de dessin pour le loft
 * 
 * @author moreau
 * 
 */
class LoftPanel extends JPanel {

    private static final long serialVersionUID = 1L;

    /**
     * référence sur la liste des objets à dessiner
     */
    private LinkedList<ObjetDessinable> listeObjets;

    /**
     * constructeur
     * 
     * @param listeObjets
     *            référence sur la liste des objets (gérée par la ZoneGraphique)
     */
    public LoftPanel(LinkedList<ObjetDessinable> listeObjets) {
	this.listeObjets = listeObjets;
    }

    /**
     * on redéfinit la méthode paint() : elle se contente d'appeler les méthodes
     * dessinerObjet() de la liste d'objets dessinables
     */
    public void paintComponent(Graphics g) {
	super.paintComponents(g);

	// on redessine tout
	for (ObjetDessinable x : listeObjets) {
	    x.dessinerObjet(g);
	}
    }
}
