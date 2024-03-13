package tp;

import org.springframework.stereotype.Component;
import tp.model.Competence;
import tp.model.Personnage;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class CompetenceController  {

    private final Personnage personnage;

    public CompetenceController(PersonnageSingleton personnage){
        this.personnage = personnage.getInstance();
    }

    public Map<Competence, Integer> getCompetences(){
        return Arrays.stream(Competence.values()).collect(Collectors.toMap(competence -> competence, personnage::getNiveauCompetence));
    }
    public void augmenterCompetence(Competence competence, int valeur){
        personnage.augmenterCompetence(competence, valeur);
    }
    public int getPointsRestants(){
        return personnage.getPointsRestants();
    }
}
