package com.hand.movie.service.impl;

import com.hand.movie.bean.Cinema;
import com.hand.movie.bean.Movie;
import com.hand.movie.bean.MovieExample;
import com.hand.movie.dao.MovieMapper;
import com.hand.movie.service.MovieService;
import com.hand.movie.utils.ImageByte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hand.movie.bean.MovieExample.Criteria;

import java.io.IOException;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieMapper movieMapper;

    public Movie getMovie(Integer id){
        return movieMapper.selectByPrimaryKey(id);
    }


    public List<Movie> getAll() {
//        List<Movie> list1 = movieMapper.selectByExampleWithBLOBs(null);
//        for (Movie movie :list1){
//
//            ImageByte imageByte = new ImageByte();
//            try {
//                imageByte.getImageFromDB(movie,imageByte);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
        List<Movie> list2 = movieMapper.selectByExample(null);
        return list2;
    }

    public List<Movie> getMovieByName(String movieName) {
        return movieMapper.selectByMovieName(movieName);
    }


    public int saveMovie(Movie movie) {
        List<Movie> list = movieMapper.selectByExample(null);

        int flag = 0;
        for (Movie movie1 : list){
            if (movie1.getMovieName().equals(movie.getMovieName())){
                flag = 1;
                break;
            }
        }

        if (flag == 1){
            return 1;
        }else {
            movieMapper.insertSelective(movie);
            return 0;
        }

    }

    /**
     * 电影删除
     * @param movie
     */
    public void updateMovie(Movie movie) {
        movieMapper.updateByPrimaryKeySelective(movie);
    }

    public void deleteMovie(Integer id) {
        movieMapper.deleteByPrimaryKey(id);
    }

    public void deleteBatch(List<Integer> ids) {
        MovieExample movieExample = new MovieExample();
        Criteria criteria = movieExample.createCriteria();
        //delete from xxx where emp_id in(1,2,3)
        criteria.andMovieIdIn(ids);
        movieMapper.deleteByExample(movieExample);
    }


}
