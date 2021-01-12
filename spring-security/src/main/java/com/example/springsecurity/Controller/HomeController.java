package com.example.springsecurity.Controller;

import com.example.springsecurity.Configuration.PasswordBeans;
import com.example.springsecurity.Entity.UserRole;
import com.example.springsecurity.Repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

/**
 * Created by IntelliJ IDEA.
 * User: liuxianghai
 * Date: 2021/1/11
 * Time: 下午2:41
 */

@Controller
@RequestMapping(path = "/")
public class HomeController {
    @Autowired
    private UserRoleRepository roleRepository;

    /*
        验证用户的登录状态
     */
    @GetMapping(path = "/checkUser")
    public @ResponseBody
    String checkUser(Authentication authentication) {
        UserRole userRole = (UserRole) authentication.getPrincipal();

        System.out.println("userRole:" + userRole.toString());

        return userRole.getUserRole();
    }
}
