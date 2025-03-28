package com.parkinglot.dao.impl;

import com.lld.dao.impl.AbstractDaoImpl;
import com.parkinglot.dao.ParkingSpotDao;
import com.parkinglot.entities.ParkingSpot;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class ParkingSpotDaoImpl extends AbstractDaoImpl<ParkingSpot> implements ParkingSpotDao {

    private static final Map<String, Set<ParkingSpot>> parkingLevelIdMap = new HashMap<>();

    @Override
    public Optional<ParkingSpot> save(ParkingSpot spot) {
        Optional<ParkingSpot> resp = super.save(spot);

        if (resp.isEmpty()) {
            return resp;
        }

        if (!parkingLevelIdMap.containsKey(spot.getLevelId())) {
            parkingLevelIdMap.put(spot.getLevelId(), new HashSet<>());
        }

        parkingLevelIdMap.get(spot.getLevelId()).add(idMap.get(spot.getId()));
        return resp;
    }

    @Override
    public List<ParkingSpot> findByLevelId(String levelId) {
        if (!parkingLevelIdMap.containsKey(levelId)) {
            return Collections.emptyList();
        }

        return parkingLevelIdMap.get(levelId)
                .stream()
                .map(ParkingSpot::clone)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}
