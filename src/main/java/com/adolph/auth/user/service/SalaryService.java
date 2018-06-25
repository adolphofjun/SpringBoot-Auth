package com.adolph.auth.user.service;


import com.adolph.auth.bean.Salary;
import com.adolph.auth.user.dao.SalaryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class SalaryService {
    @Autowired
    SalaryDao salaryDao;
    public int addSalary(Salary salary) {
        return salaryDao.addSalary(salary);
    }

    public List<Salary> getAllSalary() {
        return salaryDao.getAllSalary();
    }

    public int updateSalary(Salary salary) {
        return salaryDao.updateSalary(salary);
    }

    public int deleteSalary(String ids) {
        String[] split = ids.split(",");
        return salaryDao.deleteSalary(split);
    }

    public int updateEmpSalary(Integer sid, Long eid) {
        salaryDao.deleteSalaryByEid(eid);
        return salaryDao.addSidAndEid(sid,eid);
    }
}
