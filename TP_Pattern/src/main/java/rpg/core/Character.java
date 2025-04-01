package rpg.core;

/**
 * Classe de base représentant un personnage de jeu de rôle.
 */
public class Character {
    private String name;
    private int strength;
    private int agility;
    private int intelligence;

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    /**
     * Calcule et retourne le niveau de puissance du personnage.
     * @return Le niveau de puissance calculé à partir des caractéristiques.
     */
    public int getPowerLevel() {
        return strength * 2 + agility + intelligence * 2;
    }

    /**
     * Retourne une description textuelle du personnage.
     * @return La description du personnage avec ses caractéristiques.
     */
    public String getDescription() {
        return "Personnage: " + name + 
               "\nForce: " + strength + 
               "\nAgilité: " + agility + 
               "\nIntelligence: " + intelligence +
               "\nNiveau de puissance: " + getPowerLevel();
    }

    // Getters et setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }
    
    public int getTotalStats() {
        return strength + agility + intelligence;
    }
}