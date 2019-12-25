package com.studentcui.hotel.dao;

import com.studentcui.hotel.po.RoomType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.sql.Date;
import java.util.List;


@Mapper
public interface BookMapper {

    @Select("select count(*) from orderRoom where type = #{type} and not((checkin > #{checkin,jdbcType=TIMESTAMP} and checkin >= #{checkout,jdbcType=TIMESTAMP}) or (checkout <= #{checkin,jdbcType=TIMESTAMP} and checkout < #{checkout,jdbcType=TIMESTAMP}))")
    public int cntConflict(@Param("type")String type, @Param("checkin")Date checkin, @Param("checkout")Date checkout);

    @Select("select * from roomType")
    public List<RoomType> findAllRoomType();

    @Select("select count(*) from room where type=#{type} and state = '未入住'")
    public int countvacant(@Param("type")String type);
}
