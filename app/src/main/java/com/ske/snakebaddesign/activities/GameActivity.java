package com.ske.snakebaddesign.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ske.snakebaddesign.R;
import com.ske.snakebaddesign.guis.BoardView;
import com.ske.snakebaddesign.models.Game;
import com.ske.snakebaddesign.models.Player;

import java.util.Observable;
import java.util.Observer;
import java.util.Random;

public class GameActivity extends AppCompatActivity implements Observer {

    private Game game;
    private BoardView boardView;
    private Button buttonTakeTurn;
    private Button buttonRestart;
    private TextView textPlayerTurn;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        initComponents();
    }

    @Override
    protected void onStart() {
        super.onStart();
        resetGame();
    }

    private void initComponents() {
        game = new Game();
        game.addObserver(this);
        boardView = (BoardView) findViewById(R.id.board_view);
        buttonTakeTurn = (Button) findViewById(R.id.button_take_turn);
        buttonTakeTurn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                takeTurn();
            }
        });
        buttonRestart = (Button) findViewById(R.id.button_restart);
        buttonRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetGame();
            }
        });
        textPlayerTurn = (TextView) findViewById(R.id.text_player_turn);
    }

    private void resetGame() {
        game.resetGame();
        boardView.setBoardSize(game.getBoardSize());
        boardView.setP1Position(game.getP1Position());
        boardView.setP2Position(game.getP2Position());
        textPlayerTurn.setText(game.getPlayer1Name() + "'s Turn");
    }

    private void takeTurn() {
        final int value = game.takeTurn();
        String title = "You rolled a die";
        String msg = "You got " + value;
        OnClickListener listener = new OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                game.moveCurrentPiece(value);
                checkWin();
                dialog.dismiss();
            }
        };
        displayDialog(title, msg, listener);
    }


    private void checkWin() {
        String title = "Game Over";
        String msg = "";
        OnClickListener listener = new OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                resetGame();
                dialog.dismiss();
            }
        };
        msg = game.checkWin();

        if(msg.equals(""))
            return;
        displayDialog(title, msg, listener);
    }

    private void displayDialog(String title, String message, DialogInterface.OnClickListener listener) {
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle(title);
        alertDialog.setMessage(message);
        alertDialog.setCancelable(false);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK", listener);
        alertDialog.show();
    }

    @Override
    public void update(Observable observable, Object data) {
        if(data == null) return;
        if(data.getClass() != Player.class) return;
        Player player = (Player)data;
//        boardView.setPosition(player);
        boardView.setP1Position(game.getP1Position());
        boardView.setP2Position(game.getP2Position());
        textPlayerTurn.setText(player.getName() + "'s Turn");

    }
}
