package tp.model;

class Medjay extends Personnage {

    public Medjay(String nom) {
        super(nom);
        augmenterCompetence(Competence.FORCE, 100);
        augmenterCompetence(Competence.PERCEPTION, 25);
        augmenterCompetence(Competence.ENDURANCE, 75);
        augmenterCompetence(Competence.CHARISME, 10);
        augmenterCompetence(Competence.INTELLIGENCE, 15);
        augmenterCompetence(Competence.AGILITE, 50);
        augmenterCompetence(Competence.CHANCE, 5);
    }
    
    @Override
    public void boostDeCompetences() {
        ANSIColors couleur = new ANSIColors();
        couleur.vert(getNom() + " Boost de compétences -> Esprits de pharaons !");
        augmenterCompetence(Competence.CHANCE, 150);
    }
}
