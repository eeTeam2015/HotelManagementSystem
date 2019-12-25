package com.studentcui.hotel.service.impl;

import com.studentcui.hotel.dao.RoomMapper;
import com.studentcui.hotel.po.OrderRoom;
import com.studentcui.hotel.po.Room;
import com.studentcui.hotel.po.RoomType;
import com.studentcui.hotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {
    @Autowired(required = false)
    private RoomMapper roomMapper;

    @Override
    public List<Room> findAllRoom() {
        List<Room> list = roomMapper.findAllRoom();
        return list;
    }

    @Override
    public List<Room> findCheckin() {
        List<Room> list = roomMapper.findCheckin();
        return list;
    }

    @Override
    public List<Room> findCheckout() {
        List<Room> list = roomMapper.findCheckout();
        return list;
    }

    @Override
    public void checkin(Room room) {
        roomMapper.checkin(room);
    }

    @Override
    public int checkout(String id) {
        return roomMapper.checkout(id);
    }

    @Override
    public void insertRoom(String id, String type) {
        roomMapper.insertRoom(id,type);
    }

    @Override
    public int deleteRoom(String id) {
        return roomMapper.deleteRoom(id);
    }

    @Override
    public List<RoomType> findAllRoomType() {
        return roomMapper.findAllRoomType();
    }

    @Override
    public int insertRoomType(RoomType roomType) {
        return roomMapper.insertRoomType(roomType);
    }

    @Override
    public int deleteType(String name) {
        return roomMapper.deleteType(name);
    }

    @Override
    public int countvacant(String type) {
        return roomMapper.countvacant(type);
    }

//    @Override
//    public int countConflict(String type, String checkin, String checkout) {
//        return roomMapper.countConflict(type, checkin, checkout);
//    }

    @Override
    public int insertOrder(OrderRoom orderRoom) {
        return roomMapper.insertOrder(orderRoom);
    }

    @Override
    public List<OrderRoom> findAllOrder() {
        return roomMapper.findAllOrder();
    }

    @Override
    public int delOrder(int id) {
        return roomMapper.delOrder(id);
    }

    @Override
    public int updatePrice(int price, String name) {
        return roomMapper.updatePrice(price,name);
    }


}
