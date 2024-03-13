package tp.services;

import org.springframework.stereotype.Component;
import tp.model.Item;
import tp.model.Personnage;
import tp.services.contracts.IExplorationGenerator;
import tp.util.MessageService;

import java.awt.*;
import java.util.Random;

/**
 * Générateur d'exploration
 */
@Component
public class ExplorationGenerator implements IExplorationGenerator {

    private final MessageService messageService;
    private final LootGenerator lootGenerator;
    private final CombatGenerator combatGenerator;
    private final ExperienceGenerator experienceGenerator;

    public ExplorationGenerator(MessageService  messageService, LootGenerator lootGenerator, CombatGenerator combatGenerator, ExperienceGenerator experienceGenerator) {
        this.messageService = messageService;
        this.lootGenerator = lootGenerator;
        this.combatGenerator = combatGenerator;
        this.experienceGenerator = experienceGenerator;
    }

    /**
     * Créer l'exploration du personage
     */
    public void explorer(Personnage personnage) {
        Random random = new Random();
        int action = random.nextInt(4);

        if (action == 0) {
            LootGenerator loot = new LootGenerator();
            Item newItem = loot.genererLoot();
            personnage.ajouterALInventaire(newItem);
            messageService.addMessage("Nouveau loot -> " + newItem.getNom(), Color.blue);
        } else {
            boolean gagneOuPerd = combatGenerator.combat();
            if (gagneOuPerd) {

                Item newItem = lootGenerator.genererLoot();
                personnage.ajouterALInventaire(newItem);
                messageService.addMessage("Nouveau loot -> " + newItem.getNom(), Color.blue);

                int experienceGagnee = experienceGenerator.calculerExperience(personnage);
                personnage.setNiveauExperience(experienceGagnee);

                messageService.addMessage("Le personnage a gagné comme experience -> " + experienceGagnee, Color.green);
                messageService.addMessage("Le niveau de notre personnage est -> " + personnage.getNiveauExperience(), Color.green);
            } else {
                messageService.addMessage("Malheureusement aucun loot n'a été trouvé, le montre les a mangés. Vous ne gagnez pas de niveaux", Color.red);
            }
        }
    }
}
