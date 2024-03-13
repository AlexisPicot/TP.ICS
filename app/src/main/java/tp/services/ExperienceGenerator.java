package tp.services;

import org.springframework.stereotype.Component;
import tp.model.Personnage;
import tp.services.contracts.IExperienceGenerator;

/**
 * Génère l'expérience gagnée
 */
@Component
public class ExperienceGenerator implements IExperienceGenerator {

    /**
     * Calcule l'expérience gagnée
     */
    @Override
    public int calculerExperience(Personnage personnage) {
        int intelligence = personnage.getIntelligence();
        int chance = personnage.getChance();
        return (intelligence * 10) + (chance * 5);
    }
}
