package com.company.java.game.micro;


public class Player {

    private int x, y;
    public char character = 'O';

    public Player(int x, int y) {
//        this.x=x;
//        this.y=y;
        setY(y);
        setX(x);
    }

    public char getCharacter() {
        return character;
    }

    public void setCharacter(char character) {
        this.character = character;
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


    // How to walk around?

    // Constructor (position)


}


