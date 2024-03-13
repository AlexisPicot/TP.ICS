//package tp.model;
//
//import tp.services.ExplorationGenerator;
//
//import java.util.Scanner;
//import java.util.Set;
//
//public class Main {
//    public static void main(String[] args) {
//        /* Couleurs de la sortie standard */
//        ANSIColors couleur = new ANSIColors();
//
//        Scanner scanner = new Scanner(System.in);
//        boolean continuer = true;
//
//        Ultramarine Royal69Pizza = new Ultramarine("Royal69Pizza");
//        Arme katanaDuVampire = new Arme("Eclispe Lunaire", "Katana de Ranni", 10, 7500, 125);
//        Arme MarteauDeThor = new Arme("Marteau de Thor", "Marteau du Dieu du Tonnerre", 15, 8000, 140);
//        Arme Minigun = new Arme("Minigun", "Dinguri", 8, 7000, 110);
//
//        Armure armureDeBlade = new Armure("Armure de Blade", "Utilisée par Blade pour détruire des vampires", 25, 5000, 100);
//        Armure armureDeWarMachine = new Armure("Armure de War Machine", "Iron Man 2", 100, 15000, 500);
//
//        Item medaillonDeDectus = new Item("Médaillon de Dectus", "Ouvre la porte vers le plateau Altus", 1, 1000);
//        Item medaillonDeArbreSacre = new Item("Médaillon de l'Arbre Sacré", "Ouvre la porte vers l'arbre sacré de Miquella", 1, 10000);
//
//        Royal69Pizza.equiperArme(katanaDuVampire);
//        Royal69Pizza.equiperArmure(armureDeBlade);
//
//        Royal69Pizza.ajouterALInventaire(katanaDuVampire);
//        Royal69Pizza.ajouterALInventaire(armureDeBlade);
//        Royal69Pizza.ajouterALInventaire(armureDeWarMachine);
//        Royal69Pizza.ajouterALInventaire(medaillonDeDectus);
//        Royal69Pizza.ajouterALInventaire(medaillonDeArbreSacre);
//        Royal69Pizza.ajouterALInventaire(MarteauDeThor);
//        Royal69Pizza.ajouterALInventaire(Minigun);
//
//        while (continuer) {
//            couleur.violet("[ Xx_ôOô_xX ] Bienvenue sur le TP de Java par Royal69Pizza ! [ Xx_ôOô_xX ]");
//            couleur.violet("1 -> Personnage");
//            couleur.violet("2 -> Inventaire");
//            couleur.violet("3 -> Explorer");
//            couleur.violet("4 -> Sortir");
//            System.out.print("> ");
//
//            int choix = scanner.nextInt();
//
//            switch (choix) {
//                case 1:
//                    couleur.cyan("Compétences de : " + Royal69Pizza.getNom());
//                    Royal69Pizza.afficherCompetences();
//                    break;
//                case 2:
//                    couleur.cyan("Inventaire de : " + Royal69Pizza.getNom());
//                    Royal69Pizza.afficherInventaire();
//
//                    couleur.violet("");
//                    couleur.violet("Trier par :");
//                    couleur.violet("1 -> Tout");
//                    couleur.violet("2 -> Armes (Croissant)");
//                    couleur.violet("3 -> Armures (Croissant)");
//                    couleur.violet("4 -> Poids (Croissant)");
//                    couleur.violet("5 -> Prix (Croissant)");
//                    couleur.violet("6 -> Valeur d'arme (Croissant)");
//                    couleur.violet("7 -> Valeur d'armure (Croissant)");
//                    System.out.print("> ");
//
//                    int choixTri = scanner.nextInt();
//
//                    switch (choixTri) {
//                        case 1:
//                            Royal69Pizza.afficherInventaire();
//                            break;
//                        case 2:
//                            Set<Item> inventaireTriArmes = Royal69Pizza.trierInventaireArmes();
//                            Royal69Pizza.afficherInventaireTri(inventaireTriArmes);
//                            break;
//                        case 3:
//                            Set<Item> inventaireTriArmures = Royal69Pizza.trierInventaireArmures();
//                            Royal69Pizza.afficherInventaireTri(inventaireTriArmures);
//                            break;
//                        case 4:
//                            Set<Item> inventaireTriParPoids = Royal69Pizza.trierInventaireParPoids();
//                            Royal69Pizza.afficherInventaireTri(inventaireTriParPoids);
//                            break;
//                        case 5:
//                            Set<Item> inventaireTriParPrix = Royal69Pizza.trierInventaireParPrix();
//                            Royal69Pizza.afficherInventaireTri(inventaireTriParPrix);
//                            break;
//                        case 6:
//                            Set<Item> inventaireTriParValeurArme = Royal69Pizza.trierInventaireValeurArmes();
//                            Royal69Pizza.afficherInventaireTri(inventaireTriParValeurArme);
//                            break;
//                        case 7:
//                            Set<Item> inventaireTriParValeurArmure = Royal69Pizza.trierInventaireValeurArmures();
//                            Royal69Pizza.afficherInventaireTri(inventaireTriParValeurArmure);
//                            break;
//                        default:
//                            couleur.rouge("Choix invalide. Veuillez choisir une option valide.");
//                    }
//
//                    break;
//                case 3:
//                    ExplorationGenerator exploration = new ExplorationGenerator();
//                    exploration.explorer(Royal69Pizza);
//                    break;
//                case 4:
//
//                    couleur.bleu("Au revoir !");
//                    continuer = false;
//                    break;
//                default:
//                    couleur.rouge("Choix invalide. Veuillez choisir une option valide.");
//            }
//        }
//
//        scanner.close();
//    }
//}