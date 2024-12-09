package com.t01g02.project;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import com.t01g02.project.model.*;
import com.t01g02.project.viewer.CharacterViewer;

import java.io.IOException;
import java.util.List;

public class Controller {
    private CharacterModel hellokitty;
    private final CharacterViewer characterViewer;
    private final Screen screen;
    private final CityModel cityModel;


    public Controller(Screen screen, CharacterModel hellokitty, CityModel cityModel) throws IOException {
        this.hellokitty = CharacterModel.getHellokitty();
        this.screen = screen;
        this.characterViewer =new CharacterViewer(screen);
        this.cityModel = cityModel;
    }

    public void processInput(KeyStroke keyStroke) {
        Position currentPosition = CharacterModel.getHellokitty().getPosition();
        Position newPosition = null;

        switch (keyStroke.getKeyType()) {
            case ArrowUp:
                newPosition = new Position(currentPosition.getX(), currentPosition.getY() - 2);
                break;
            case ArrowDown:
                newPosition = new Position(currentPosition.getX(), currentPosition.getY() + 2);
                break;
            case ArrowLeft:
                newPosition = new Position(currentPosition.getX() - 2, currentPosition.getY());
                break;
            case ArrowRight:
                newPosition = new Position(currentPosition.getX() + 2, currentPosition.getY());
                break;
            default:
                return;
        }

        //need to fix hello kitty position

        if (newPosition != null && canMove(newPosition)) {
            System.out.println("Moving to position: " + newPosition.getX() + ", " + newPosition.getY());
            CharacterModel.getHellokitty().setPosition(newPosition);
        }
    }
    private boolean canMove(Position newPosition){
        Tile tile = cityModel.getTile(newPosition.getX(), newPosition.getY());
        if (tile == null || tile.getType() != Tile.Type.ROAD) return false;
        return true;
    }

}

