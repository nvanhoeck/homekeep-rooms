package com.homekeep.rooms.services;

import com.homekeep.rooms.entities.RoomEntity;

import java.util.List;
import java.util.Optional;

public interface RoomService {
    List<RoomEntity> findAll();

    Optional<RoomEntity> findById(Long id);
}
