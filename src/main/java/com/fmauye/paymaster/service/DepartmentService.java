/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fmauye.paymaster.service;

import com.fmauye.paymaster.entity.Department;
import java.util.List;

/**
 *
 * @author "Tafadzwa"
 */
public interface DepartmentService {
    public List<Department> getAllDepartments();
    public String createDepartment(Department department);
}
