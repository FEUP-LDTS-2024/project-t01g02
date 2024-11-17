package com.t01g02.project;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;

import java.util.ArrayList;
import java.util.List;


public class City {
    private final int width;
    private final int height;
    private final Tile[][] map;


    public City(int width, int height){
        this.width = width;
        this.height = height;
        this.map = new Tile[height][width];

        initializeCity();

    }
    private void initializeCity(){
        TextColor color = TextColor.Factory.fromString("#888888");
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                map[y][x] = new Tile(Tile.Type.EMPTY, TextColor.Factory.fromString("#FFFFFF"));
            }
        }

        Tile.fillLine(map, new Position(2,15), new Position(400, 15 ), Tile.Type.ROAD, color); // outside roads
        Tile.fillLine(map, new Position (2, 15), new Position(2, 200), Tile.Type.ROAD, color);
        Tile.fillLine(map, new Position (2, 200), new Position(300, 200), Tile.Type.ROAD, color);
        Tile.fillLine(map, new Position (435, 70), new Position(435, 245), Tile.Type.ROAD, color);
        Tile.fillLine(map, new Position (380, 15), new Position(380, 70), Tile.Type.ROAD, color);
        Tile.fillLine(map, new Position (380, 70), new Position(440, 70), Tile.Type.ROAD, color);
        Tile.fillLine(map, new Position (300, 200), new Position(300, 245), Tile.Type.ROAD, color);
        Tile.fillLine(map, new Position (300, 221), new Position(440, 221), Tile.Type.ROAD, color);

        Tile.fillLine(map, new Position(55,15), new Position(55, 60), Tile.Type.ROAD, color);
        Tile.fillLine(map, new Position(2,60), new Position(210, 60 ), Tile.Type.ROAD, color);
        Tile.fillLine(map, new Position(70,60), new Position(70, 200), Tile.Type.ROAD, color);
        Tile.fillLine(map, new Position(134,60), new Position(134, 120), Tile.Type.ROAD, color);
        Tile.fillLine(map, new Position(70,120), new Position(210, 120 ), Tile.Type.ROAD, color);
        Tile.fillLine(map, new Position(196,15), new Position(196, 144), Tile.Type.ROAD, color);
        Tile.fillLine(map, new Position(197,90), new Position(250, 90), Tile.Type.ROAD, color);
        Tile.fillLine(map, new Position(250,90), new Position(250, 200), Tile.Type.ROAD, color);
        Tile.fillLine(map, new Position(250,125), new Position(440, 125), Tile.Type.ROAD, color);
        Tile.fillLine(map, new Position(325,15), new Position(325, 125), Tile.Type.ROAD, color);
        Tile.fillLine(map, new Position(375,125), new Position(375, 245), Tile.Type.ROAD, color);
        Tile.fillLine(map, new Position(375,180), new Position(440, 180), Tile.Type.ROAD, color);



    }

    public Tile getTileAt(int x, int y) {
        if (x >= 0 && x < width && y >= 0 && y < height) {
            return map[y][x];
        }
        return null;
    }


    public int getWidth(){ return width; };

    public int getHeight() { return height; }



}
