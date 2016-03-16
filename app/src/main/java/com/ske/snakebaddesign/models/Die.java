package com.ske.snakebaddesign.models;

import java.util.Random;

/**
 * Created by FTTX on 3/16/2016 AD.
 */
public class Die {

    public int rollDie() {
        final int value = 1 + new Random().nextInt(6);
        return value;
    }

}
