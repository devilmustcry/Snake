package com.ske.snakebaddesign.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by FTTX on 3/16/2016 AD.
 */
public class Board {

    private int boardSize;
    private int p1Position;
    private int p2Position;
    List<Square> squareList;

    public Board(int boardSize, int p1Position, int p2Position) {
        this.boardSize = boardSize;
        this.p1Position = p1Position;
        this.p2Position = p2Position;
        squareList = new ArrayList<Square>();
        for(int i =1; i<=boardSize*boardSize;i++) {
            if(i==3||i==7||i==10||i==24) squareList.add(new WarpSquare());
            else squareList.add(new NormalSquare());
        }
    }

    public int getBoardSize() {
        return boardSize;
    }

    public void setBoardSize(int boardSize) {
        this.boardSize = boardSize;
    }

    public void setP1Position(int p1Position) {
        this.p1Position = p1Position;
    }

    public void setP2Position(int p2Position) {
        this.p2Position = p2Position;
    }

    public int getP1Position() {

        return p1Position;
    }

    public int getP2Position() {
        return p2Position;
    }

    public List<Square> getSquareList() {
        return squareList;
    }

    public Square getSquare(int i) {
        return squareList.get(i);
    }
}
