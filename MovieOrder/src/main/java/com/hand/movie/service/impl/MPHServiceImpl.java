package com.hand.movie.service.impl;

import com.hand.movie.bean.MovieProjHall;
import com.hand.movie.bean.MovieProjHallExample;
import com.hand.movie.dao.MovieProjHallMapper;
import com.hand.movie.service.MPHService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hand.movie.bean.MovieProjHallExample.Criteria;

import java.util.List;


@Service
public class MPHServiceImpl implements MPHService {

    @Autowired
    MovieProjHallMapper mpMapper;

    public List<MovieProjHall> getAll() {
        return mpMapper.selectByExampleWithMP(null);
    }

    public List<MovieProjHall> getMPHBypName(String pName) {
        return mpMapper.selectByExampleWithMPBypName(pName);
    }

    public int saveMPH(MovieProjHall movieProjHall) {
        List<MovieProjHall> list = mpMapper.selectByExampleWithMP(null);

        int flag = 0;
        for (MovieProjHall mp:list){
            if (mp.getMovieId() == movieProjHall.getMovieId() &&
                    mp.getProjectionHallId() == movieProjHall.getProjectionHallId()){
                flag = 1;
                break;
            }
        }

        if (flag == 1){
            return 1;
        }else {
            mpMapper.insertSelective(movieProjHall);
            return 0;
        }
    }

    public MovieProjHall getMPById(Integer id) {
        return mpMapper.selectByPrimaryKeyWithMP(id);
    }

    public void updateMPH(MovieProjHall mph) {
        mpMapper.updateByPrimaryKeySelective(mph);
    }

    public void deleteMPH(Integer id) {
        mpMapper.deleteByPrimaryKey(id);
    }

    public void deleteBatch(List<Integer> ids) {
        MovieProjHallExample example = new MovieProjHallExample();
        Criteria criteria = example.createCriteria();
        criteria.andIdIn(ids);
        mpMapper.deleteByExample(example);
    }
}
