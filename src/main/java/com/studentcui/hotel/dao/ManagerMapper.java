package com.studentcui.hotel.dao;

import com.studentcui.hotel.po.Manager;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ManagerMapper {
    @Select("select * from manager where name = #{managername} and password = #{password}")
    public Manager findManager(@Param("managername")String managername,@Param("password")String password);
}
