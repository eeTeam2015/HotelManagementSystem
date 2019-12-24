package com.studentcui.hotel.service.impl;

import com.studentcui.hotel.dao.RoomMapper;
import com.studentcui.hotel.po.Room;
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

}
