package com.hand.movie.dao;

import com.hand.movie.bean.Seat;
import com.hand.movie.bean.SeatExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SeatMapper {
    long countByExample(SeatExample example);

    int deleteByExample(SeatExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Seat record);

    int insertSelective(Seat record);

    List<Seat> selectByExample(SeatExample example);

    Seat selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Seat record, @Param("example") SeatExample example);

    int updateByExample(@Param("record") Seat record, @Param("example") SeatExample example);

    int updateByPrimaryKeySelective(Seat record);

    int updateByPrimaryKey(Seat record);
}