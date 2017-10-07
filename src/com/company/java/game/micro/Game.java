package com.company.java.game.micro;

import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal;

import javax.swing.*;
import java.nio.charset.Charset;

public class Game {

    public void startGame() throws InterruptedException {
        int points = 0;
        Player player = new Player(10, 10);
        Enemy enemy1 = new Enemy(0, 0, ID.Enemy, player);
        Enemy enemy2 = new Enemy(19, 19, ID.Enemy, player);


        // New terminal object
        Terminal terminal = TerminalFacade.createTerminal(System.in, System.out, Charset.forName("UTF8"));
        terminal.enterPrivateMode();

        // Create board
        int[][] board = new int[20][20];            // Spelfältet
        terminal.applyBackgroundColor(0, 0, 0);   // Bakgrundsfärg (Svart, grått, annan färg?)


        // Block character to draw if not player or enemy position
        char block = '\u2588';

        Enemy[] enemy = new Enemy[2];
        enemy[0] = enemy1;
        enemy[1] = enemy2;

        // Get obstacle position (IF WE'RE GOING TO USE OBSTACLES)

        while (true) {
            //region Dumma kommentarer
            // Denna del blir spelarens, fiende och obstacles koordinater

            // New position and old position?

            // Get player position

            // Get enemy position (loop that checks how many enemy intstances are live)
            // Enemy array
            // Get position from every enemy in loop

            // OBS! DENNA IDÉ KANSKE INTE FUNKAR. JAG SAKNAR FÖRSTÅELSE
            // Värdet på boarden
            //endregion

            //Draw the screen black
            for (int i = 0; i < board.length; i++) {            // loop for y-coordinate
                for (int j = 0; j < board[0].length; j++) {     // loop for x-coordinate
                    terminal.moveCursor(j, i);  // (x, y)
                    int color = 0;                                      // Denna färg är vit
                    terminal.applyForegroundColor(color, color, color); // R,G,B
                    terminal.putCharacter(block);            // Enemy character, not chosen yet.

                }
            }

            // Draw player and enemies
            // Player
            terminal.moveCursor(player.getX(), player.getY());
            int color = 255;                                    // Denna färg är vit
            terminal.applyForegroundColor(color, color, color); // R,G,B
            terminal.putCharacter(player.getCharacter());

            // Monster
            for (int i = 0; i < enemy.length; i++) {
                terminal.moveCursor(enemy[i].getX(), enemy[i].getY());  // (x, y)
                color = 255;                                      // Denna färg är vit
                terminal.applyForegroundColor(color, color, color); // R,G,B
                terminal.putCharacter(enemy[i].enemyChar);
            }

            //Wait for a key to be pressed
            // This will be changed to arrow keys and cases of what arrow

            Key key;

            do {
                key = terminal.readInput();

                if (key != null) {
                    points += 3; // Increase score by 3 per movement
                    switch (key.getKind()) {
                        case ArrowLeft:
                            // player.getPosition();
                            System.out.println("left");
                            player.setX(player.getX() - 1);
//                            enemy1.getX();
//                            enemy2.getX();
                            break;
                        case ArrowDown:
                            System.out.println("down");
                            player.setY(player.getY() + 1);
//                            enemy1.getY();
//                            enemy2.getY();
                            break;
                        case ArrowRight:
                            System.out.println("right");
                            player.setX(player.getX() + 1);
//                            enemy1.getX();
//                            enemy2.getX();
                            break;
                        case ArrowUp:
                            System.out.println("up");
                            player.setY(player.getY() - 1);
//                            enemy1.getY();
//                            enemy2.getY();

                            break;
                    }
                }
                Thread.sleep(5);
            } while (key == null);

            enemy1.uppdatePosition();
            enemy2.uppdatePosition();
            if (enemy1.getX() == player.getX() && enemy1.getY() == player.getY() ||
                    enemy2.getX() == player.getX() && enemy2.getY() == player.getY()) {

                terminal.exitPrivateMode();
                JOptionPane.showMessageDialog(null, "GAME OVER\r\n Score: " + points);
            }
        }
    }
}
