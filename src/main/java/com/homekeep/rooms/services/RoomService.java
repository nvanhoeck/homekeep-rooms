package com.homekeep.rooms.services;

import com.homekeep.rooms.dtos.RoomDto;
import com.homekeep.rooms.entities.RoomEntity;

import java.util.List;
import java.util.Optional;

public interface RoomService {
    List<RoomEntity> findAll();

    Optional<RoomEntity> findById(Long id);

    RoomEntity updateRoom(RoomEntity roomEntity);

    boolean delete(Long id);

    RoomEntity addRoom(RoomEntity roomEntity);
}
