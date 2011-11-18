package fr.objet.sustentation;

import java.awt.Color;

/**
 * Implémente une abstraction de nourriture.
 * 
 * @author Daniel Lefèvre
 * 
 */
public abstract class AbstractNourriture implements Mangeable {

    /**
     * La valeur énergétique de la nourriture.
     */
    private int valeurEnergetique;
    /**
     * L'énergie de départ de chaque nourriture créée.
     */
    private static final int ENERGIE_DEPART = 20;

    /**
     * Constructeur.
     */
    public AbstractNourriture() {
        this.valeurEnergetique = AbstractNourriture.ENERGIE_DEPART;
    }

    /*
     * (non-Javadoc)
     * 
     * @see fr.objet.sustentation.Mangeable#consommerEnergie(int)
     */
    @Override
    public final void consommerEnergie(final int energie) {
        this.valeurEnergetique -= energie;
    }

    /*
     * (non-Javadoc)
     * 
     * @see fr.objet.sustentation.Mangeable#getEnergie()
     */
    @Override
    public final int getEnergie() {
        return this.valeurEnergetique;
    }

    /**
     * Getter.
     * 
     * @return la valeur énergétique de la nourriture
     */
    public final int getValeurEnergetique() {
        return this.valeurEnergetique;
    }

    /**
     * Méthode abstraite : chaque type de nourriture doit choisir une couleur à
     * renvoyer pour l'affichage.
     * 
     * @return la couleur de la nourriture
     */
    public abstract Color returnColor();

    /**
     * Setter.
     * 
     * @param valeurEnergetiqueIn
     *            la valeur de cette nourriture
     */
    public final void setValeurEnergetique(final int valeurEnergetiqueIn) {
        this.valeurEnergetique = valeurEnergetiqueIn;
    }
}
