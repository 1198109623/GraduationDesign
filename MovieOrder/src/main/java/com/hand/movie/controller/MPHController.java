package com.hand.movie.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hand.movie.bean.Cinema;
import com.hand.movie.bean.Movie;
import com.hand.movie.bean.MovieProjHall;
import com.hand.movie.bean.Msg;
import com.hand.movie.service.MPHService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class MPHController {

    @Autowired
    MPHService mphService;

    /*
    * 通过pName模糊查询电影信息
    * @param pn
    * @return
    */
    @RequestMapping(value="/mphs/{pName}",method= RequestMethod.GET)
    @ResponseBody
    public Msg getAllBypName(
            @RequestParam(value = "pn", defaultValue = "1") Integer pn,
            @PathVariable("pName") String pName){
        // 引入PageHelper分页插件
        // 在查询之前只需要调用，传入页码，以及每页的大小
        PageHelper.startPage(pn, 5);

        List<MovieProjHall> list = mphService.getMPHBypName(pName);
        PageInfo page = new PageInfo(list, 5);

        return Msg.success().add("pageInfo", page);
    }

    /*
    * 根据id查询电影所有信息
    */
    @RequestMapping(value="/mph/{id}",method= RequestMethod.GET)
    @ResponseBody
    public Msg getMovieById(@PathVariable("id") Integer id){
        MovieProjHall mph = mphService.getMPById(id);
        return Msg.success().add("mph", mph);
    }

    /*
	 * 查询放映厅与电影的所有信息
	 * @param pn
	 * @return
	 */
    @RequestMapping(value="/mph",method= RequestMethod.GET)
    @ResponseBody
    public Msg getAll(
            @RequestParam(value = "pn", defaultValue = "1") Integer pn){
        // 引入PageHelper分页插件
        // 在查询之前只需要调用，传入页码，以及每页的大小
        PageHelper.startPage(pn, 5);

        List<MovieProjHall> list = mphService.getAll();
        System.out.println("list.size():"+list.size());

        PageInfo page = new PageInfo(list, 5);

        return Msg.success().add("pageInfo", page);
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
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");//pattern中的时间格式一定要和前端页面传过来的时间参数格式一致！
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class,null, new CustomDateEditor(dateFormat, true));
    }

    /**
     * 电影保存
     *
     *
     * @return
     */
    @RequestMapping(value="/mph",method=RequestMethod.POST)
    @ResponseBody
    public Msg saveMovie(@Valid MovieProjHall mph, BindingResult result){
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
            System.out.println("data:"+mph);
            int flag = mphService.saveMPH(mph);
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
     * @param mph
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/mph/{id}",method=RequestMethod.PUT)
    public Msg saveMPH(MovieProjHall mph,HttpServletRequest request){
        System.out.println("将要更新的cinema数据："+mph);
        mphService.updateMPH(mph);
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
    @RequestMapping(value="/mph/{ids}",method=RequestMethod.DELETE)
    public Msg deleteEmp(@PathVariable("ids")String ids){
        //批量删除
        if(ids.contains("-")){
            List<Integer> del_ids = new ArrayList<Integer>();
            String[] str_ids = ids.split("-");
            //组装id的集合
            for (String string : str_ids) {
                del_ids.add(Integer.parseInt(string));
            }
            mphService.deleteBatch(del_ids);
        }else{
            Integer id = Integer.parseInt(ids);
            mphService.deleteMPH(id);
        }
        return Msg.success();
    }

}
