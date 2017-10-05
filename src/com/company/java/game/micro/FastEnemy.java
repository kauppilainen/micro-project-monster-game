package com.company.java.game.micro;


public class FastEnemy {

    private int x;
    private int y;

    private int velx;
    private int velY;
    private ID id;
    Player player;
    char enemyChar = 'F';

    // Constructor (Starting position)
    public FastEnemy(int x, int y, ID id) {

        this.x = x;
        this.y = y;
        this.id = id;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {

        if (player.getX() < this.x) {
            x = x - 3;
            this.x = x;
        } else if (player.getX() > this.x) {
            x = x + 3;
            this.x = x;
        }
    }

    public int getY() {
        return x;
    }

    public void setY(int x) {
        if (player.getY() < this.y) {
            y = y - 3;
            this.y = y;
        } else if (player.getY() > this.y) {
            y = y + 3;
            this.y = y;
        }
    }
}



