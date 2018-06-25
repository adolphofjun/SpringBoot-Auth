package com.adolph.auth.common;

import com.adolph.auth.bean.Admin;
import org.springframework.security.core.context.SecurityContextHolder;

public class AdminUtil {
    public static Admin getCurrentAdmin() {
        return (Admin) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
