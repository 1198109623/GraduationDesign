package com.hand.movie.test;


import com.hand.movie.service.CPHService;
import com.hand.movie.service.CinemaService;
import com.hand.movie.service.MovieService;
import com.hand.movie.service.ProjectionHallService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class ServiceTest {



    @Autowired
    private CinemaService cinemaService;
    @Autowired
    private ProjectionHallService projectionHallService;
    @Autowired
    private CPHService cphService;
    @Autowired
    private MovieService movieService;


    public ServiceTest() throws IOException {
    }

    @Test
    public void testService() {
//        Cinema cinema = cinemaService.getCinemaWithProjHall(2);
//        System.out.println(cinemaService.getCinema(1));
//        Movie movie = movieMapper.selectByPrimaryKey(1);
//        ImageByte imageByte = new ImageByte();
//        try {
//            imageByte.getPicture(movie,imageByte);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        List<Cinema> list = cinemaService.getAll();
//        System.out.println(list);
//        cinemaService.saveCinema(new Cinema(null,"4","4","4"));
//        cinemaService.updateCinema(new Cinema(3,"qqq",null,null));



//        List<ProjctionHall> projctionHallList = projectionHallService.getAll();
//        System.out.println("projctionHallList:"+projctionHallList);


//        cphService.deleteCPH(15);
//        List<Integer> del_ids = new ArrayList<Integer>();
//        del_ids.add(17);
//        del_ids.add(18);
//        del_ids.add(19);
//        cphService.deleteBatch(del_ids);


        movieService.getMovieByName("奇门遁甲");
    }
}
