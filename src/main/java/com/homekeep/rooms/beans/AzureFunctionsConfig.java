package com.homekeep.rooms.beans;

import com.homekeep.rooms.controllers.RoomsController;
import com.homekeep.rooms.dtos.RoomDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;

@Configuration
public class AzureFunctionsConfig {
    @Bean
    public Supplier<List<RoomDto>> rooms(RoomsController roomsController) {
        return roomsController::getRooms;
    }
}
