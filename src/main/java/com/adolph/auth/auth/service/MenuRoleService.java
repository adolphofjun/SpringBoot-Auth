package com.adolph.auth.auth.service;

import com.adolph.auth.auth.dao.MenuRoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by sang on 2018/1/2.
 */
@Service
@Transactional
public class MenuRoleService {
    @Autowired
    MenuRoleDao menuRoleDao;

    public int updateMenuRole(Long rid, Long[] mids) {
        menuRoleDao.deleteMenuByRid(rid);
        if (mids.length == 0) {
            return 0;
        }
        return menuRoleDao.addMenu(rid, mids);
    }
}
