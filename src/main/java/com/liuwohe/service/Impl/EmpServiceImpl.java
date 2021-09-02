package com.liuwohe.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.liuwohe.entity.EmployeeEntity;
import com.liuwohe.entity.OrganizationEntity;
import com.liuwohe.entity.SelectEntity;
import com.liuwohe.repository.EmployeeEntityMapper;
import com.liuwohe.service.EmpService;
import com.liuwohe.service.OrgService;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@SuppressWarnings("all")
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmployeeEntityMapper empMapper;
    @Autowired
    private OrgService orgService;


    //查询得到员工列表
    @Override
    public List<EmployeeEntity> getList() {
        List<EmployeeEntity> empList = empMapper.findAll();
        return empList;
    }

    @Override
    public List<EmployeeEntity> findById(SelectEntity select) {
        //根据前端传入的根节点id查询其子节点并放入List集合中
        List<Object> idList = new ArrayList<>();
        List<OrganizationEntity> nodes = orgService.getOrgNodes(select.getOrgName());
        nodes.forEach(n->{
            idList.add(n.getId());
            if(n.getNodes()!=null && n.getNodes().size()>0){
                n.getNodes().forEach(no->{
                    idList.add(no.getId());
                });
            }
        });
        //去除id集合中的重复值
        Set<Object> linkedHashSet = new LinkedHashSet<>(idList);
        List<Object> list = new ArrayList<>();
        linkedHashSet.forEach(e->{ list.add(e);});
        //将得到的节点集合赋值给实体类属性
        select.setNodesList(list);
        //执行emp列表的查询,传入节点集合
        List<EmployeeEntity> empList = empMapper.getChooseed(select);
        /**
         * 批量查询
         * QueryWrapper<EmployeeEntity> qw = new QueryWrapper<>();
         * qw.in("org_id",list);
         * List<EmployeeEntity> entityList = empMapper.selectList(qw);
         * System.out.println(entityList);
         */
        return empList;
    }
}
