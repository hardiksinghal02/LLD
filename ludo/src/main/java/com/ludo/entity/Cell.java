package com.ludo.entity;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Cell {
    private int row;
    private int column;
}
