package rpg.decorator;

import rpg.core.Character;

/**
 * Classe abstraite servant de base pour tous les décorateurs de personnage.
 */
public abstract class CharacterDecorator extends Character {
    protected Character decoratedCharacter;

    public CharacterDecorator(Character decoratedCharacter) {
        super(decoratedCharacter.getName(), 
              decoratedCharacter.getStrength(), 
              decoratedCharacter.getAgility(), 
              decoratedCharacter.getIntelligence());
        this.decoratedCharacter = decoratedCharacter;
    }

    @Override
    public int getPowerLevel() {
        return decoratedCharacter.getPowerLevel();
    }

    @Override
    public String getDescription() {
        return decoratedCharacter.getDescription();
    }

    @Override
    public int getTotalStats() {
        return decoratedCharacter.getTotalStats();
    }
}