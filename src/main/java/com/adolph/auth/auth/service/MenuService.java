package com.adolph.auth.auth.service;

import com.adolph.auth.auth.dao.MenuDao;
import com.adolph.auth.bean.Menu;
import com.adolph.auth.common.AdminUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MenuService {
    @Autowired
    MenuDao menuDao;

    public List<Menu> getAllMenu(){
        return menuDao.getAllMenu();
    }

    public List<Menu> getMenusByHrId() {
        return menuDao.getMenusByHrId(AdminUtil.getCurrentAdmin().getId());
    }

    public List<Menu> menuTree() {
        return menuDao.menuTree();
    }

    public List<Long> getMenusByRid(Long rid) {
        return menuDao.getMenusByRid(rid);
    }
}