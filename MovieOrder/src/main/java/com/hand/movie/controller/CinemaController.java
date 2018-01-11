package com.hand.movie.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hand.movie.bean.Cinema;
import com.hand.movie.bean.Msg;
import com.hand.movie.dao.CinemaProjectionHallMapper;
import com.hand.movie.service.CPHService;
import com.hand.movie.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CinemaController {

    @Autowired
    private CinemaService cinemaService;
    @Autowired
    private CPHService cphService;

    /*
	 * 根据id查询电影院所有信息
	 */
    @RequestMapping(value="/cinema/{id}",method= RequestMethod.GET)
    @ResponseBody
    public Msg getCinemaById(@PathVariable("id") Integer id){

        Cinema cinema = cinemaService.getCinema(id);
//        System.out.println(cinema.getProjctionHall());
        return Msg.success().add("cinema", cinema);
    }

    /*
	 * 通过CinemaName模糊查询电影院以及放映厅和座位的所有信息
	 * @param pn
	 * @return
	 */
    @RequestMapping(value="/cinemas/{cinemaName}",method= RequestMethod.GET)
    @ResponseBody
    public Msg getAllByCinemaName(
            @RequestParam(value = "pn", defaultValue = "1") Integer pn,
            @PathVariable("cinemaName") String cinemaName){
        // 引入PageHelper分页插件
        // 在查询之前只需要调用，传入页码，以及每页的大小
        PageHelper.startPage(pn, 5);

        List<Cinema> list = cinemaService.getCinemaByName(cinemaName);
        System.out.println("list.size():"+list.size());

        PageInfo page = new PageInfo(list, 5);

        return Msg.success().add("pageInfo", page);
    }


    /*
	 * 查询电影院以及放映厅和座位的所有信息
	 * @param pn
	 * @return
	 */
    @RequestMapping(value="/cinemas",method= RequestMethod.GET)
    @ResponseBody
    public Msg getAll(
            @RequestParam(value = "pn", defaultValue = "1") Integer pn){
        // 引入PageHelper分页插件
        // 在查询之前只需要调用，传入页码，以及每页的大小
        PageHelper.startPage(pn, 5);

        List<Cinema> list = cinemaService.getAll();
        System.out.println("list.size():"+list.size());

        PageInfo page = new PageInfo(list, 5);

        return Msg.success().add("pageInfo", page);
    }


    /**
     * 电影院保存
     *
     *
     * @return
     */
    @RequestMapping(value="/cinema",method=RequestMethod.POST)
    @ResponseBody
    public Msg saveCinema(@Valid Cinema cinema, BindingResult result){
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
            int flag = cinemaService.saveCinema(cinema);
            if (flag == 2){
                String error = "数据库中已有此数据，请勿重复插入!";
                return Msg.fail().add("error",error);
            }else{
                return Msg.success();
            }

        }

    }

    /**
     * 如果直接发送ajax=PUT形式的请求
     * 封装的数据
     * Employee
     * [empId=1014, empName=null, gender=null, email=null, dId=null]
     *
     * 问题：
     * 请求体中有数据；
     * 但是Employee对象封装不上；
     * update tbl_emp  where emp_id = 1014;
     *
     * 原因：
     * Tomcat：
     * 		1、将请求体中的数据，封装一个map。
     * 		2、request.getParameter("empName")就会从这个map中取值。
     * 		3、SpringMVC封装POJO对象的时候。
     * 				会把POJO中每个属性的值，request.getParamter("email");
     * AJAX发送PUT请求引发的血案：
     * 		PUT请求，请求体中的数据，request.getParameter("empName")拿不到
     * 		Tomcat一看是PUT不会封装请求体中的数据为map，只有POST形式的请求才封装请求体为map
     * org.apache.catalina.connector.Request--parseParameters() (3111);
     *
     * protected String parseBodyMethods = "POST";
     * if( !getConnector().isParseBodyMethod(getMethod()) ) {
     success = true;
     return;
     }
     *
     *
     * 解决方案；
     * 我们要能支持直接发送PUT之类的请求还要封装请求体中的数据
     * 1、配置上HttpPutFormContentFilter；
     * 2、他的作用；将请求体中的数据解析包装成一个map。
     * 3、request被重新包装，request.getParameter()被重写，就会从自己封装的map中取数据
     * 电影院更新方法
     * @param cinema
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/cinema/{cinemaId}",method=RequestMethod.PUT)
    public Msg saveCinema(Cinema cinema,HttpServletRequest request){
        System.out.println("将要更新的cinema数据："+cinema);
        cinemaService.updateCinema(cinema);
        System.out.println("数据");
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
    @RequestMapping(value="/cinema/{ids}",method=RequestMethod.DELETE)
    public Msg deleteEmp(@PathVariable("ids")String ids){
        //批量删除
        if(ids.contains("-")){
            List<Integer> del_ids = new ArrayList<Integer>();
            String[] str_ids = ids.split("-");
            //组装id的集合
            for (String string : str_ids) {
                del_ids.add(Integer.parseInt(string));
            }
            cphService.deleteBatch(del_ids);
        }else{
            Integer id = Integer.parseInt(ids);
            cphService.deleteCPH(id);
        }
        return Msg.success();
    }
}
