package com.ske.snakebaddesign.models;

import java.util.Random;

/**
 * Created by FTTX on 3/17/2016 AD.
 */
public class WarpSquare extends Square {


    @Override
    public int effect() {
       return warp();
    }

    public int warp() {
        return new Random().nextInt(37);
    }
}
