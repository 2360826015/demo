package com.liuwohe.entity;

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
    private Integer id;

    private String orgId;

    private String sex;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date birthday;

    @TableField(value = "e_name")
    private String name;

    private Integer age;

    private Double salary;

    @TableField(exist = false)
    private OrganizationEntity organization;
  }