package rpg.decorator;

import rpg.core.Character;


public class Telepathy extends CharacterDecorator {
    
    public Telepathy(Character decoratedCharacter) {
        super(decoratedCharacter);
    }
    
    @Override
    public int getPowerLevel() {
        // La télépathie augmente le niveau de puissance
        return super.getPowerLevel() + 12;
    }
    
    @Override
    public String getDescription() {
        return super.getDescription() + "\nCapacité spéciale: Télépathie (peut lire les pensées et communiquer mentalement)";
    }
}