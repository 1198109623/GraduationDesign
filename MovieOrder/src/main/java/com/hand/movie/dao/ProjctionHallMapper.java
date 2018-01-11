package com.hand.movie.dao;

import com.hand.movie.bean.ProjctionHall;
import com.hand.movie.bean.ProjctionHallExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProjctionHallMapper {
    long countByExample(ProjctionHallExample example);

    int deleteByExample(ProjctionHallExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProjctionHall record);

    int insertSelective(ProjctionHall record);

    List<ProjctionHall> selectByExample(ProjctionHallExample example);

    ProjctionHall selectByPrimaryKey(Integer id);

    List<ProjctionHall> selectByExampleWithSeat(ProjctionHallExample example);

    ProjctionHall selectByPrimaryKeyWithSeat(Integer id);

    int updateByExampleSelective(@Param("record") ProjctionHall record, @Param("example") ProjctionHallExample example);

    int updateByExample(@Param("record") ProjctionHall record, @Param("example") ProjctionHallExample example);

    int updateByPrimaryKeySelective(ProjctionHall record);

    int updateByPrimaryKey(ProjctionHall record);
}