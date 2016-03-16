package com.ske.snakebaddesign.models;

/**
 * Created by FTTX on 3/16/2016 AD.
 */
public class Player {

    private Piece piece;
    private String name;
    private int num;

    public Player(String name,int num) {
        piece = new Piece(0);
        this.name = name;
        this.num = num;
    }

    public int getPosition() {
        return piece.getPosition();
    }

    public void setPosition(int position) {
        piece.setPosition(position);
    }

    public String getName() {
        return name;
    }
    public int getNum() {
        return num;
    }

}
