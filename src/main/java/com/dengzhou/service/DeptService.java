package com.dengzhou.service;

import com.dengzhou.bean.Department;
import com.dengzhou.dao.DeptDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.Cache;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.stereotype.Service;

@Service
public class DeptService {
    @Autowired
    DeptDao deptDao;
    @Qualifier("deptManager")
    @Autowired
    RedisCacheManager deptCacheManager;
 /*   @Cacheable(cacheNames = "dept",cacheManager = "deptManager")
    public Department findById(Integer id){
        Department dept = deptDao.getDeptById(id);
        return dept;

    }*/

    public Department findById(Integer id){
        System.out.println("查询部门id:"+id);
        Department department = deptDao.getDeptById(id);
        // 获取某个缓存
        Cache dept = deptCacheManager.getCache("dept");
        //将数据放入缓存
        dept.put("dept:1",department);
        return department;
    }
}
