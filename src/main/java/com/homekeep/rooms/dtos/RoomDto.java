package com.homekeep.rooms.dtos;

import lombok.Data;
import org.hibernate.annotations.Immutable;

@Immutable
@Data
public class RoomDto {
    private Long id;
    private String name;
    private String icon;
}
