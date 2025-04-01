package rpg.main;

import rpg.builder.CharacterBuilder;
import rpg.core.Character;
import rpg.core.Party;
import rpg.dao.CharacterDAO;
import rpg.decorator.FireResistance;
import rpg.decorator.Invisibility;
import rpg.decorator.Telepathy;
import rpg.settings.GameSettings;

/**
 * Classe principale pour démontrer le fonctionnement du générateur de personnages.
 */
public class Main {
    
    public static void main(String[] args) {
        System.out.println("=== DÉMO DU GÉNÉRATEUR DE PERSONNAGES RPG ===\n");
        
        // Configuration des règles du jeu
        GameSettings.getInstance().setMaxStatPoints(30);
        
        // Création du DAO
        CharacterDAO characterDAO = new CharacterDAO();
        
        try {
            // Création de personnages avec le builder
            System.out.println("Création de personnages...");
            
            Character warrior = new CharacterBuilder()
                .setName("Aragorn")
                .setStrength(15)
                .setAgility(10)
                .setIntelligence(5)
                .build();
            
            Character mage = new CharacterBuilder()
                .setName("Gandalf")
                .setStrength(4)
                .setAgility(6)
                .setIntelligence(20)
                .build();
            
            Character rogue = new CharacterBuilder()
                .setName("Legolas")
                .setStrength(8)
                .setAgility(18)
                .setIntelligence(4)
                .build();
                
            System.out.println("Personnages créés avec succès!\n");
            
            // Ajout de capacités spéciales avec les décorateurs
            System.out.println("Ajout de capacités spéciales...");
            
            Character invisibleRogue = new Invisibility(rogue);
            Character fireResistantWarrior = new FireResistance(warrior);
            Character telepathicMage = new Telepathy(mage);
            
            // Personnage avec plusieurs capacités
            Character superHero = new Telepathy(new FireResistance(new Invisibility(new CharacterBuilder()
                .setName("Superman")
                .setStrength(10)
                .setAgility(10)
                .setIntelligence(10)
                .build())));
                
            System.out.println("Capacités ajoutées avec succès!\n");
            
            // Sauvegarde des personnages
            System.out.println("Sauvegarde des personnages...");
            characterDAO.save(invisibleRogue);
            characterDAO.save(fireResistantWarrior);
            characterDAO.save(telepathicMage);
            characterDAO.save(superHero);
            System.out.println("Personnages sauvegardés avec succès!\n");
            
            // Création d'une équipe
            System.out.println("Création d'une équipe...");
            Party fellowship = new Party("La Communauté de l'Anneau");
            fellowship.addCharacter(invisibleRogue);
            fellowship.addCharacter(fireResistantWarrior);
            fellowship.addCharacter(telepathicMage);
            System.out.println("Équipe créée avec succès!\n");
            
            // Affichage des personnages
            System.out.println("=== DESCRIPTION DES PERSONNAGES ===");
            System.out.println("\n--- Personnage 1 ---");
            System.out.println(invisibleRogue.getDescription());
            
            System.out.println("\n--- Personnage 2 ---");
            System.out.println(fireResistantWarrior.getDescription());
            
            System.out.println("\n--- Personnage 3 ---");
            System.out.println(telepathicMage.getDescription());
            
            System.out.println("\n--- Personnage 4 (multi-capacités) ---");
            System.out.println(superHero.getDescription());
            
            // Affichage de l'équipe
            System.out.println("\n=== DESCRIPTION DE L'ÉQUIPE ===");
            System.out.println(fellowship.getDescription());
            
            // Tri par puissance
            System.out.println("\n=== ÉQUIPE TRIÉE PAR PUISSANCE ===");
            fellowship.sortByPower();
            for (Character member : fellowship.getMembers()) {
                System.out.println(member.getName() + " - Puissance: " + member.getPowerLevel());
            }
            
            // Tri par nom
            System.out.println("\n=== ÉQUIPE TRIÉE PAR NOM ===");
            fellowship.sortByName();
            for (Character member : fellowship.getMembers()) {
                System.out.println(member.getName() + " - Puissance: " + member.getPowerLevel());
            }
            
            // Simulation d'un combat
            System.out.println("\n=== SIMULATION DE COMBAT ===");
            simulateBattle(fireResistantWarrior, telepathicMage);
            
            // Test de recherche dans le DAO
            System.out.println("\n=== TEST DU DAO ===");
            Character foundCharacter = characterDAO.findByName("Superman");
            if (foundCharacter != null) {
                System.out.println("Personnage trouvé dans la base de données :");
                System.out.println(foundCharacter.getDescription());
            }
            
            System.out.println("\nNombre total de personnages dans la base : " + characterDAO.findAll().size());
            
        } catch (IllegalStateException e) {
            System.err.println("Erreur lors de la création d'un personnage : " + e.getMessage());
        }
    }
    
    /**
     * Simule un combat simple entre deux personnages.
     * @param character1 Le premier personnage.
     * @param character2 Le second personnage.
     */
    private static void simulateBattle(Character character1, Character character2) {
        System.out.println("Combat entre " + character1.getName() + " et " + character2.getName());
        System.out.println(character1.getName() + " - Puissance: " + character1.getPowerLevel());
        System.out.println(character2.getName() + " - Puissance: " + character2.getPowerLevel());
        
        if (character1.getPowerLevel() > character2.getPowerLevel()) {
            System.out.println(character1.getName() + " remporte le combat!");
        } else if (character2.getPowerLevel() > character1.getPowerLevel()) {
            System.out.println(character2.getName() + " remporte le combat!");
        } else {
            System.out.println("Match nul!");
        }
    }
}