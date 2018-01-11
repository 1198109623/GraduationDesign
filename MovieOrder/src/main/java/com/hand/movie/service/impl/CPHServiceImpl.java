package com.hand.movie.service.impl;

import com.hand.movie.bean.CinemaProjectionHallExample;
import com.hand.movie.bean.CinemaProjectionHallExample.Criteria;
import com.hand.movie.dao.CinemaProjectionHallMapper;
import com.hand.movie.service.CPHService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class CPHServiceImpl implements CPHService {

    @Autowired
    CinemaProjectionHallMapper CPHMapper;

    public void deleteCPH(Integer id) {
        CPHMapper.deleteByPrimaryKey(id);
    }

    public void deleteBatch(List<Integer> ids) {
        // TODO Auto-generated method stub
        CinemaProjectionHallExample example = new CinemaProjectionHallExample();
        Criteria criteria = example.createCriteria();
        //delete from xxx where emp_id in(1,2,3)
        criteria.andIdIn(ids);
        CPHMapper.deleteByExample(example);
    }
}
