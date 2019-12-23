package com.studentcui.hotel.service.impl;

import com.studentcui.hotel.dao.RoomMapper;
import com.studentcui.hotel.po.Room;
import com.studentcui.hotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomMapper roomMapper;

    @Override
    public List<Room> findAllRoom() {
        List<Room> list = roomMapper.findAllRoom();
        return list;
    }

    @Override
    public boolean insertRoom(String id, String type) {
        if(roomMapper.insertRoom(id,type))
            return true;
        else
            return false;
    }

}
