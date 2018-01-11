package com.hand.movie.service.impl;

import com.hand.movie.bean.Cinema;
import com.hand.movie.bean.CinemaExample;
import com.hand.movie.bean.CinemaExample.Criteria;
import com.hand.movie.bean.CinemaProjectionHall;
import com.hand.movie.dao.CinemaMapper;
import com.hand.movie.dao.CinemaProjectionHallMapper;
import com.hand.movie.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CinemaServiceImpl implements CinemaService {

    @Autowired
    private CinemaMapper cinemaMapper;
    @Autowired
    private CinemaProjectionHallMapper cinemaProjectionHallMapper;

    /**
     * 查询所有电影院
     * @return
     */
    public List<Cinema> getAll(){
        return cinemaMapper.selectByExampleWithProjHall(null);
    }

    public Cinema getCinemaWithProjHall(Integer id){
        return cinemaMapper.selectByPrimaryKeyWithProjHall(id);
    }

    public Cinema getCinema(Integer id){
        return cinemaMapper.selectByPrimaryKey(id);
    }

    public List<Cinema> getCinemaByName(String cinemaName){
        return cinemaMapper.selectByName(cinemaName);
    }

    /**
     * 新增电影院以及放映厅
     * @param cinema
     */
    public int saveCinema(Cinema cinema) {
        List<Cinema> list = cinemaMapper.selectByExample(null);
        List<CinemaProjectionHall> cpList = cinemaProjectionHallMapper.selectByExample(null);
        Integer pId = cinema.getpId();

        int flag = 0;
        int flag2= 0;
        //判断数据库中是否已经有当前新增电影院的名字
        for (Cinema cinema1 :list){
//            System.out.println("cinema1.getCinemaName():"+cinema1.getCinemaName());
//            System.out.println("cinema.getCinemaName():"+cinema.getCinemaName());
            if (cinema1.getCinemaName().equals(cinema.getCinemaName())){
                flag = 1;
                break;
            }
        }
        if (flag == 0){
            cinemaMapper.insertSelective(cinema);
            Cinema c1 = cinemaMapper.selectByCinemaName(cinema.getCinemaName());
            cinemaProjectionHallMapper.insertSelective(new CinemaProjectionHall(null,c1.getCinemaId(), pId));
            return 0;
        }else {
            Cinema c2 = cinemaMapper.selectByCinemaName(cinema.getCinemaName());
            for(CinemaProjectionHall cp :cpList){
                if (cp.getCinemaId() == c2.getCinemaId() &&
                        cp.getProjectionHallId() == pId){
                    flag2 = 1;
                    break;
                }
            }
            if (flag2 == 0){
                cinemaProjectionHallMapper.insertSelective(new CinemaProjectionHall(null,c2.getCinemaId(),pId));
                return 1;
            }else {
                return 2;
            }
        }

    }

    /**
     * 电影院更新
     * @param cinema
     */
    public void updateCinema(Cinema cinema) {
        cinemaMapper.updateByPrimaryKeySelective(cinema);
    }

    /**
     * 员工删除
     * @param id
     */
    public void deleteEmp(Integer id) {
        cinemaMapper.deleteByPrimaryKey(id);
    }

    /**
     * 批量删除
     *
     */
    public void deleteBatch(List<Integer> ids) {
        CinemaExample cinemaExample = new CinemaExample();
        Criteria criteria = cinemaExample.createCriteria();
        //delete from xxx where cinema_id in(1,2,3)
        criteria.andIdIn(ids);
        cinemaMapper.deleteByExample(cinemaExample);
    }
}
