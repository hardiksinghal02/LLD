package com.lld.entity;

import lombok.Getter;

@Getter
public abstract class AbstractEntity<T> {

    protected String id;

    public abstract T clone();
}
