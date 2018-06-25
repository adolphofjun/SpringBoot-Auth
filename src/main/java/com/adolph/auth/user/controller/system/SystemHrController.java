package com.adolph.auth.user.controller.system;


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
@RequestMapping("/system/hr")
public class SystemHrController {
    @Autowired
    AdminService hrService;

    @RequestMapping("/id/{hrId}")
    public Admin getHrById(@PathVariable Long hrId) {
        return hrService.getAdminById(hrId);
    }

    @RequestMapping(value = "/{hrId}", method = RequestMethod.DELETE)
    public RespBean deleteHr(@PathVariable Long hrId) {
        if (hrService.deleteAdmin(hrId) == 1) {
            return new RespBean("success", "删除成功!");
        }
        return new RespBean("error", "删除失败!");
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public RespBean updateHr(Admin hr) {
        if (hrService.updateAdmin(hr) == 1) {
            return new RespBean("success", "更新成功!");
        }
        return new RespBean("error", "更新失败!");
    }

    @RequestMapping(value = "/roles", method = RequestMethod.PUT)
    public RespBean updateHrRoles(Long hrId, Long[] rids) {
        if (hrService.updateAdminRoles(hrId, rids) == rids.length) {
            return new RespBean("success", "更新成功!");
        }
        return new RespBean("error", "更新失败!");
    }

    @RequestMapping("/{keywords}")
    public List<Admin> getHrsByKeywords(@PathVariable(required = false) String keywords) {
        List<Admin> hrs = hrService.getAdminsByKeywords(keywords);
        return hrs;
    }


    @RequestMapping(value = "/hr/reg", method = RequestMethod.POST)
    public RespBean hrReg(String username, String password) {
        int i = hrService.adminReg(username, password);
        if (i == 1) {
            return new RespBean("success", "注册成功!");
        } else if (i == -1) {
            return new RespBean("error", "用户名重复，注册失败!");
        }
        return new RespBean("error", "注册失败!");
    }

}
