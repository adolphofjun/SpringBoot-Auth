package com.adolph.auth.auth.service;

import com.adolph.auth.auth.dao.AdminDao;
import com.adolph.auth.bean.Admin;
import com.adolph.auth.common.AdminUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AdminService implements UserDetailsService {

    @Autowired
    AdminDao adminDao;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Admin admin = adminDao.loadUserByUsername(s);
        if (admin == null) {
            throw new UsernameNotFoundException("用户名不对");
        }
        return admin;
    }

    /**
     * 注册
     * @param username
     * @param password
     * @return
     */
    public int adminReg(String username, String password) {
        //如果用户名存在，返回错误
        if (adminDao.loadUserByUsername(username) != null) {
            return -1;
        }
        //加密处理
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encode = encoder.encode(password);
        System.out.println(username+"============="+password);
        //4db05305-41b2-4e30-847b-f48e8bc5f06f
        return adminDao.hrReg(username, password);
    }

    public List<Admin> getAdminsByKeywords(String keywords) {
        return adminDao.getHrsByKeywords(keywords);
    }

    public int updateAdmin(Admin admin) {
        return adminDao.updateHr(admin);
    }

    public int updateAdminRoles(Long adminId, Long[] rids) {
        int i = adminDao.deleteRoleByHrId(adminId);
        return adminDao.addRolesForHr(adminId, rids);
    }

    public Admin getAdminById(Long adminId) {
        return adminDao.getHrById(adminId);
    }

    public int deleteAdmin(Long adminId) {
        return adminDao.deleteHr(adminId);
    }

    public List<Admin> getAllAdminExceptAdmin() {
        return adminDao.getAllHr(AdminUtil.getCurrentAdmin().getId());
    }
    public List<Admin> getAllAdmin() {
        return adminDao.getAllHr(null);
    }
}