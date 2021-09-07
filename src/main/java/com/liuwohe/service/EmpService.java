package com.liuwohe.service;

import com.liuwohe.entity.EmployeeEntity;
import com.liuwohe.entity.SelectEntity;
import org.apache.ibatis.annotations.Select;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public interface EmpService {

    List<EmployeeEntity> getList();

    List<EmployeeEntity> findById(SelectEntity select);

    void downloadExcel(HttpServletResponse response) throws IOException;
}
