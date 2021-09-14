package com.liuwohe.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liuwohe.entity.EmployeeEntity;
import com.liuwohe.entity.SelectEntity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface EmployeeEntityMapper extends BaseMapper<EmployeeEntity> {
    //    @Select("<script>"+
//            "select emp.id, emp.e_name,emp.sex,emp.birthday,emp.age,emp.salary,emp.org_id,org.org_name ,org.parent_id from employee emp join organization org"+
//            "<where>"+
//            "emp.org_id=org.id"+
//            "<if test='select.orgName !=null and select.orgName !=&quot;&quot;'>"+
//            "and emp.org_id in #{select.nodesList}"+
//            "</if>"+
//            "<if test='select.sex !=null and select.sex !=&quot;&quot;'>"+
//            "and emp.sex=#{select.sex}"+
//            "</if>"+
//            "<if test='select.birthday !=null'>"+
//            "and emp.birthday=#{select.birthday}"+
//            "</if>"+
//            "</where>"+
//            "</script>")
//    List<EmployeeEntity> dtSql(@Param("select") SelectEntity select);
    List<EmployeeEntity> findAll();

    List<EmployeeEntity> getChooseed(SelectEntity select);
}