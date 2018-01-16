package com.hand.movie.controller;

import com.hand.movie.bean.Msg;
import com.hand.movie.bean.ProjctionHall;
import com.hand.movie.service.ProjectionHallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ProjectionHallController {

    @Autowired
    ProjectionHallService projectionHallService;

    /**
     * 返回所有的放映厅信息
     */
    @RequestMapping("/projectionHalls")
    @ResponseBody
    public Msg getAll(){
        //查出的所有部门信息
        List<ProjctionHall> list = projectionHallService.getAll();
        return Msg.success().add("projectionHalls", list);
    }

}
