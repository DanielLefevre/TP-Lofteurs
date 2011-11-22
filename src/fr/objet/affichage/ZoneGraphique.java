package fr.objet.affichage;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JFrame;

/**
 * Une classe comportant une zone graphique dans laquelle on peut dessiner ; le
 * dessin est refait automatiquement par la classe Panel associée ; tous les
 * objets de type ObjetDessinable ajoutés à la liste sont redessinés par un
 * appel à leur m�thode dessinerObjet(Graphics g).
 * 
 * @see ObjectDessinable,LoftPanel
 * @author moreau,
 */
public class ZoneGraphique extends JFrame {

    /**
     * Taille de la zone graphique.
     */
    private static final int SIZE = 700;

    /**
     * Version ID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * La liste d'objets à dessiner.
     */
    private List<ObjetDessinable> liste;

    /**
     * Constructeur.
     * 
     * @param titre
     *            le nom de l'application
     */
    public ZoneGraphique(final String titre) {
        // appel au constructeur de base
        super(titre);

        // ajout d'une taille par d�faut
        this.setSize(ZoneGraphique.SIZE, ZoneGraphique.SIZE);

        // cr�ation de la liste d'objets
        this.liste = new LinkedList<>();

        // ajout d'un listener
        this.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(final WindowEvent e) {
                System.exit(0);
            }
        });

        // cr�ation du panneau
        LoftPanel a = new LoftPanel(this.liste);
        this.getContentPane().add(a);

        this.setVisible(true);
    }

    /**
     * Ajout d'un objet dans la zone graphique.
     * 
     * @param o
     *            l'objet dessinable à ajouter à la liste des objets à afficher
     */
    public final void ajouterObjet(final ObjetDessinable o) {
        this.liste.add(o);
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.awt.Component#getHeight()
     */
    @Override
    public final int getHeight() {
        return this.getContentPane().getHeight();
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.awt.Component#getWidth()
     */
    @Override
    public final int getWidth() {
        return this.getContentPane().getWidth();
    }
}
