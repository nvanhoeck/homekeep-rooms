package com.homekeep.rooms.controllersIT;

import com.homekeep.SampleDataUtil;
import com.homekeep.rooms.controllers.RoomsController;
import com.homekeep.rooms.dtos.RoomDto;
import com.homekeep.rooms.repositories.RoomRepository;
import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ActiveProfiles("test")
@TestPropertySource(locations = "classpath:test.properties")
public class RoomsControllerIT {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private RoomsController roomsController;


    @Test
    public void whenFindAll_ReturnsRoomsDtos() {
        this.roomRepository.saveAndFlush(SampleDataUtil.buildRoomEntity("Testroom"));
        List<RoomDto> roomDtos = roomsController.getRooms();
        assertThat(roomDtos).extracting("id", "name").contains(Tuple.tuple(1L, "Testroom"));
    }
}
