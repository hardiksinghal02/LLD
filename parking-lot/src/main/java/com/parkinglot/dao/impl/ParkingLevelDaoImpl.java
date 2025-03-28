package com.parkinglot.dao.impl;

import com.lld.dao.impl.AbstractDaoImpl;
import com.parkinglot.dao.ParkingLevelDao;
import com.parkinglot.entities.ParkingLevel;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class ParkingLevelDaoImpl extends AbstractDaoImpl<ParkingLevel> implements ParkingLevelDao {

    private final Map<String, Set<ParkingLevel>> parkingLotIdMapping;

    public ParkingLevelDaoImpl() {
        parkingLotIdMapping = new HashMap<>();
    }

    @Override
    public Optional<ParkingLevel> save(ParkingLevel parkingLevel) {
        Optional<ParkingLevel> saved = super.save(parkingLevel);

        if(saved.isEmpty()) {
            return saved;
        }

        if(!parkingLotIdMapping.containsKey(parkingLevel.getParkingLotId())) {
            parkingLotIdMapping.put(parkingLevel.getParkingLotId(), new HashSet<>());
        }

        parkingLotIdMapping.get(parkingLevel.getParkingLotId()).add(idMap.get(parkingLevel.getId()));
        return saved;
    }

    @Override
    public List<ParkingLevel> findAllParkingLevels(String parkingLotId) {
        if(!parkingLotIdMapping.containsKey(parkingLotId)) {
            return Collections.emptyList();
        }

        return parkingLotIdMapping.get(parkingLotId)
                .stream()
                .map(ParkingLevel::clone)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}
