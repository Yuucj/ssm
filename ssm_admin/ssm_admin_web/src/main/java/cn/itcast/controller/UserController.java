package cn.itcast.controller;

import cn.itcast.domain.Role;
import cn.itcast.domain.UserInfo;
import cn.itcast.service.RoleService;
import cn.itcast.service.UserService;
import com.github.pagehelper.PageInfo;
import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

/**
 * @author yucongjun
 * @date 2018/11/30 21:12
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    //    @Secured("aaa")
    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(defaultValue = "") String condition, @RequestParam(required = false, defaultValue = "1") Integer page,
                                @RequestParam(required = false, defaultValue = "5") Integer rows) throws Exception {

        PageInfo<UserInfo> pageInfo = new PageInfo<>(userService.findAll(condition, page, rows));
        ModelAndView modelAndView = new ModelAndView("user-list", "pageInfo", pageInfo);
        modelAndView.addObject("condition", condition);
        return modelAndView;
    }

    @RequestMapping("/save")
    public String save(UserInfo user) throws Exception {

        userService.save(user);
        return "redirect:findAll";
    }

    @RequestMapping("/findById")
    public String findById(String id, String next,Model model) throws Exception {
        UserInfo user = userService.findById(id);
        model.addAttribute("user",user);
        return next;
    }

    @RequestMapping("/findByIdAndAllRole")
    public ModelAndView findByIdAndAllRole(String id) throws Exception {
        UserInfo user = userService.findById(id);
        List<Role> roles = roleService.findUsableByUid(id);
        for (Role role : user.getRoles()) {
            role.setFlag(1);
        }
        for (Role role : roles) {
            user.getRoles().add(role);
        }
        return new ModelAndView("user-role-add", "user", user);
    }

    @RequestMapping("/addRole")
    public String addRole(String userId, @RequestParam(defaultValue = "") String[] ids) throws Exception {
        userService.deleteRole(userId);
        if (ids != null && ids.length>0) {

            userService.addRole(userId, ids);
        }
        return "redirect:findAll";
    }

    @RequestMapping("/update")
    public String update(UserInfo user, Integer flag) throws Exception {
        userService.update(user, flag);
        User loginUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (loginUser.getUsername().equals(user.getUsername())) {

            return "redirect:/login.jsp";
        } else {
            return "redirect:findAll";
        }
    }

    @RequestMapping("/delete")
    public String delete(String[] ids) throws Exception {
        userService.delete(ids);
        return "redirect:findAll";
    }
}
