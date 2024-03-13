package tp.services;

import org.springframework.stereotype.Component;
import tp.PersonnageSingleton;
import tp.model.Personnage;
import tp.services.contracts.ICombatGenerator;
import tp.util.MessageService;

import java.awt.*;
import java.util.Random;

/**
 * Générateur de combat
 */
@Component
public class CombatGenerator implements ICombatGenerator {
    private Random random;
    private Personnage personnage;
    private MessageService messageService;

    public CombatGenerator(PersonnageSingleton personnage, MessageService messageService){
        this.personnage = personnage.getInstance();
        this.messageService = messageService;
        this.random = new Random();
    }

    /**
     * Créer le combat
     */
    @Override
    public boolean combat() {
        this.personnage = personnage;
        this.messageService = messageService;

        int pointsDeViePersonnage = personnage.getPointsDeVie();

        int pointsDeVieMonstre = (int) (pointsDeViePersonnage * random.nextDouble()*2.1-0.9); // Points de vie du monstre entre 90 et 120% de ceux du personnage

        messageService.addMessage("Un monstre à été trouvé !", Color.yellow);
        messageService.addMessage("Mes points de vie -> " + pointsDeViePersonnage, Color.green);
        messageService.addMessage("Points de vie du monstre -> " + pointsDeVieMonstre, Color.red);


        while (true) {
            int degatsPersonnage = personnage.getDegats() + random.nextInt(11); // Dégâts entre 0 et 10 supplémentaires
            int degatsMonstre = (int) (degatsPersonnage * random.nextDouble()*2.1-0.9); // Dégâts du monstre entre 90 et 120% de ceux du personnage

            // Appliquer les dégâts
            pointsDeVieMonstre -= degatsPersonnage;
            pointsDeViePersonnage -= degatsMonstre;

            // Vérifier si le combat est terminé
            if (pointsDeVieMonstre <= 0) {
                messageService.addMessage("Vous avez gagné contre le monstre !", Color.green);

                return true;
            } else if (pointsDeViePersonnage <= 0) {
                messageService.addMessage("Vous avez perdu contre le monstre !", Color.red);
                return false;
            }
        }

        // Ce cas ne devrait normalement pas être atteint
    }
}
