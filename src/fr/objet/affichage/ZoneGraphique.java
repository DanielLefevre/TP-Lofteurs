package fr.objet.affichage;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.LinkedList;

import javax.swing.JFrame;

import fr.objet.general.Case;
import fr.objet.general.Loft;
import fr.objet.neuneu.AbstractNeuneu;

/**
 * une classe comportant une zone graphique dans laquelle on peut dessiner ; le
 * dessin est refait automatiquement par la classe Panel associ�e ; tous les
 * objets de type ObjetDessinable ajout�s � la liste sont redessin�s par un
 * appel � leur m�thode dessinerObjet(Graphics g)
 * 
 * @see ObjectDessinable,LoftPanel
 * @author moreau
 */
public class ZoneGraphique extends JFrame {

    private static final long serialVersionUID = 1L;

    /**
     * la liste d'objets � dessiner
     */
    LinkedList<ObjetDessinable> liste;

    /**
     * constructeur
     * 
     * @param titre
     *            le nom de l'application
     */
    public ZoneGraphique(String titre) {
        // appel au constructeur de base
        super(titre);

        // ajout d'une taille par d�faut
        this.setSize(600, 600);

        // cr�ation de la liste d'objets
        this.liste = new LinkedList<ObjetDessinable>();

        // ajout d'un listener
        this.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        // cr�ation du panneau
        LoftPanel a = new LoftPanel(this.liste);
        this.getContentPane().add(a);

        this.setVisible(true);
    }

    /**
     * ajout d'un objet dans la zone graphique
     */
    public void ajouterObjet(ObjetDessinable o) {
        this.liste.add(o);
    }

    /**
     * largeur de la partie dessinable
     */
    @Override
    public int getWidth() {
        return this.getContentPane().getWidth();
    }

    /**
     * hauteur de la partie dessinable
     */
    @Override
    public int getHeight() {
        return this.getContentPane().getHeight();
    }

    public void majObjets(Loft loft) {
        this.liste.clear();
        for (AbstractNeuneu neuneu : loft.getNeuneus()) {
            this.ajouterObjet(neuneu);
        }
        for (Case[] caseC : loft.getListeCases()) {
            for (Case caseCC : caseC) {
                this.ajouterObjet(caseCC);
            }
        }
    }
}
