package fr.objet.sustentation;

import java.awt.Color;

/**
 * Implémente un type particulier de nourriture : de l'alcool.
 * 
 * @author Daniel Lefèvre
 * 
 */
public class Alcool extends AbstractNourriture {

    /**
     * Constructeur.
     */
    public Alcool() {
        super();
    }

    /*
     * (non-Javadoc)
     * 
     * @see fr.objet.sustentation.AbstractNourriture#returnColor()
     */
    @Override
    public final Color returnColor() {
        return Color.ORANGE;
    }
}
