package com.ludo.entity;

import com.lld.entity.AbstractEntity;
import com.ludo.enums.Color;

public class Player extends AbstractEntity<Player> {

    private String name;
    private Color color;
    private String gameId;

    @Override
    public Player clone() {
        return null;
    }
}
