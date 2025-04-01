package rpg.decorator;

import rpg.core.Character;

/**
 * Décorateur ajoutant la capacité de résistance au feu à un personnage.
 */
public class FireResistance extends CharacterDecorator {
    
    public FireResistance(Character decoratedCharacter) {
        super(decoratedCharacter);
    }
    
    @Override
    public int getPowerLevel() {
        // La résistance au feu augmente le niveau de puissance
        return super.getPowerLevel() + 8;
    }
    
    @Override
    public String getDescription() {
        return super.getDescription() + "\nCapacité spéciale: Résistance au feu (réduit les dégâts de feu de 50%)";
    }
}