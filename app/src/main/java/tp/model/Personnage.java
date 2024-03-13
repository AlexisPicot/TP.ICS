package tp.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tp.CoordStruct;
import tp.util.MessageService;

import java.util.*;

@Component
public abstract class Personnage {
    private int x;
    private int y;
    private String nom;
    private Map<Competence, Integer> competences;

    private Optional<Arme> arme = Optional.empty();
    private Optional<Armure> armure = Optional.empty();

    private Set<Item> inventaire = new HashSet<>();

    private int niveauExperience = 0;

    private int pointsDeVie;

    private int degats;
    private int pointsRestants = 21;

    /**
     * Constructeur de la classe Personne
     */
    public Personnage(String nom) {
        this.nom = nom;
        this.competences = new EnumMap<>(Competence.class);
        initialiserCompetences();
    }

    /**
     * Boost de competences
     */
    public abstract void boostDeCompetences();

    /**
     * Augmente une compétence
     *
     * @return Le nom de la personne
     */
    public String getNom() {
        return nom;
    }

    /**
     * Initialise une compétence
     */
    private void initialiserCompetences() {
        for (Competence competence : Competence.values()) {
            competences.put(competence, 3);
        }
    }

    /**
     * Augmente une compétence
     *
     * @param competence    Une compétence
     * @param nouveauNiveau Les points donné en plus à cette compétence
     */
    public void augmenterCompetence(Competence competence, int nouveauNiveau) {
        int laCompetenceAAmeliorer = getNiveauCompetence(competence);
        var delta = (nouveauNiveau - laCompetenceAAmeliorer);
        laCompetenceAAmeliorer += nouveauNiveau;
        pointsRestants -= delta;
        competences.replace(competence, laCompetenceAAmeliorer + delta);
    }

    /**
     * Retourne le niveau de chaque compétence
     *
     * @return Le niveau de la compétence
     */
    public int getNiveauCompetence(Competence competence) {
        return competences.get(competence);
    }


    private MessageService messageService;

    /**
     * Affiche les compétences d'un personnage
     */
    public void afficherCompetences() {
        ANSIColors couleur = new ANSIColors();

        couleur.violet("Compétences de " + nom + " :");
        int index = 1;
        for (Competence competence : Competence.values()) {
            couleur.vert(String.format("%d # %-11s \t -> %d", index, competence, getNiveauCompetence(competence)));
            index += 1;
        }
    }

    /**
     * Affiche les différentes classes de personnages
     */
    public void afficherClasses() {
        ANSIColors couleur = new ANSIColors();

        couleur.cyan("Classes :");
        int index = 1;
        for (Competence competence : Competence.values()) {
            couleur.vert(String.format("%d # %-11s \t -> %d", index, competence, getNiveauCompetence(competence)));
            index += 1;
        }
    }

    /**
     * Vérifie que seuls les points de départ sont dépensés sur les compétences
     */
    public boolean verifiePointsCompetences(int pointsDeDepart, int pointsEntrerParJoueur, int pointsDeDepartBase) {
        int pointsDeToutesLesCompetences = 0;
        for (Competence competence : Competence.values()) {
            pointsDeToutesLesCompetences += getNiveauCompetence(competence);
        }

        int pointsTotauxEnregistres = pointsDeToutesLesCompetences + pointsDeDepart;

        if (pointsTotauxEnregistres != pointsDeDepartBase) {
            return false;
        } else {
            if (pointsDeDepart >= 0) {
                return true;
            } else {
                return false;
            }
        }
    }

    /**
     * Equipe une arme
     */
    public void equiperArme(Arme uneArme) {
        this.arme = Optional.ofNullable(uneArme);
    }

    /**
     * Equipe une armure
     */
    public void equiperArmure(Armure uneArmure) {
        this.armure = Optional.ofNullable(uneArmure);
    }

    /**
     * Get/Set
     */
    public Optional<Arme> getArme() {
        return this.arme;
    }

    public Optional<Armure> getArmure() {
        return this.armure;
    }

    public int getPointsDeVie() {
        return 100 + getNiveauCompetence(Competence.FORCE) * 10;
    }

    public int getDegats() {
        return getNiveauCompetence(Competence.FORCE) + (arme.map(e->e.getDegats()).orElse(0));
    }

    public int getIntelligence() {
        return getNiveauCompetence(Competence.INTELLIGENCE);
    }

    public int getChance() {
        return getNiveauCompetence(Competence.CHANCE);
    }

    public int getNiveauExperience() {
        return niveauExperience;
    }

    public void setNiveauExperience(int niveauEnPlus) {
        this.niveauExperience = this.niveauExperience + niveauEnPlus;
    }

    /**
     * Ajoute à l'inventaire
     */
    public void ajouterALInventaire(Item unItem) {
        inventaire.add(unItem);
    }

    /**
     * Affiche l'inventaire
     */
    public void afficherInventaire() {
        inventaire.stream().map(Item::getItemsNameAndStats).forEach(System.out::println);
    }

    public void afficherInventaireTri(Set<Item> inventaireTri) {
        inventaireTri.stream().map(Item::getItemsNameAndStats).forEach(System.out::println);
    }

    /**
     * Tri des items
     */
    public Set<Item> trierInventaireParPrix() {
        Set<Item> inventaireTri = new TreeSet<>(Comparator.comparingDouble(Item::getPrix));
        inventaireTri.addAll(inventaire);
        return inventaireTri;
    }

    public Set<Item> trierInventaireParPoids() {
        Set<Item> inventaireTri = new TreeSet<>(Comparator.comparingDouble(Item::getPoids));
        inventaireTri.addAll(inventaire);
        return inventaireTri;
    }

    public Set<Item> trierInventaireArmes() {
        Set<Item> inventaireTri = new HashSet<>();
        for (Item element : inventaire) {
            if (element instanceof Arme) {
                inventaireTri.add(element);
            }
        }
        return inventaireTri;
    }

    public Set<Item> trierInventaireArmures() {
        Set<Item> inventaireTri = new HashSet<>();
        for (Item element : inventaire) {
            if (element instanceof Armure) {
                inventaireTri.add(element);
            }
        }
        return inventaireTri;
    }

    public Set<Item> trierInventaireValeurArmes() {
        Set<Item> inventaireTri = new TreeSet<>(Comparator.comparingInt(item -> {
            if (item instanceof Arme) {
                return ((Arme) item).getValueOfItem();
            }
            return 0;
        }));

        for (Item element : inventaire) {
            if (element instanceof Arme) {
                inventaireTri.add(element);
            }
        }

        return inventaireTri;
    }

    public Set<Item> trierInventaireValeurArmures() {
        Set<Item> inventaireTri = new TreeSet<>(Comparator.comparingInt(item -> {
            if (item instanceof Armure) {
                return ((Armure) item).getValueOfItem();
            }
            return 0;
        }));

        for (Item element : inventaire) {
            if (element instanceof Armure) {
                inventaireTri.add(element);
            }
        }

        return inventaireTri;
    }

    @Autowired
    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }

    public int getPointsRestants() {
        return pointsRestants;
    }


    public void move(int x, int y) {
        this.x += x;
        this.y += y;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public CoordStruct getPosition() {
        return new CoordStruct(x, y);
    }
}
