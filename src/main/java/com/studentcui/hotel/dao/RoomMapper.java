package com.studentcui.hotel.dao;

import com.studentcui.hotel.po.Room;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RoomMapper {
    @Select("select * from room")
    public List<Room> findAllRoom();

    @Insert("insert into room(id, type) values(#{id},#{type})")
    public boolean insertRoom(@Param("id")String id, @Param("type")String type);
}
