package com.ske.snakebaddesign.models;

/**
 * Created by FTTX on 3/17/2016 AD.
 */
public class NormalSquare extends Square {
    @Override
    public int effect() {
        return doNothing();
    }

    public int doNothing() {
        return -1;
    }
}
