package com.adolph.auth.auth.dao;

import com.adolph.auth.bean.Admin;
import com.adolph.auth.bean.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminDao {
    Admin loadUserByUsername(String username);

    List<Role> getRolesByHrId(Long id);

    int hrReg(@Param("username") String username, @Param("password") String password);

    List<Admin> getHrsByKeywords(@Param("keywords") String keywords);

    int updateHr(Admin hr);

    int deleteRoleByHrId(Long hrId);

    int addRolesForHr(@Param("hrId") Long hrId, @Param("rids") Long[] rids);

    Admin getHrById(Long hrId);

    int deleteHr(Long hrId);

    List<Admin> getAllHr(@Param("currentId") Long currentId);
}
