package com.lld.dao.impl;


import com.lld.dao.AbstractDao;
import com.lld.entity.AbstractEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class AbstractDaoImpl<T extends AbstractEntity<T>> implements AbstractDao<T> {

    protected final Map<String, T> idMap;

    public AbstractDaoImpl() {
        this.idMap = new HashMap<>();
    }

    @Override
    public Optional<T> save(T entity) {

        try {
            T cloned = (T) entity.clone();

            if (cloned == null) {
                return Optional.empty();
            }

            idMap.put(cloned.getId(), cloned);
            return Optional.of(entity);

        } catch (Exception e) {
            System.out.println("Couldn't save data in DB : " + entity);
        }

        return Optional.empty();
    }


    public Optional<T> findById(String id) {
        if (!idMap.containsKey(id)) {
            return Optional.empty();
        }

        return Optional.of(idMap.get(id));
    }

    @Override
    public List<T> fetchAll() {
        return idMap.values()
                .stream()
                .map(AbstractEntity::clone)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}
