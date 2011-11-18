package fr.objet.sustentation;

import java.awt.Color;

/**
 * Implémente un type particulier de nourriture : les fruits.
 * 
 * @author Daniel Lefèvre
 * 
 */
public class Fruits extends AbstractNourriture {

    /**
     * Constructeur.
     */
    public Fruits() {
        super();
    }

    /*
     * (non-Javadoc)
     * 
     * @see fr.objet.sustentation.AbstractNourriture#returnColor()
     */
    @Override
    public final Color returnColor() {
        return Color.PINK;
    }
}
