package rpg.settings;

import rpg.core.Character;

/**
 * Singleton contenant les règles globales du jeu.
 */
public class GameSettings {
    private static GameSettings instance;
    private int maxStatPoints;

    private GameSettings() {
        // Valeur par défaut
        this.maxStatPoints = 30;
    }

    /**
     * Obtient l'instance unique du singleton.
     * @return L'instance de GameSettings.
     */
    public static synchronized GameSettings getInstance() {
        if (instance == null) {
            instance = new GameSettings();
        }
        return instance;
    }

    /**
     * Vérifie si un personnage respecte les règles du jeu.
     * @param character Le personnage à vérifier.
     * @return true si le personnage est valide, false sinon.
     */
    public boolean isValid(Character character) {
        int totalStats = character.getTotalStats();
        return totalStats <= maxStatPoints;
    }

    /**
     * Obtient le nombre maximum de points de caractéristiques.
     * @return La valeur maximale pour la somme des caractéristiques.
     */
    public int getMaxStatPoints() {
        return maxStatPoints;
    }

    /**
     * Définit le nombre maximum de points de caractéristiques.
     * @param maxStatPoints La nouvelle valeur maximale.
     */
    public void setMaxStatPoints(int maxStatPoints) {
        this.maxStatPoints = maxStatPoints;
    }
}