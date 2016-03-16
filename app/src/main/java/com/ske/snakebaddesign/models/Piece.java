package com.ske.snakebaddesign.models;

/**
 * Created by FTTX on 3/16/2016 AD.
 */
public class Piece {

    private int position;

    private Square square;

    public Piece(int position) {
        this.position = position;
    }
    public int getPosition() {
        return this.position;
    }

    public void setPosition(int position) {
        this.position = position;
    }



}
