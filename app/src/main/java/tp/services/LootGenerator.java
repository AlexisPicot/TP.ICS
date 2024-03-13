package tp.services;

import org.springframework.stereotype.Component;
import tp.model.Arme;
import tp.model.Item;
import tp.services.contracts.ILootGenerator;

import java.util.Random;

/**
 * Génère le loot
 */
@Component
public class LootGenerator implements ILootGenerator {
    private Random random;

    public LootGenerator() {
        this.random = new Random();
    }

    /**
     * Génère le loot
     */
    @Override
    public Item genererLoot() {
        int choix = random.nextInt(101);

        if (choix < 35) {
            return new Arme("Épée en Bronze", "", 10, 150, 50);
        } else if (choix < 50) {
            return new Arme("Épée en Fer", "", 10, 300, 70);
        } else if (choix < 60) {
            return new Arme("Épée en Acier", "", 15, 500, 80);
        } else if (choix < 70) {
            return new Arme("Épée en Acier", "", 15, 500, 80);
        } else if (choix < 75) {
            return new Arme("Épée en Titane", "", 25, 1500, 110);
        } else if (choix < 85) {
            return new Arme("Épée en Titane", "", 25, 1500, 110);
        } else if (choix < 95) {
            return new Arme("Épée en Adamantium", "", 20, 5000, 125);
        } else if (choix <= 100) {
            return new Arme("Épée en Iridium", "", 25, 100000, 300);
        } else {
            return new Item("Pierre de la malédiction de l'exception", "Une erreur c'est déclenchée quelquepart...", 1, 0);
        }
    }
}
