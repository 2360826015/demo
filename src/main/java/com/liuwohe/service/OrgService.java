package com.liuwohe.service;

import com.liuwohe.entity.OrganizationEntity;
import com.liuwohe.entity.SelectEntity;

import java.util.List;

public interface OrgService{
    List<OrganizationEntity> getOrgNodes(Integer id);
    List<OrganizationEntity> getOrgTree(SelectEntity selectEntity);
}
