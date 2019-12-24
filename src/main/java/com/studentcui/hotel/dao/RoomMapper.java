package com.studentcui.hotel.dao;

import com.studentcui.hotel.po.Room;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface RoomMapper {
    @Select("select * from room")
    public List<Room> findAllRoom();

    @Select("select * from room where state='未入住'")
    public List<Room> findCheckin();

    @Select("select * from room where state='已入住'")
    public List<Room> findCheckout();

    @Update("update room set state=#{state}, guestname=#{guestname},  guestid=#{guestid}, checkin=#{checkin}, checkout=#{checkout} where id = #{id}")
    public void checkin(Room room);

    @Update("update room set state='未入住', guestname=null, guestid=null,  checkin=null, checkout=null where id=#{id}")
    public int checkout(@Param("id")String id);

    @Insert("insert into room(id, type) values(#{id},#{type})")
    public boolean insertRoom(@Param("id")String id, @Param("type")String type);

    @Delete("delete from room where id = #{id}")
    public int deleteRoom(@Param("id")String id);
}
