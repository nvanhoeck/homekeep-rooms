package com.homekeep.rooms.controllers;

import com.homekeep.rooms.dtos.RoomDto;
import com.homekeep.rooms.managers.RoomManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Controller
public class RoomsController {

    private final RoomManager roomManager;


    public RoomsController(RoomManager roomManager) {
        this.roomManager = roomManager;
    }

    public List<RoomDto> getRooms() {
        return this.roomManager.findAll();
    }

    public RoomDto getRoom(@PathVariable("id") Long id) {
        return this.roomManager.findById(id);
    }
}
