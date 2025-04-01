package rpg.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Classe représentant une équipe de personnages.
 */
public class Party {
    private String partyName;
    private List<Character> members;

    public Party(String partyName) {
        this.partyName = partyName;
        this.members = new ArrayList<>();
    }

    /**
     * Ajoute un personnage à l'équipe.
     * @param character Le personnage à ajouter.
     * @return true si l'ajout a réussi.
     */
    public boolean addCharacter(Character character) {
        return members.add(character);
    }

    /**
     * Supprime un personnage de l'équipe.
     * @param character Le personnage à supprimer.
     * @return true si la suppression a réussi.
     */
    public boolean removeCharacter(Character character) {
        return members.remove(character);
    }

    /**
     * Supprime un personnage de l'équipe par son nom.
     * @param name Le nom du personnage à supprimer.
     * @return true si la suppression a réussi.
     */
    public boolean removeCharacterByName(String name) {
        return members.removeIf(character -> character.getName().equals(name));
    }

    /**
     * Calcule la puissance totale de l'équipe.
     * @return La somme des niveaux de puissance de tous les membres.
     */
    public int getTotalPowerLevel() {
        return members.stream().mapToInt(Character::getPowerLevel).sum();
    }

    /**
     * Trie les personnages par puissance.
     */
    public void sortByPower() {
        Collections.sort(members, Comparator.comparingInt(Character::getPowerLevel).reversed());
    }

    /**
     * Trie les personnages par nom.
     */
    public void sortByName() {
        Collections.sort(members, Comparator.comparing(Character::getName));
    }

    /**
     * Récupère la liste des membres de l'équipe.
     * @return La liste des personnages.
     */
    public List<Character> getMembers() {
        return new ArrayList<>(members);
    }

    /**
     * Retourne une description de l'équipe.
     * @return La description de l'équipe avec ses membres.
     */
    public String getDescription() {
        StringBuilder description = new StringBuilder("Équipe: " + partyName + "\n");
        description.append("Nombre de membres: ").append(members.size()).append("\n");
        description.append("Puissance totale: ").append(getTotalPowerLevel()).append("\n");
        description.append("Membres:\n");
        
        for (Character character : members) {
            description.append("- ").append(character.getName()).append(" (Puissance: ")
                      .append(character.getPowerLevel()).append(")\n");
        }
        
        return description.toString();
    }
}