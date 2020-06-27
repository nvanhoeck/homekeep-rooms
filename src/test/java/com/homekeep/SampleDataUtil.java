package com.homekeep;

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

}
