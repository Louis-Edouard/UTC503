package rpg.decorator;

import rpg.core.Character;

/**
 * Décorateur ajoutant la capacité d'invisibilité à un personnage.
 */
public class Invisibility extends CharacterDecorator {
    
    public Invisibility(Character decoratedCharacter) {
        super(decoratedCharacter);
    }
    
    @Override
    public int getPowerLevel() {
        // L'invisibilité augmente le niveau de puissance
        return super.getPowerLevel() + 10;
    }
    
    @Override
    public String getDescription() {
        return super.getDescription() + "\nCapacité spéciale: Invisibilité (peut devenir invisible pendant 30 secondes)";
    }
}