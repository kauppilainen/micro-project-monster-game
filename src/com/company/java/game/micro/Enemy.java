package com.company.java.game.micro;

public class Enemy {

    private int x;
    private int y;

    private ID id;
    Player player;
    char enemyChar = 'B';

    // Constructor (Starting position)
    public Enemy(int x, int y, ID id, Player prey) {

        this.player = prey;
        this.id = id;
        this.x = x;
        this.y = y;
        setX(x);
        setY(y);

    }

    public void uppdatePosition() {

        setX(this.x);
        setY(this.y);

    }

    public int getX() {
        return x;
    }

    public void setX(int x) {

        if (player.getX() < x) {
            this.x = x - 1;
        } else if (player.getX() > x) {
            this.x = x + 1;
        }
    }


    public int getY() {
        return y;
    }

    public void setY(int y) {
        if (player.getY() < y) {
            this.y = y - 1;
        } else if (player.getY() > y) {
            this.y = y + 1;
        }
    }


}
