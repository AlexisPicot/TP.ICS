package tp.model;

import tp.services.contracts.IValuable;

public class Item {
    private String nom;
    private String description;
    private double poids;
    private double prix;
    
    /**
     * Constructeur de la classe Item
     */
    public Item(String unNom, String uneDescription, double unPoids, double unPrix) {
        this.nom = unNom;
        this.description = uneDescription;
        this.poids = unPoids;
        this.prix = unPrix;
    }

    /**
     * Get/Set
     */
    public String getNom() {
        return this.nom;
    }
    public String getDescription() {
        return this.description;
    }
    public double getPoids() {
        return this.poids;
    }
    public double getPrix() {
        return this.prix;
    }

    /**
     * Fonction qui affiche les stats d'un item. Si l'item affecte les stats des perso on récupère la valeur associée avec l'interface IValuable
     */
    public String getItemsNameAndStats() {
        if (this instanceof IValuable) {
            return this.getNom() + " -> {Description -> " + this.getDescription() + ", Poids -> "+ this.getPoids() + ", Prix -> " + this.getPrix() + ", Valeur -> " +  ((IValuable)this).getValueOfItem() + "}";
        } else {
            return this.getNom() + " -> {Description -> " + this.getDescription() + ", Poids -> "+ this.getPoids() + ", Prix -> " + this.getPrix() + "}";
        }
    }
}
