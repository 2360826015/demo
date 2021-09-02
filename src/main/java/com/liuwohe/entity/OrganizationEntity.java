package com.liuwohe.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@ToString
@Getter
@Setter
@TableName(value = "organization")
public class OrganizationEntity extends Model<OrganizationEntity> implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;

    @TableField(value = "org_name")
    private String text;

    private Integer parentId;

//    @TableField(exist = false)
//    private List<EmployeeEntity> empList=new ArrayList<>();

    @TableField(exist = false)
    private List<OrganizationEntity> nodes=new ArrayList<>();
}