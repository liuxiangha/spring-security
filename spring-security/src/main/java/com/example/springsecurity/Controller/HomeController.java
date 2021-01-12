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

    @Autowired
    private PasswordBeans passwordBeans;

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

//    /**
//     * 注册新的用户， 注册成功后跳转到登录界面
//     * @param userRole ： 待注册的用户信息对象
//     * @return ： 注册成功后的跳转路径
//     */
//    @PostMapping(path = "/registerPost")
//    public String registerPost(@ModelAttribute UserRole userRole) {
//        String password = userRole.getUserPassword();
//        String encodePassword = passwordBeans.passwordEncoder().encode(password);
//        userRole.setUserPassword(encodePassword);
//        userRole.setUserRole("USER_ROLE");
//        Long userId = roleRepository.count() + 1;
//        userRole.setUserId(userId);
//        userRole.setEnabled(true);
//
//        roleRepository.save(userRole);
//
//        return "redirect:/login";
//    }
//
//    @GetMapping(path = "/register")
//    public String register(Model model) {
//        model.addAttribute("userRole", new UserRole());
//        return "Register";
//    }
//
//    @RequestMapping(path = "/authenticate", method = {RequestMethod.POST})
//    public @ResponseBody
//    Boolean authenticate(@Param("username") String username,
//                                @Param("password") String password) {
//        UserRole role = roleRepository.findUserRoleByUsername(username);
//
//        /*
//            由于每次 BCryptPasswordEncoder 的加密结果都不一样， 因此使用 BCryptPasswordEncoder
//            的 matches 方法来判断输入的原始密码与存储的加密后的密码是否一致
//         */
//        return passwordBeans
//                .passwordEncoder()
//                .matches(password, role.getPassword());
//    }
}
