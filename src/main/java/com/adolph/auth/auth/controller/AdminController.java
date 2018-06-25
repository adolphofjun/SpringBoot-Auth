package com.adolph.auth.auth.controller;


import com.adolph.auth.auth.service.AdminService;
import com.adolph.auth.bean.Admin;
import com.adolph.auth.bean.RespBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by sang on 2018/1/2.
 */
@RestController
@RequestMapping("/system/admin")
public class AdminController {
    @Autowired
    AdminService adminService;

    @RequestMapping("/id/{adminId}")
    public Admin getAdminById(@PathVariable Long adminId) {
        return adminService.getAdminById(adminId);
    }

    @RequestMapping(value = "/{adminId}", method = RequestMethod.DELETE)
    public RespBean deleteAdmin(@PathVariable Long adminId) {
        if (adminService.deleteAdmin(adminId) == 1) {
            return new RespBean("success", "删除成功!");
        }
        return new RespBean("error", "删除失败!");
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public RespBean updateAdmin(Admin admin) {
        if (adminService.updateAdmin(admin) == 1) {
            return new RespBean("success", "更新成功!");
        }
        return new RespBean("error", "更新失败!");
    }

    @RequestMapping(value = "/roles", method = RequestMethod.PUT)
    public RespBean updateAdminRoles(Long adminId, Long[] rids) {
        if (adminService.updateAdminRoles(adminId, rids) == rids.length) {
            return new RespBean("success", "更新成功!");
        }
        return new RespBean("error", "更新失败!");
    }

    @RequestMapping("/{keywords}")
    public List<Admin> getAdminsByKeywords(@PathVariable(required = false) String keywords) {
        List<Admin> admins = adminService.getAdminsByKeywords(keywords);
        return admins;
    }


    @RequestMapping(value = "/admin/reg", method = RequestMethod.POST)
    public RespBean adminReg(String username, String password) {
        int i = adminService.adminReg(username, password);
        if (i == 1) {
            return new RespBean("success", "注册成功!");
        } else if (i == -1) {
            return new RespBean("error", "用户名重复，注册失败!");
        }
        return new RespBean("error", "注册失败!");
    }

}
