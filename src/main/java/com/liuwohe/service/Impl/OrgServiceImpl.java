package com.liuwohe.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.liuwohe.entity.OrganizationEntity;
import com.liuwohe.entity.SelectEntity;
import com.liuwohe.repository.OrganizationEntityMapper;
import com.liuwohe.service.OrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@Service
@SuppressWarnings("all")
public class OrgServiceImpl implements OrgService {

    @Autowired
    private OrganizationEntityMapper orgMapper;

    //传入根节点id得到树的子节点
    @Override
    public List<OrganizationEntity> getOrgNodes(Integer id) {
        List<OrganizationEntity> nodes = orgMapper.getNodes(id);
        return nodes;
    }

    //根据查询得到树型数据
    @Override
    @Cacheable(cacheNames = "orgTree")
    public List<OrganizationEntity> getOrgTree(SelectEntity selectEntity) {
        QueryWrapper<OrganizationEntity> qw = new QueryWrapper<>();
        qw.eq("parent_id", selectEntity.getOrgName())
                .or()
                .isNull("parent_id");
        // 得到一级节点资源列表
        List<OrganizationEntity> orgEntity = orgMapper.selectList(qw);
        if (orgEntity != null && orgEntity.size() > 0) {
            orgEntity.forEach(o->{
             findAllChild(o);
            });
        }
        return orgEntity;
    }

    public void findAllChild(OrganizationEntity orgEntity) {
        QueryWrapper<OrganizationEntity> qw = new  QueryWrapper<>();
        qw.eq("parent_id", orgEntity.getId());
        // 首次进入这个方法时，查出的是二级节点列表
        // 递归调用时，就能依次查出三、四、五等等级别的节点列表，
        // 递归能实现不同节点级别的无限调用,这个层次不易太深，否则有性能问题
        List<OrganizationEntity> orgEntitys = orgMapper.selectList(qw);
        orgEntity.setNodes(orgEntitys);
        if (orgEntitys != null && orgEntitys.size() > 0) {
            orgEntitys.forEach(o-> {
                findAllChild(o);
            });
        }
    }
}
