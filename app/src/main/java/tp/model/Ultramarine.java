package tp.model;

class Ultramarine extends Personnage {

    public Ultramarine(String nom) {
        super(nom);
        augmenterCompetence(Competence.FORCE, 50);
        augmenterCompetence(Competence.PERCEPTION, 25);
        augmenterCompetence(Competence.ENDURANCE, 25);
        augmenterCompetence(Competence.CHARISME, 100);
        augmenterCompetence(Competence.INTELLIGENCE, 50);
        augmenterCompetence(Competence.AGILITE, 5);
        augmenterCompetence(Competence.CHANCE, 10);
    }
  
    @Override
    public void boostDeCompetences() {
        ANSIColors couleur = new ANSIColors();
        couleur.vert(getNom() + " Boost de compétences -> Activation de l'ultra instinct !");
        augmenterCompetence(Competence.PERCEPTION, 100);
    }
}
