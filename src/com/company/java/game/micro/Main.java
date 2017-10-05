package com.company.java.game.micro;

import com.googlecode.lanterna.*;
import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal;

import javax.swing.*;
import java.nio.charset.Charset;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        int reply = JOptionPane.showConfirmDialog(null, "Vill du spela spel?", "Monster game", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            GamePlay game = new GamePlay();
            game.startGame();
        }
        else {
            System.exit(0);
        }

    }
}
