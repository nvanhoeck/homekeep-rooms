package com.homekeep.rooms.controllersIT;

import com.homekeep.SampleDataUtil;
import com.homekeep.rooms.controllers.RoomsController;
import com.homekeep.rooms.dtos.RoomDto;
import com.homekeep.rooms.entities.RoomEntity;
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
        RoomEntity storedRoom = this.roomRepository.saveAndFlush(SampleDataUtil.buildRoomEntity("Testroom"));
        List<RoomDto> roomDtos = roomsController.getRooms();
        assertThat(roomDtos).extracting("id", "name").contains(Tuple.tuple(storedRoom.getId(), "Testroom"));
    }

    @Test
    public void whenUpdateRoom_ReturnsUpdatedRoom() {
        this.roomRepository.saveAndFlush(SampleDataUtil.buildRoomEntity(2L, "UpdatingRoom"));
        RoomDto sendRoom = SampleDataUtil.buildRoomDto(2L, "UpdatedRoom");
        RoomDto updatedRoom = roomsController.updateRoom(sendRoom);
        assertThat(updatedRoom).isEqualTo(sendRoom);
    }
    @Test
    public void whenAddRoom_ReturnsUpdatedRoom() {
        RoomDto sendRoom = SampleDataUtil.buildRoomDto("New Room");
        RoomDto newRoom = roomsController.addRoom(sendRoom);
        assertThat(newRoom.getId()).isNotNull();
        assertThat(newRoom).extracting("name").isEqualTo(sendRoom.getName());
    }


    @Test
    public void whenDeleteRoom_ReturnTrue() {
        RoomEntity deleteMe = this.roomRepository.saveAndFlush(SampleDataUtil.buildRoomEntity("Delete me"));
        boolean isDeleted = roomsController.deleteRoom(deleteMe.getId());
        assertTrue(isDeleted);
    }
}
