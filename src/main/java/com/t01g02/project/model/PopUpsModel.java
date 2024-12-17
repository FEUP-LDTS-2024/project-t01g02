package com.t01g02.project.model;

import com.googlecode.lanterna.screen.Screen;
import com.t01g02.project.viewer.LanternaGui;
import com.t01g02.project.viewer.PopUpsViewer;
import com.t01g02.project.viewer.Sprite;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class PopUpsModel extends Element {
    public static List<PopUpsModel> speedpopups, mudpopups, blockpopups;
    static Random random = new Random();
    private static final int TerminalWidth = 345;
    private static final int TerminalHeight = 185;
    private static PopUpsModel star;

    public PopUpsModel(Sprite sprite, Position position, String name) {
        super(sprite, position, name);
    }


    private static List<Position> popupsPositions = new ArrayList<>(
            List.of(
                new Position(4, 6),
                new Position(4, 100),
                new Position(30, 160),
                new Position(190, 160),
                new Position(130, 110),
                new Position(170, 55),
                new Position(150, 6),
                new Position(260, 6),
                new Position(320, 100),
                new Position(255, 110),
                new Position(130, 160),
                new Position(100, 55),
                new Position(200, 7),
                new Position(320, 55)
    ));

    public static Position getRandomPosition() {
        assert !popupsPositions.isEmpty();
        int randomIndex = random.nextInt(popupsPositions.size());
        Position position = popupsPositions.get(randomIndex);
        popupsPositions.remove(randomIndex);
        return position;
    }

    public static void initializeStar(Screen screen) throws IOException {
        star = new PopUpsModel(
                new Sprite(screen, "src/main/resources/Pop-ups/star.png"),
                new Position(5, 5),
                "Star"
        );
    }
    public static PopUpsModel getStar() {
        return star;
    }

    public static void initializeSpeedPopUps(Screen screen
    ) throws IOException {
        speedpopups = new ArrayList<>( List.of(
                new PopUpsModel(new Sprite(screen, "src/main/resources/Pop-ups/speed.png"), getRandomPosition(), "Speed"),
                new PopUpsModel(new Sprite(screen, "src/main/resources/Pop-ups/speed.png"), getRandomPosition(), "Speed"),
                new PopUpsModel(new Sprite(screen, "src/main/resources/Pop-ups/speed.png"), getRandomPosition(), "Speed"),
                new PopUpsModel(new Sprite(screen, "src/main/resources/Pop-ups/speed.png"), getRandomPosition(), "Speed")

        ));
    }

    public static void addSpeed(Screen screen) throws IOException {
        speedpopups.add(new PopUpsModel(new Sprite(screen, "src/main/resources/Pop-ups/speed.png"), getRandomPosition(), "Speed"));
    }

    public static void initializeMudPopUps(Screen screen) throws IOException {
        mudpopups = new ArrayList<>( List.of(
                new PopUpsModel(new Sprite(screen, "src/main/resources/Pop-ups/mud.png"), getRandomPosition(), "Mud"),
                new PopUpsModel(new Sprite(screen, "src/main/resources/Pop-ups/mud.png"), getRandomPosition(), "Mud"),
                new PopUpsModel(new Sprite(screen, "src/main/resources/Pop-ups/mud.png"), getRandomPosition(), "Mud")

        ));
    }

    public static void addMud(Screen screen) throws IOException {
        mudpopups.add(new PopUpsModel(new Sprite(screen, "src/main/resources/Pop-ups/mud.png"), getRandomPosition(), "Mud"));
    }

    public static void initializeBlockPopUps(Screen screen) throws IOException {
        blockpopups = List.of(
                new PopUpsModel(new Sprite(screen, "src/main/resources/Pop-ups/block.png"), getRandomPosition(), "Block"),
                new PopUpsModel(new Sprite(screen, "src/main/resources/Pop-ups/block.png"), getRandomPosition(), "Block"),
                new PopUpsModel(new Sprite(screen, "src/main/resources/Pop-ups/block.png"), getRandomPosition(), "Block")
                );
    }

    public static void deleteStar() {
        star = null;
    }

    public static List<Position> getPopupsPositions() {
        return popupsPositions;
    }

    @Override
    public Position getPosition() {
        return super.getPosition();
    }

    @Override
    public void setPosition(Position position) {
        super.setPosition(position);
    }

    /*public static void reset(Screen screen) throws IOException {
        popupsPositions = new ArrayList<>(List.of(
                new Position(4, 6),
                new Position(4, 100),
                new Position(30, 160),
                new Position(190, 160),
                new Position(130, 110),
                new Position(170, 55),
                new Position(150, 6),
                new Position(260, 6),
                new Position(320, 100),
                new Position(255, 110),
                new Position(130, 160),
                new Position(100, 55),
                new Position(200, 7),
                new Position(320, 55)
        ));

        initializeSpeedPopUps(screen);
        initializeMudPopUps(screen);
        initializeBlockPopUps(screen);
        initializeStar(screen);
    }*/
}
