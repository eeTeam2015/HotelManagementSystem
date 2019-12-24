package com.studentcui.hotel.service;

import com.studentcui.hotel.po.Room;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoomService {
    public List<Room> findAllRoom();

    public List<Room> findCheckin();

    public List<Room> findCheckout();

    public void checkin(Room room);

    public int checkout(@Param("id")String id);

    public void insertRoom(String id, String type);

    public int deleteRoom(String id);
}
