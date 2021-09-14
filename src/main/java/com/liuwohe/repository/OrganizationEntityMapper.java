package com.liuwohe.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liuwohe.entity.OrganizationEntity;

import java.util.List;

public interface OrganizationEntityMapper extends BaseMapper<OrganizationEntity> {
    List<OrganizationEntity> findAll();

    List<OrganizationEntity> getNodes(Integer id);
}