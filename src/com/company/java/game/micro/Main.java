package com.company.java.game.micro;

import com.googlecode.lanterna.*;
import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal;

import java.nio.charset.Charset;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        // Instantiate objects
        // New player
        // New enemies
        // New lanterna object
        Player player = new Player(10, 10);
        Enemy enemy1 = new Enemy(0, 0, ID.Enemy, player);

        // New terminal object
        Terminal terminal = TerminalFacade.createTerminal(System.in, System.out, Charset.forName("UTF8"));
        terminal.enterPrivateMode();

        // Create board
        int[][] board = new int[20][20];            // Spelfältet
        terminal.applyBackgroundColor(0, 0, 0);   // Bakgrundsfärg (Svart, grått, annan färg?)


        // Block character to draw if not player or enemy position
        char block = '\u2588';

        Enemy[] enemy = new Enemy[1];
        enemy[0] = enemy1;

        // Get obstacle position (IF WE'RE GOING TO USE OBSTACLES)

        while (true) {
            // Denna del blir spelarens, fiende och obstacles koordinater

            // New position and old position?

            // Get player position

            // Get enemy position (loop that checks how many enemy intstances are live)
            // Enemy array
            // Get position from every enemy in loop

            // OBS! DENNA IDÉ KANSKE INTE FUNKAR. JAG SAKNAR FÖRSTÅELSE
            // Värdet på boarden

            //Draw the board on the screen
            for (int i = 0; i < board.length; i++) {            // loop for y-coordinate
                for (int j = 0; j < board[0].length; j++) {     // loop for x-coordinate

                    // Player position code
                    if (j == player.getX() && i == player.getY()) {
                        terminal.moveCursor(j, i);  // (x, y)
                        int color = 255;                                    // Denna färg är vit
                        terminal.applyForegroundColor(color, color, color); // R,G,B
                        terminal.putCharacter(player.getCharacter());            // Enemy character, not chosen yet.
                    } else {
                        terminal.moveCursor(j, i);  // (x, y)
                        int color = 0;                                      // Denna färg är vit
                        terminal.applyForegroundColor(color, color, color); // R,G,B
                        terminal.putCharacter(block);            // Enemy character, not chosen yet.
                    }
                    // Enemy position code
                    for (int k = 0; k < enemy.length; k++) {

                        if (j == enemy[k].getX() && i == enemy[k].getY()) {
                            // Draw enemy character
                            terminal.moveCursor(j, i);  // (x, y)
                            int color = 255;                                    // Denna färg är vit
                            terminal.applyForegroundColor(color, color, color); // R,G,B
                            terminal.putCharacter(enemy1.enemyChar);                      // Enemy character, not chosen yet.

                        } else {
                            if (j == player.getX() && i == player.getY()) {
                                break;
                            }
                            // Make backgroundcolor
                            terminal.moveCursor(j, i);
                            int color = 0;
                            terminal.applyForegroundColor(color, color, color);
                            terminal.putCharacter(block);
                        }
                    }

                /*
                    if(notPosition of player och enemies)
                        board
                    else{
                        is this player or enemy position
                */
                }

                /*
                    terminal.moveCursor(j, i); // (x, y)
                    int color = board[i][j];
                    terminal.applyForegroundColor(color, color, color); //red, green, blue
                    terminal.putCharacter('\u2588');
                */
            }

            //Wait for a key to be pressed
            // This will be changed to arrow keys and cases of what arrow

            Key key;

            do {
                key = terminal.readInput();

                if (key != null) {
                    switch (key.getKind()) {
                        case ArrowLeft:
                            // player.getPosition();
                            System.out.println("left");
                            player.setX(player.getX() - 1);
                            enemy1.getX();


                            break;
                        case ArrowDown:
                            System.out.println("down");
                            player.setY(player.getY() + 1);
                            enemy1.getY();
                            break;
                        case ArrowRight:
                            System.out.println("right");
                            player.setX(player.getX() + 1);
                            enemy1.getX();
                            break;
                        case ArrowUp:
                            System.out.println("up");
                            player.setY(player.getY() - 1);
                            enemy1.getY();

                            break;
                    }
                }

                Thread.sleep(5);

            }
            while (key == null);
            enemy1.uppdatePosition();
        }

    }
}
