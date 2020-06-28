package com.homekeep.rooms.beans;

import com.homekeep.rooms.controllers.RoomsController;
import com.homekeep.rooms.dtos.RoomDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

@Configuration
public class AzureFunctionsConfig {
    @Bean(name = "get-rooms")
    public Supplier<List<RoomDto>> rooms(RoomsController roomsController) {
        return roomsController::getRooms;
    }

    @Bean(name = "add-room")
    Function<RoomDto, RoomDto> addRoom(RoomsController roomsController) {return roomsController::addRoom;}

    @Bean(name = "update-room")
    Function<RoomDto, RoomDto> updateRoom(RoomsController roomsController) {return roomsController::updateRoom;}

    @Bean(name = "delete-room")
    Function<Long, Boolean> deleteRoom(RoomsController roomsController) {return roomsController::deleteRoom;}
}
