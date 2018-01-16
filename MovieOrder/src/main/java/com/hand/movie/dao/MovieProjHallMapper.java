package com.hand.movie.dao;

import com.hand.movie.bean.MovieProjHall;
import com.hand.movie.bean.MovieProjHallExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MovieProjHallMapper {
    long countByExample(MovieProjHallExample example);

    int deleteByExample(MovieProjHallExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MovieProjHall record);

    int insertSelective(MovieProjHall record);

    List<MovieProjHall> selectByExample(MovieProjHallExample example);

    List<MovieProjHall> selectByExampleWithMP(MovieProjHallExample example);

    MovieProjHall selectByPrimaryKey(Integer id);

    MovieProjHall selectByPrimaryKeyWithMP(Integer id);

    List<MovieProjHall> selectByExampleWithMPBypName(String pName);

    int updateByExampleSelective(@Param("record") MovieProjHall record, @Param("example") MovieProjHallExample example);

    int updateByExample(@Param("record") MovieProjHall record, @Param("example") MovieProjHallExample example);

    int updateByPrimaryKeySelective(MovieProjHall record);

    int updateByPrimaryKey(MovieProjHall record);
}