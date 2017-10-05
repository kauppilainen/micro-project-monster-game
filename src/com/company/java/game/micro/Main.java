package com.company.java.game.micro;

import com.googlecode.lanterna.*;
import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal;

import javax.swing.*;
import java.nio.charset.Charset;

public class Main {

    public static void main(String[] args) throws InterruptedException {


        GamePlay game = new GamePlay();
        game.startGame();
    }
}
