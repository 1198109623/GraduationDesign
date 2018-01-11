package com.hand.movie.service.impl;

import com.hand.movie.bean.ProjctionHall;
import com.hand.movie.dao.ProjctionHallMapper;
import com.hand.movie.service.ProjectionHallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectionHallServiceImpl implements ProjectionHallService{

    @Autowired
    ProjctionHallMapper projctionHallMapper;

    public List<ProjctionHall> getAll(){

        return projctionHallMapper.selectByExample(null);
    }

}
