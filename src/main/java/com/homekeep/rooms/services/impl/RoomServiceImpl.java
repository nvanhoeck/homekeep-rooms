package com.homekeep.rooms.services.impl;

import com.homekeep.rooms.entities.RoomEntity;
import com.homekeep.rooms.repositories.RoomRepository;
import com.homekeep.rooms.services.RoomService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;

    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public List<RoomEntity> findAll() {
        return this.roomRepository.findAll();
    }

    @Override
    public Optional<RoomEntity> findById(Long id) {
        return this.roomRepository.findById(id);
    }
}
