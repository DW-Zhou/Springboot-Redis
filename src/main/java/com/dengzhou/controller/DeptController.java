package com.dengzhou.controller;

import com.dengzhou.bean.Department;
import com.dengzhou.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeptController {
    @Autowired
    DeptService deptService;
    @GetMapping("/test/{id}")
    public Department test(@PathVariable("id") Integer id){
        Department byId = deptService.findById(id);
        return byId;
    }
}
