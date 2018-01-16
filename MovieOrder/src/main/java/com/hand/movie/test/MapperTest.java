package com.hand.movie.test;

import com.hand.movie.bean.Movie;
import com.hand.movie.dao.*;
import com.hand.movie.utils.ImageByte;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class MapperTest {

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    UserMapper userMapper;

    @Autowired
    MovieMapper movieMapper;

    @Autowired
    CinemaMapper cinemaMapper;

    @Autowired
    ProjctionHallMapper projctionHallMapper;

    @Autowired
    CinemaProjectionHallMapper cinemaProjectionHallMapper;

    @Autowired
    MovieProjHallMapper mpMapper;

    public MapperTest() throws IOException {
    }

    @Test
    public void testCRUD() throws IOException {
//        Order-User
//        userMapper.insertSelective(new User(null,"admin","admin","0"));
//
//        orderMapper.insertSelective(new Order(null,1,12.00,"12","12","12"));
//        List<Order> list= orderMapper.selectByExampleWithUser(null);
//        System.out.println(list);

        //Movie
//        取出数据库中的图片
//        Movie movie = movieMapper.selectByPrimaryKey(11);
//        ImageByte imageByte = new ImageByte();
//        try {
//            imageByte.getImageFromDB(movie,imageByte);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        //根据路径向数据库中修改或插入图片(byte)
//        Movie movie = movieMapper.selectByPrimaryKey(1);
//        ImageByte imageByte = new ImageByte();
//        byte[] data = imageByte.setImageToByte(imageByte,"zylm.jpg");
//        movie.setPicture(data);
//        movieMapper.updateByPrimaryKeyWithBLOBs(movie);

//        Movie movie = movieMapper.selectByPrimaryKey(1);
//        DateFormat df= new SimpleDateFormat("yyyy年MM月dd日");
//        String result=df.format(movie.getShowTime());
//        System.out.println(result);

//        System.out.println(movieMapper.selectByMovieName("正义联盟"));


//        Cinema
        //新增一个电影院以及给该电影院添加放映厅
//        cinemaMapper.insertSelective(new Cinema(null,"1","2","3",null));
//        List<Cinema> list = cinemaMapper.selectByExample(null);
//        Integer cinemaid = list.get(list.size()-1).getCinemaId();
//        System.out.println("cinemaid:"+cinemaid);
//        cinemaProjectionHallMapper.insertSelective(new CinemaProjectionHall(null,cinemaid,1));
//        System.out.println(cinemaMapper.selectByCinemaName("4"));
//        cinemaMapper.updateByPrimaryKey(new Cinema(3,"3","q","3"));
//        System.out.println(cinemaMapper.selectByPrimaryKey(3));

//        Cinema-ProjectionHall
//        System.out.println(cinemaMapper.selectByExampleWithProjHall(null));
//        System.out.println(cinemaMapper.selectByPrimaryKeyWithProjHall(1));
//        System.out.println("selectByName:"+cinemaMapper.selectByName("w"));

//        Projection_Hall-Movie-Seat
//        System.out.println(projctionHallMapper.selectByExampleWithSeat(null));


//        Projection_Hall-Movie
//        System.out.println(mpMapper.selectByExampleWithMP(null));
//        System.out.println(mpMapper.selectByPrimaryKeyWithMP(1));
        System.out.println(mpMapper.selectByExampleWithMPBypName("一号放映厅"));
    }
}
