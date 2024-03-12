package tp;

import java.util.EnumMap;
import java.util.Map;

public class Personnage {
    public int x;
    public int y;
    private String nom;
    private Map<Competence, Integer> competences;
    private int pointsRestants = 20;

    // Constructeur
    public Personnage(String nom) {
        this.nom = nom;
        this.competences = new EnumMap<>(Competence.class);
        // Initialisation des compétences avec des valeurs par défaut
        initialiserCompetences();
    }

    // Méthode privée pour initialiser les compétences avec des valeurs par défaut
    private void initialiserCompetences() {
        for (Competence competence : Competence.values()) {
            competences.put(competence, 3);
        }
    }

    // Méthode pour augmenter le niveau d'une compétence
    public void augmenterCompetence(Competence competence, int points) {
        if (competences.containsKey(competence) == false) {
            throw new IllegalArgumentException("La compétence " + competence + " n'existe pas.");
        }
        Integer niveauActuel = competences.get(competence);
        Integer nouveauNiveau = niveauActuel + points;
        if (nouveauNiveau < 3 || nouveauNiveau > 15) {
            throw new IllegalArgumentException("La valeur de la compétence doit être entre 3 et 15.");
        }

        pointsRestants -= points;
        competences.put(competence, nouveauNiveau);
    }

    public int getNiveauCompetence(Competence competence) {
        return competences.get(competence);
    }

    // Méthode pour afficher les compétences du personnage
    public void afficherCompetences() {
        System.out.println("Compétences de " + nom + " :");
        for (Competence competence : Competence.values()) {
            System.out.println(String.format("%-10s \t niveau : %d",competence, getNiveauCompetence(competence)));
        }
    }

    public int getPointsRestants() {
        return pointsRestants;
    }


}
