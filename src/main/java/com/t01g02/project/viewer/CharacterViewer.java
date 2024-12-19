package com.t01g02.project.viewer;

import com.googlecode.lanterna.screen.Screen;
import com.t01g02.project.model.CharacterModel;

import java.io.IOException;



public class CharacterViewer {
    private final Screen screen;


    public CharacterViewer(Screen screen) {
        this.screen = screen;
    }

    public void initializeCharacters() throws IOException {
        CharacterModel.initializeCharacters(screen);
    }


    public void draw() throws IOException {

        for (CharacterModel character : CharacterModel.friends) {
            if (!character.isInParty())
                character.getSprite().drawImage(character.getPosition());
        }
        CharacterModel.getHellokitty().getSprite().drawImage(CharacterModel.getHellokitty().getPosition());

    }
}
