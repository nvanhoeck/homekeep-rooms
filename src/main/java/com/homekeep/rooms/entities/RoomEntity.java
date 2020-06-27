package com.homekeep.rooms.entities;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity(name = "Room")
public class RoomEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private String name;
    @Column
    private String icon;
}
