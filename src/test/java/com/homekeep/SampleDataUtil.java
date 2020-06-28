package com.homekeep;

import com.homekeep.rooms.dtos.RoomDto;
import com.homekeep.rooms.entities.RoomEntity;

public class SampleDataUtil {

    public static RoomEntity buildRoomEntity(String name) {
        RoomEntity roomEntity = new RoomEntity();
        roomEntity.setName(name);
        roomEntity.setIcon("icon");
        return roomEntity;
    }

    public static RoomEntity buildRoomEntity(Long id, String name) {
        RoomEntity roomEntity = new RoomEntity();
        roomEntity.setId(id);
        roomEntity.setName(name);
        roomEntity.setIcon("icon");
        return roomEntity;
    }

    public static RoomDto buildRoomDto(String name) {
        RoomDto roomDto = new RoomDto();
        roomDto.setName(name);
        roomDto.setIcon("icon");
        return roomDto;
    }

    public static RoomDto buildRoomDto(long id, String name) {
        RoomDto roomDto = new RoomDto();
        roomDto.setName(name);
        roomDto.setId(id);
        roomDto.setIcon("icon");
        return roomDto;
    }
}
