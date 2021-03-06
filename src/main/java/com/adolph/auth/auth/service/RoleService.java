package com.adolph.auth.auth.service;

import com.adolph.auth.auth.dao.RoleDao;
import com.adolph.auth.bean.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sang on 2018/1/1.
 */
@Service
@Transactional
public class RoleService {
    @Autowired
    RoleDao roleDao;

    public List<Role> roles() {
        return roleDao.roles();
    }

    public int addNewRole(String role, String roleZh) {
        if (!role.startsWith("ROLE_")) {
            role = "ROLE_" + role;
        }
        return roleDao.addNewRole(role, roleZh);
    }

    public int deleteRoleById(Long rid) {
        return roleDao.deleteRoleById(rid);
    }
}