package com.studentcui.hotel.service;

import com.studentcui.hotel.po.RoomType;
import org.apache.ibatis.annotations.Param;

import java.sql.Date;
import java.util.List;

public interface BookService {

    public int cntConflict(String type, Date checkin, Date checkout);


    public List<RoomType> findAllRoomType();

    public int countvacant(String type);
}
