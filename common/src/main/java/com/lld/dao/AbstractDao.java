package com.lld.dao;


import com.lld.entity.AbstractEntity;

import java.util.List;
import java.util.Optional;

public interface AbstractDao<T extends AbstractEntity<T>> {

    Optional<T> save(T entity);

    Optional<T> findById(String id);

    List<T> fetchAll();
}
