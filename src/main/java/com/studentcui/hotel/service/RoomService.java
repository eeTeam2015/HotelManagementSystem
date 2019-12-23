package com.studentcui.hotel.service;

import com.studentcui.hotel.po.Room;

import java.util.List;

public interface RoomService {
    public List<Room> findAllRoom();

    public boolean insertRoom(String id, String type);
}
