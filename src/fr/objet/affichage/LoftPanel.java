package fr.objet.affichage;

import java.awt.Graphics;
import java.util.List;

import javax.swing.JPanel;

/**
 * Panneau de dessin pour le loft.
 * 
 * @author moreau, Daniel Lefèvre
 */
class LoftPanel extends JPanel {

    /**
     * Version ID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Référence sur la liste des objets à afficher.
     */
    private List<ObjetDessinable> listeObjets;

    /**
     * Constructeur.
     * 
     * @param liste
     *            Référence sur la liste des objets (gérée par la ZoneGraphique
     */
    public LoftPanel(final List<ObjetDessinable> liste) {
	this.listeObjets = liste;
    }

    /**
     * On redéfinit la méthode paint() : elle se contente d'appeler les méthodes
     * dessinerObjet() de la liste d'objets dessinables.
     * 
     * @param g
     *            l'objet Graphics permettant à la méthode de dessiner sur le
     *            JPanel
     */
    @Override
    public void paintComponent(final Graphics g) {
	super.paintComponents(g);

	// on redessine tout
	for (ObjetDessinable x : this.listeObjets) {
	    x.dessinerObjet(g);
	}
    }
}
