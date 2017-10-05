package com.company.java.game.micro;


import java.util.Random;

public class Obsticle {

    private int x;
    private int y;
    private ID id;
    char obsticle = '@';


    Random random = new Random();

    public Obsticle(int x, int y, ID id) {

        x = random.nextInt();
        y = random.nextInt();

        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}


