package com.homekeep.rooms.managers;

import com.homekeep.SampleDataUtil;
import com.homekeep.rooms.dtos.RoomDto;
import com.homekeep.rooms.entities.RoomEntity;
import com.homekeep.rooms.managers.impl.RoomManagerImpl;
import com.homekeep.rooms.services.RoomService;
import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RoomManagerTest {

    @InjectMocks
    private RoomManagerImpl fixture;

    @Mock
    private RoomService roomService;


    @Test
    public void whenFindAllRooms_returnRoomDtoList() {
        when(roomService.findAll()).thenReturn(new ArrayList<>(Arrays.asList(SampleDataUtil.buildRoomEntity(1L, "Testroom"))));
        List<RoomDto> roomDtos = this.fixture.findAll();
        assertThat(roomDtos).extracting("id", "name").contains(Tuple.tuple(1L, "Testroom"));
    }

    @Test
    public void whenUpdateRoom_returnUpdatedRoom() {
        RoomEntity sendRoomEnity = SampleDataUtil.buildRoomEntity( 1L,"updated");
        RoomDto sendRoomdto= SampleDataUtil.buildRoomDto( 1L, "updated");
        when(roomService.updateRoom(sendRoomEnity)).thenReturn(sendRoomEnity);
        RoomDto updatedRoom = this.fixture.updateRoom(sendRoomdto);
        assertThat(updatedRoom).isEqualTo(sendRoomdto);
    }

    @Test
    public void whenDeleteRoom_returnTrue() {
        when(roomService.delete(2L)).thenReturn(true);
        boolean deleted = this.fixture.delete(2L);
        assertTrue(deleted);
    }
}
