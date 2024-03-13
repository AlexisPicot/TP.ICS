package tp.model;

public class Viking extends Personnage {

    public Viking(String nom) {
        super(nom);
        augmenterCompetence(Competence.FORCE, 3);
        augmenterCompetence(Competence.ENDURANCE, 1);
    }
  
    @Override
    public void boostDeCompetences() {
        ANSIColors couleur = new ANSIColors();
        couleur.vert(getNom() + " Boost de compétences -> Valhalla !");
        augmenterCompetence(Competence.FORCE, 150);
        augmenterCompetence(Competence.ENDURANCE, 75);
        augmenterCompetence(Competence.AGILITE, 50);
    }
}
