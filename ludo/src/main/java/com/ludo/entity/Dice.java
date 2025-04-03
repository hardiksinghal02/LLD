package com.ludo.entity;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Dice {
    private final int count;

    public int roll() {
        int total = 0;

        for (int i = 0; i < count; i++) {
            total += rollADice();
        }
        return total;
    }

    private int rollADice() {
        return (int) (Math.floor(Math.random() * 6.0) + 1);
    }
}
