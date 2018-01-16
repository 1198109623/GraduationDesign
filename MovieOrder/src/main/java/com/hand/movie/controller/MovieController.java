package com.hand.movie.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hand.movie.bean.Cinema;
import com.hand.movie.bean.Movie;
import com.hand.movie.bean.Msg;
import com.hand.movie.service.MovieService;
import com.hand.movie.utils.ImageByte;
import jdk.nashorn.internal.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import com.amazonaws.util.json.JSONException;
import com.amazonaws.util.json.JSONObject;
import com.hand.movie.utils.FileUtil;  //文件工具类
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;


@CrossOrigin
@Controller
public class MovieController {

    private static String fileName;


    @Autowired
    private MovieService movieService;

    /*
	 * 根据id查询电影所有信息
	 */
    @RequestMapping(value="/movie/{id}",method= RequestMethod.GET)
    @ResponseBody
    public Msg getMovieById(@PathVariable("id") Integer id){
        Movie movie = movieService.getMovie(id);
        return Msg.success().add("movie", movie);
    }

    /*
    * 通过MovieName模糊查询电影信息
    * @param pn
    * @return
    */
    @RequestMapping(value="/movies/{moviesName}",method= RequestMethod.GET)
    @ResponseBody
    public Msg getAllByMovieName(
            @RequestParam(value = "pn", defaultValue = "1") Integer pn,
            @PathVariable("moviesName") String moviesName){
        // 引入PageHelper分页插件
        // 在查询之前只需要调用，传入页码，以及每页的大小
        PageHelper.startPage(pn, 5);

        List<Movie> list = movieService.getMovieByName(moviesName);
        System.out.println("list.size():"+list.size());

        PageInfo page = new PageInfo(list, 5);

        return Msg.success().add("pageInfo", page);
    }


    /*
     * 分页查询电影所有信息
     */
    @RequestMapping(value="/movies",method= RequestMethod.GET)
    @ResponseBody
    public Msg getAll(
            @RequestParam(value = "pn", defaultValue = "1") Integer pn){
        // 引入PageHelper分页插件
        // 在查询之前只需要调用，传入页码，以及每页的大小
        PageHelper.startPage(pn, 5);

        List<Movie> list = movieService.getAll();
        System.out.println("list.size():"+list.size());
        PageInfo page = new PageInfo(list, 5);
        return Msg.success().add("pageInfo", page);
    }

    /*
     * 查询电影所有信息
     */
    @RequestMapping(value="/allMovies",method= RequestMethod.GET)
    @ResponseBody
    public Msg getAllMovies(){
        List<Movie> list = movieService.getAll();
        return Msg.success().add("movies", list);
    }

    //处理文件上传
    @RequestMapping(value="/uploadImg", method = RequestMethod.POST)
    public @ResponseBody String uploadImg(@RequestParam("file") MultipartFile file,
                                          HttpServletRequest request) throws JSONException {


        String contentType = file.getContentType();   //图片文件类型
        String fileName = file.getOriginalFilename();  //图片名字
        MovieController.fileName = fileName;

        //文件存放路径
        String filePath = "D:\\学习笔记和源码\\毕设\\MovieOrder\\src\\main\\webapp\\static\\picture\\toDB\\";

        //调用文件处理类FileUtil，处理文件，将文件写入指定位置
        try {
            FileUtil.uploadFile(file.getBytes(), filePath, fileName);
            System.out.println("file.getBytes():"+file.getBytes());
        } catch (Exception e) {
            // TODO: handle exception
        }

        JSONObject obj = new JSONObject();
        obj.put("result", "success");
        obj.put("fileName", fileName);
        System.out.println(obj.toString());
        // 返回图片的fileName
        return obj.toString();
    }

    /**
     * form表单提交 Date类型数据绑定
     * <功能详细描述>
     * @param binder
     * @see [类、类#方法、类#成员]
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        // SimpleDateFormat dateFormat = new
        // SimpleDateFormat(getText("date.format", request.getLocale()));
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");//pattern中的时间格式一定要和前端页面传过来的时间参数格式一致！
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class,null, new CustomDateEditor(dateFormat, true));
    }


    /**
     * 电影保存
     *
     *
     * @return
     */
    @RequestMapping(value="/movie",method=RequestMethod.POST)
    @ResponseBody
    public Msg saveMovie(@Valid Movie movie, BindingResult result) throws IOException {


        if(result.hasErrors()){
            //校验失败，应该返回失败，在模态框中显示校验失败的错误信息
            Map<String, Object> map = new HashMap<String,Object>();
            List<FieldError> errors = result.getFieldErrors();
            for (FieldError fieldError : errors) {
                System.out.println("错误的字段名："+fieldError.getField());
                System.out.println("错误信息："+fieldError.getDefaultMessage());
                map.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            return Msg.fail().add("errorFields", map);
        }else{

            System.out.println("data:"+movie);
//            System.out.println("fileName:"+MovieController.fileName);
            ImageByte imageByte = new ImageByte();
            byte[] data = imageByte.setImageToByte(imageByte,MovieController.fileName);
            movie.setPicture(data);
            int flag = movieService.saveMovie(movie);
            MovieController.fileName = null;
            if (flag == 1){
                String error = "数据库中已有此数据，请勿重复插入!";
                return Msg.fail().add("error",error);
            }else {
                return Msg.success();
            }
        }
    }

    /**
     * 电影修改
     *
     * @param movie
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/movie/{movieId}",method=RequestMethod.PUT)
    public Msg saveMovie(Movie movie,HttpServletRequest request) throws IOException {
        System.out.println("将要更新的cinema数据："+movie);
        System.out.println("MovieController.fileName："+MovieController.fileName);
        if (MovieController.fileName !=null){
            ImageByte imageByte = new ImageByte();
            byte[] data = imageByte.setImageToByte(imageByte,MovieController.fileName);
            movie.setPicture(data);
        }
        movieService.updateMovie(movie);
        MovieController.fileName = null;
//        System.out.println("数据");
        return Msg.success();
    }

    /**
     * 单个批量二合一
     * 批量删除：1-2-3
     * 单个删除：1
     *
     * @param ids
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/movie/{ids}",method=RequestMethod.DELETE)
    public Msg deleteEmp(@PathVariable("ids")String ids){
        //批量删除
        if(ids.contains("-")){
            List<Integer> del_ids = new ArrayList<Integer>();
            String[] str_ids = ids.split("-");
            //组装id的集合
            for (String string : str_ids) {
                del_ids.add(Integer.parseInt(string));
            }
            movieService.deleteBatch(del_ids);
        }else{
            Integer id = Integer.parseInt(ids);
            movieService.deleteMovie(id);
        }
        return Msg.success();
    }


}
