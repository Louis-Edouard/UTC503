package rpg.builder;

import rpg.core.Character;
import rpg.settings.GameSettings;

/**
 * Builder pour construire un personnage étape par étape.
 */
public class CharacterBuilder {
    private String name;
    private int strength;
    private int agility;
    private int intelligence;

    public CharacterBuilder() {
        // Valeurs par défaut
        this.name = "Sans nom";
        this.strength = 1;
        this.agility = 1;
        this.intelligence = 1;
    }

    /**
     * Définit le nom du personnage.
     * @param name Le nom du personnage.
     * @return Le builder pour chaîner les appels.
     */
    public CharacterBuilder setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Définit la force du personnage.
     * @param strength La force du personnage.
     * @return Le builder pour chaîner les appels.
     */
    public CharacterBuilder setStrength(int strength) {
        this.strength = Math.max(1, strength); // Minimum 1
        return this;
    }

    /**
     * Définit l'agilité du personnage.
     * @param agility L'agilité du personnage.
     * @return Le builder pour chaîner les appels.
     */
    public CharacterBuilder setAgility(int agility) {
        this.agility = Math.max(1, agility); // Minimum 1
        return this;
    }

    /**
     * Définit l'intelligence du personnage.
     * @param intelligence L'intelligence du personnage.
     * @return Le builder pour chaîner les appels.
     */
    public CharacterBuilder setIntelligence(int intelligence) {
        this.intelligence = Math.max(1, intelligence); // Minimum 1
        return this;
    }

    /**
     * Construit et retourne le personnage.
     * @return Le personnage créé.
     * @throws IllegalStateException Si le personnage ne respecte pas les règles du jeu.
     */
    public Character build() throws IllegalStateException {
        Character character = new Character(name, strength, agility, intelligence);
        
        // Vérifie si le personnage respecte les règles du jeu
        if (!GameSettings.getInstance().isValid(character)) {
            throw new IllegalStateException("Le personnage ne respecte pas les règles du jeu. La somme des caractéristiques ne doit pas dépasser " + 
                                          GameSettings.getInstance().getMaxStatPoints());
        }
        
        return character;
    }
}