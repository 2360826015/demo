package com.liuwohe.controller;

import com.liuwohe.entity.EmployeeEntity;
import com.liuwohe.entity.OrganizationEntity;
import com.liuwohe.entity.SelectEntity;
import com.liuwohe.service.EmpService;
import com.liuwohe.service.OrgService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class DemoController {

    @Autowired
    private OrgService orgService;
    @Autowired
    private EmpService empService;
    @Autowired
    RabbitTemplate rabbitTemplate;

    //进入主页面
    @RequestMapping("/index")
    public String testFind(Model model){
        //得到员工列表
        List<EmployeeEntity> empList=empService.getList();
        model.addAttribute("empList",empList);
        return "emp/list";
    }

    //页面加载时返回部门列表
    @PostMapping("/index")
    @ResponseBody
    public List<OrganizationEntity> getTee(){
        SelectEntity selectEntity = new SelectEntity();
        //设置初始parentId
        selectEntity.setOrgName(0);
        List<OrganizationEntity> orgTree = orgService.getOrgTree(selectEntity);
        return orgTree;
    }

    //条件查询
    @GetMapping("/select")
    @ResponseBody
    public List<EmployeeEntity> selectByChoose(SelectEntity select){
        System.out.println("前端传入条件："+select);
        List<EmployeeEntity> empList = empService.findById(select);
        return empList;
    }

    //表格导出
    @ResponseBody
    @RequestMapping("/download")
    public void downLoadExcel(HttpServletResponse response) throws IOException {
            empService.downloadExcel(response);
    }

}
