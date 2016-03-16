package com.ske.snakebaddesign.models;

import com.ske.snakebaddesign.activities.GameActivity;

import java.util.Observable;

/**
 * Created by FTTX on 3/16/2016 AD.
 */
public class Game extends Observable {

    private Player player1;
    private Player player2;
    private Die die;
    private Board board;
    private int turn;

    public Game() {
        player1 = new Player("Player1",1);
        player2 = new Player("Player2",2);
        die = new Die();
        board = new Board(6,player1.getPosition(),player2.getPosition());
        turn = 0;
    }

    public int takeTurn() {
        return die.rollDie();
    }

    public void moveCurrentPiece(int value) {
        if(turn % 2 == 0) {
            player1.setPosition(adjustPosition(player1.getPosition(), value));
            board.setP1Position(player1.getPosition());
            setChanged();
            notifyObservers(player2);

        }
        else {
            player2.setPosition(adjustPosition(player2.getPosition(), value));
            board.setP2Position(player2.getPosition());
            setChanged();
            notifyObservers(player1);
        }
        checkWin();
        turn++;
    }

    public String checkWin() {
        if(player1.getPosition() == board.getBoardSize()*board.getBoardSize()-1)
            return "Player 1's Win.";
        else if(player2.getPosition() == board.getBoardSize()*board.getBoardSize()-1)
            return "Player 2's Win.";
        else
            return "";

    }

    public int adjustPosition(int current, int distance) {
        current = current+distance;
        int maxSquare = board.getBoardSize() * board.getBoardSize() - 1;
        if(current > maxSquare) {
            current = maxSquare - (current - maxSquare);
        }
        return current;
    }

    public void resetGame() {
        player1 = new Player("Player1",1);
        player2 = new Player("Player2",2);
        die = new Die();
        board = new Board(6, player1.getPosition(),player2.getPosition());
        turn = 0;
    }

    public int getBoardSize() {
        return board.getBoardSize();
    }

    public int getP1Position() {
        return board.getP1Position();
    }
    public int getP2Position() {
        return board.getP2Position();
    }


    public String getPlayer1Name() {
        return player1.getName();
    }

}
