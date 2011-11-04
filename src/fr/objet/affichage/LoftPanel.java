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
     * r�f�rence sur la liste des objets � dessiner
     */
    private LinkedList<ObjetDessinable> listeObjets;

    /**
     * constructeur
     * 
     * @param listeObjetsIn
     *            r�f�rence sur la liste des objets (g�r�e par la ZoneGraphique)
     */
    public LoftPanel(LinkedList<ObjetDessinable> listeObjetsIn) {
	this.listeObjets = listeObjetsIn;
    }

    /**
     * on red�finit la m�thode paint() : elle se contente d'appeler les m�thodes
     * dessinerObjet() de la liste d'objets dessinables
     */
    @Override
    public void paintComponent(Graphics g) {
	super.paintComponents(g);

	// on redessine tout
	for (ObjetDessinable x : this.listeObjets) {
	    x.dessinerObjet(g);
	}
    }
}
