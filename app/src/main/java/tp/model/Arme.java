package tp.model;

import tp.services.contracts.IValuable;

/**
 * Armes du personnages
 */
public class Arme extends Item implements IValuable {

    private int degats;
    
    public Arme(String unNom, String uneDescription, double unPoids, double unPrix, int desDegats) {
        super(unNom, uneDescription, unPoids, unPrix);
        this.degats = desDegats;
    }

    /**
     * Récupère la valeur du dégat de l'arme
     */
    public int getValueOfItem() {
        return getDegats();
    }

    public int getDegats() {
        return degats;
    }
}
