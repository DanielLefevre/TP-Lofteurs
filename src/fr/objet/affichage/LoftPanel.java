package fr.objet.affichage;

import java.awt.Graphics;
import java.util.List;

import javax.swing.JPanel;

/**
 * un panneau de dessin pour le loft
 * 
 * @author moreau
 */
class LoftPanel extends JPanel {

    private static final long serialVersionUID = 1L;

    /**
     * r�f�rence sur la liste des objets � dessiner
     */
    private List<ObjetDessinable> listeObjets;

    /**
     * constructeur
     * 
     * @param liste
     *            r�f�rence sur la liste des objets (g�r�e par la ZoneGraphique)
     */
    public LoftPanel(List<ObjetDessinable> liste) {
        this.listeObjets = liste;
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
