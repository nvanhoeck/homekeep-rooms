package com.homekeep.rooms.controllers;

import com.homekeep.rooms.dtos.RoomDto;
import com.homekeep.rooms.managers.RoomManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@Controller
public class RoomsController {

    private final RoomManager roomManager;


    public RoomsController(RoomManager roomManager) {
        this.roomManager = roomManager;
    }

    public List<RoomDto> getRooms(Optional<?> empty) {
        return this.roomManager.findAll();
    }

    public RoomDto getRoom(@PathVariable("id") Long id) {
        return this.roomManager.findById(id);
    }

    public RoomDto addRoom(RoomDto roomDto) {
        return this.roomManager.addRoom(roomDto);
    }

    public RoomDto updateRoom(RoomDto roomDto) {
        return this.roomManager.updateRoom(roomDto);
    }

    public Boolean deleteRoom(Long id) {
        return this.roomManager.delete(id);
    }
}
