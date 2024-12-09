package com.t01g02.project;

import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminal;
import com.t01g02.project.menu.GameMenuController;
import com.t01g02.project.menu.GameMenuModel;
import com.t01g02.project.menu.GameMenuView;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Application {
    public static void main(String[] args) throws IOException, URISyntaxException, FontFormatException, InterruptedException {
        GameMenuModel menu = new GameMenuModel();

        Terminal terminal = new DefaultTerminalFactory().createTerminal();
        Screen screen = new TerminalScreen(terminal);
        screen.startScreen();

        GameMenuModel model = new GameMenuModel();
        GameMenuView view = new GameMenuView(screen, model);
        GameMenuController controller = new GameMenuController(view, screen,model);

        long lastUpdateTime = System.currentTimeMillis();
        long updateInterval = 100; // Update every 100ms

        while (controller.isRunning()) {
            controller.updateView();
            controller.processInput();
        }

        screen.stopScreen();

    }
}
