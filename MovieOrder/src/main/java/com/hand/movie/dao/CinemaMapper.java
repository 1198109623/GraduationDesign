package com.hand.movie.dao;

import com.hand.movie.bean.Cinema;
import com.hand.movie.bean.CinemaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CinemaMapper {
    long countByExample(CinemaExample example);

    int deleteByExample(CinemaExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Cinema record);

    int insertSelective(Cinema record);

    List<Cinema> selectByExample(CinemaExample example);

    Cinema selectByPrimaryKey(Integer id);

    Cinema selectByCinemaName(String cinemaName);

    List<Cinema> selectByName(String cinemaName);

    List<Cinema> selectByExampleWithProjHall(CinemaExample example);

    Cinema selectByPrimaryKeyWithProjHall(Integer id);

    List<Cinema> selectByExampleWithPMS(CinemaExample example);

    Cinema selectByPrimaryKeyWithPMS(Integer id);

    int updateByExampleSelective(@Param("record") Cinema record, @Param("example") CinemaExample example);

    int updateByExample(@Param("record") Cinema record, @Param("example") CinemaExample example);

    int updateByPrimaryKeySelective(@Param("record")Cinema record);

    int updateByPrimaryKey(Cinema record);
}