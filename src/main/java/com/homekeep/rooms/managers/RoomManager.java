package com.homekeep.rooms.managers;

import com.homekeep.rooms.dtos.RoomDto;

import java.util.List;

public interface RoomManager {
    List<RoomDto> findAll();

    RoomDto findById(Long id);

    RoomDto updateRoom(RoomDto roomDto);

    boolean delete(Long id);

    RoomDto addRoom(RoomDto roomDto);
}
