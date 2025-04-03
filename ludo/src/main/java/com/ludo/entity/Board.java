package com.ludo.entity;

import lombok.Getter;

import java.util.List;

@Getter
public abstract class Board {
    private List<Cell> cells;
}
