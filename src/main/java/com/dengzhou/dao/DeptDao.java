package com.dengzhou.dao;

import com.dengzhou.bean.Department;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DeptDao {
    Department getDeptById(Integer id);
}
