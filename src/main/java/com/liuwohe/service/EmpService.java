package com.liuwohe.service;

import com.liuwohe.entity.EmployeeEntity;
import com.liuwohe.entity.SelectEntity;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface EmpService {

    List<EmployeeEntity> getList();

    List<EmployeeEntity> findById(SelectEntity select);
}
