package com.liuwohe.service.Impl;

import com.liuwohe.entity.EmployeeEntity;
import com.liuwohe.entity.OrganizationEntity;
import com.liuwohe.entity.SelectEntity;
import com.liuwohe.repository.EmployeeEntityMapper;
import com.liuwohe.service.EmpService;
import com.liuwohe.service.OrgService;
import com.liuwohe.utils.ExcelUtils;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@Service
@SuppressWarnings("all")
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmployeeEntityMapper empMapper;
    @Autowired
    private OrgService orgService;

    @RabbitListener(queues = "liuwohe.test")
    public void test() {
        System.out.println("消息队列监听ing");
    }

    //查询得到员工列表
    @Override
    @Cacheable(cacheNames = "empList")
    public List<EmployeeEntity> getList() {
        List<EmployeeEntity> empList = empMapper.findAll();
        return empList;
    }

    @Override
    public List<EmployeeEntity> findById(SelectEntity select) {
        //根据前端传入的根节点id查询其子节点并放入List集合中
        List<Object> idList = new ArrayList<>();
        List<OrganizationEntity> nodes = orgService.getOrgNodes(select.getOrgName());
        nodes.forEach(n -> {
            idList.add(n.getId());
            if (n.getNodes() != null && n.getNodes().size() > 0) {
                n.getNodes().forEach(no -> {
                    idList.add(no.getId());
                });
            }
        });
        //去除id集合中的重复值
        Set<Object> linkedHashSet = new LinkedHashSet<>(idList);
        List<Object> list = new ArrayList<>();
        linkedHashSet.forEach(e -> {
            list.add(e);
        });
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

    @Override
    public void downloadExcel(HttpServletResponse response) throws IOException {
        List<EmployeeEntity> empList = empMapper.findAll();
        ExcelUtils.exportExcel(empList, "员工信息统计", "员工信息", EmployeeEntity.class, "员工信息统计表", response);
    }
}
