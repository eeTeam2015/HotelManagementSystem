package com.studentcui.hotel.dao;

import com.studentcui.hotel.po.OrderRoom;
import com.studentcui.hotel.po.Room;
import com.studentcui.hotel.po.RoomType;
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

    @Select("select * from roomType")
    public List<RoomType> findAllRoomType();

    @Insert("insert into roomType values(#{name}, #{price})")
    public int insertRoomType(RoomType roomType);

    @Delete("delete from roomType where name = #{name}")
    public int deleteType(@Param("name")String name);

    @Select("select count(*) from room where type=#{type} and state = '未入住'")
    public int countvacant(@Param("type")String type);

//    @Select("select count(*) from order where type=#{type} and checkin < #{checkout} and checkout > #{checkin}")
//    public int countConflict(@Param("type")String type, @Param("checkin")String checkin, @Param("checkout")String checkout);

    @Insert("insert into orderRoom(type, checkin, checkout, price, guestname, guestid) values (#{type}, #{checkin}, #{checkout}, #{price}, #{guestname}, #{guestid})")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    public int insertOrder(OrderRoom orderRoom);

    @Select("select * from orderRoom")
    public List<OrderRoom> findAllOrder();

    @Delete("delete from orderRoom where id = #{id}")
    public int delOrder(@Param("id")int id);
}
