package com.hand.movie.dao;

import com.hand.movie.bean.Evaluation;
import com.hand.movie.bean.EvaluationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EvaluationMapper {
    long countByExample(EvaluationExample example);

    int deleteByExample(EvaluationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Evaluation record);

    int insertSelective(Evaluation record);

    List<Evaluation> selectByExample(EvaluationExample example);

    Evaluation selectByPrimaryKey(Integer id);

    List<Evaluation> selectByExampleWithUserAndMovie(EvaluationExample example);

    Evaluation selectByPrimaryKeyWithUserAndMovie(Integer id);

    int updateByExampleSelective(@Param("record") Evaluation record, @Param("example") EvaluationExample example);

    int updateByExample(@Param("record") Evaluation record, @Param("example") EvaluationExample example);

    int updateByPrimaryKeySelective(Evaluation record);

    int updateByPrimaryKey(Evaluation record);
}