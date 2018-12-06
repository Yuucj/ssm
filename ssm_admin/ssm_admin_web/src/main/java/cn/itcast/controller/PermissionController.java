package cn.itcast.controller;

import cn.itcast.domain.Permission;
import cn.itcast.domain.Role;
import cn.itcast.service.PermissionService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

/**
 * @author yucongjun
 * @date 2018/12/2 20:52
 */
@Controller
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    private PermissionService permissionService;

    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(defaultValue = "")String condition, @RequestParam(required = false, defaultValue = "1") Integer page,
                                 @RequestParam(required = false, defaultValue = "5") Integer rows) throws Exception {
        List<Permission> permissions = permissionService.findAll(condition, page, rows);
        PageInfo<Permission> pageInfo = new PageInfo<>(permissions);
        ModelAndView modelAndView = new ModelAndView("permission-list", "pageInfo", pageInfo);
        modelAndView.addObject("condition", condition);
        return modelAndView;
    }

    @RequestMapping("/findById")
    public String findById(String id, String next,Model model) throws Exception {
        Permission permission = permissionService.findById(id);
        model.addAttribute("permission",permission);
        return  next;

    }

    @RequestMapping("/save")
    public String save(Permission permission) throws Exception {

        permissionService.save(permission);
        return "redirect:findAll";
    }

    @RequestMapping("/update")
    public String update(Permission permission) throws Exception {

        permissionService.update(permission);
        return "redirect:findAll";
    }
    @RequestMapping("/delete")
    public String delete(String[] ids) throws Exception{
        System.out.println(Arrays.toString(ids));
        permissionService.delete(ids);
        return "redirect:findAll";
    }

}
