package com.studentcui.hotel.service.impl;

import com.studentcui.hotel.dao.BookMapper;
import com.studentcui.hotel.po.RoomType;
import com.studentcui.hotel.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public int cntConflict(String type, Date checkin, Date checkout) {
        return bookMapper.cntConflict(type, checkin, checkout);
    }

    @Override
    public List<RoomType> findAllRoomType() {
        return bookMapper.findAllRoomType();
    }

    @Override
    public int countvacant(String type) {
        return bookMapper.countvacant(type);
    }
}
