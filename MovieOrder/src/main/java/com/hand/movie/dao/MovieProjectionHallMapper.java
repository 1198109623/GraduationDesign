package com.hand.movie.dao;

import com.hand.movie.bean.MovieProjectionHall;
import com.hand.movie.bean.MovieProjectionHallExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MovieProjectionHallMapper {
    long countByExample(MovieProjectionHallExample example);

    int deleteByExample(MovieProjectionHallExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MovieProjectionHall record);

    int insertSelective(MovieProjectionHall record);

    List<MovieProjectionHall> selectByExample(MovieProjectionHallExample example);

    MovieProjectionHall selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MovieProjectionHall record, @Param("example") MovieProjectionHallExample example);

    int updateByExample(@Param("record") MovieProjectionHall record, @Param("example") MovieProjectionHallExample example);

    int updateByPrimaryKeySelective(MovieProjectionHall record);

    int updateByPrimaryKey(MovieProjectionHall record);
}