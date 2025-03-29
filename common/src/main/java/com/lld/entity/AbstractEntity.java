package com.lld.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public abstract class AbstractEntity<T> {

    protected String id;
    protected boolean deleted;

    public abstract T clone();
}
