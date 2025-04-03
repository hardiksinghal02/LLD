package com.ludo.entity;

import com.lld.entity.AbstractEntity;
import lombok.Getter;

import java.util.List;

@Getter
public class Game extends AbstractEntity<Game> {

    private Board board;
    private List<Player> players;
    private Dice dice;


    @Override
    public Game clone() {
        // TODO
        return null;
    }
}
