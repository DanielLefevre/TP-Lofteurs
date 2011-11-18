package fr.objet.sustentation;

/**
 * Interface permettant de spécifier que l'objet peut être mangé.
 * 
 * @author Daniel Lefèvre
 * 
 */
public interface Mangeable {

    /**
     * Maximum quantity of energy eatable at one time.
     */
    int MAX_MANGEABLE = 0;

    /**
     * Consomme l'énergie de l'objet durant le repas.
     * 
     * @param energie
     *            l'énergie consommée
     */
    void consommerEnergie(int energie);

    /**
     * Renvoie l'énergie qui peut être mangée de l'objet.
     * 
     * @return l'énergie disponible
     */
    int getEnergie();
}
