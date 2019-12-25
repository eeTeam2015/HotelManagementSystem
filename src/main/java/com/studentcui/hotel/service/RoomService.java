package com.studentcui.hotel.service;

import com.studentcui.hotel.po.OrderRoom;
import com.studentcui.hotel.po.Room;
import com.studentcui.hotel.po.RoomType;
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

    public List<RoomType> findAllRoomType();

    public int insertRoomType(RoomType roomType);

    public int deleteType(@Param("name")String name);

    public int countvacant(@Param("type")String type);

    public int countConflict(String type,String checkin,String checkout);

    public int insertOrder(OrderRoom orderRoom);
}
