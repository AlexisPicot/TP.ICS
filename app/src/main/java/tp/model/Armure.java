package tp.model;

import tp.services.contracts.IValuable;

/**
 * Armures du personnages
 */
public class Armure extends Item implements IValuable {

    private int protection;
    
    public Armure(String unNom, String uneDescription, double unPoids, double unPrix, int uneProtection) {
        super(unNom, uneDescription, unPoids, unPrix);
        this.protection = uneProtection;
    }

    /**
     * Récupère la valeur du dégat de l'armure
     */
    public int getValueOfItem() {
        return this.protection;
    }
}
