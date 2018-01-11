package com.hand.movie.dao;

import com.hand.movie.bean.CinemaProjectionHall;
import com.hand.movie.bean.CinemaProjectionHallExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CinemaProjectionHallMapper {
    long countByExample(CinemaProjectionHallExample example);

    int deleteByExample(CinemaProjectionHallExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CinemaProjectionHall record);

    int insertSelective(CinemaProjectionHall record);

    List<CinemaProjectionHall> selectByExample(CinemaProjectionHallExample example);

    CinemaProjectionHall selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CinemaProjectionHall record, @Param("example") CinemaProjectionHallExample example);

    int updateByExample(@Param("record") CinemaProjectionHall record, @Param("example") CinemaProjectionHallExample example);

    int updateByPrimaryKeySelective(CinemaProjectionHall record);

    int updateByPrimaryKey(CinemaProjectionHall record);
}