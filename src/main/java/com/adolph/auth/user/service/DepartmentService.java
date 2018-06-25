package com.adolph.auth.user.service;


import com.adolph.auth.bean.Department;
import com.adolph.auth.user.dao.DepartmentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class DepartmentService {
    @Autowired
    DepartmentDao departmentDao;
    public int addDep(Department department) {
        department.setEnabled(true);
        departmentDao.addDep(department);
        return department.getResult();
    }

    public int deleteDep(Long did) {
        Department department = new Department();
        department.setId(did);
        departmentDao.deleteDep(department);
        return department.getResult();
    }

    public List<Department> getDepByPid(Long pid) {
        return departmentDao.getDepByPid(pid);
    }

    public List<Department> getAllDeps() {
        return departmentDao.getAllDeps();
    }
}
