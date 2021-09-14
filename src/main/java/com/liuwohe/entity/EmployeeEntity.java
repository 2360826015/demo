package com.liuwohe.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@ToString
@Getter
@Setter
@TableName(value = "employee")
public class EmployeeEntity extends Model<EmployeeEntity> implements Serializable {
    @TableId(type = IdType.AUTO)
    @Excel(name = "员工编号")
    private Integer id;

    @Excel(name = "所属组织编号", orderNum = "1")
    private String orgId;

    @Excel(name = "性别", orderNum = "3", replace = {"男_1", "女_2"})
    private String sex;

    @Excel(name = "出生日期", exportFormat = "yyyy-MM-dd", format = "yyyy-MM-dd", databaseFormat = "yyyyMMdd", orderNum = "4")
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date birthday;

    @Excel(name = "员工姓名", orderNum = "2")
    @TableField(value = "e_name")
    private String name;

    @Excel(name = "年龄", orderNum = "5")
    private Integer age;

    @Excel(name = "薪资", orderNum = "6")
    private Double salary;

    @TableField(exist = false)
    private OrganizationEntity organization;
}