package com.homekeep.rooms.managers.impl;

import com.homekeep.rooms.dtos.RoomDto;
import com.homekeep.rooms.entities.RoomEntity;
import com.homekeep.rooms.managers.RoomManager;
import com.homekeep.rooms.managers.exceptions.ResourceNotFoundException;
import com.homekeep.rooms.services.RoomService;
import lombok.SneakyThrows;
import ma.glasnost.orika.BoundMapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomManagerImpl implements RoomManager {

    private final RoomService roomService;
    private final MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
    private final BoundMapperFacade<RoomEntity, RoomDto> roomMapper = mapperFactory.getMapperFacade(RoomEntity.class, RoomDto.class);

    public RoomManagerImpl(RoomService roomService) {
        this.roomService = roomService;
    }

    @Override
    public List<RoomDto> findAll() {
        return this.roomService.findAll().stream()
                .map(roomMapper::map)
                .collect(Collectors.toList());

    }

    @SneakyThrows
    @Override
    public RoomDto findById(Long id) {
        return this.roomService.findById(id).map(this.roomMapper::map).orElseThrow(() -> new ResourceNotFoundException(String.format("Could not find resource for id: %d", id)));
    }
}
