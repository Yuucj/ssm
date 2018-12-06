package cn.itcast.controller;

import cn.itcast.domain.Permission;
import cn.itcast.domain.Role;
import cn.itcast.service.PermissionService;
import cn.itcast.service.RoleService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

/**
 * @author yucongjun
 * @date 2018/12/2 9:41
 */
@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;
//    @RolesAllowed("VIP")
    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(defaultValue = "")String condition, @RequestParam(required = false, defaultValue = "1") Integer page,
                                 @RequestParam(required = false, defaultValue = "5") Integer rows) throws Exception {
        List<Role> roles = roleService.findAll(condition, page, rows);
        PageInfo<Role> pageInfo = new PageInfo<>(roles);
        ModelAndView modelAndView = new ModelAndView("role-list", "pageInfo", pageInfo);
        modelAndView.addObject("condition", condition);
        return modelAndView;
    }

    @RequestMapping("/save")
    public String save(Role role) throws Exception {
        roleService.save(role);
        return "redirect:findAll";
    }

    @RequestMapping("/findById")
    public String findById(String id,String next,Model model) throws Exception {
        Role role = roleService.findById(id);
        model.addAttribute("role",role);
        return next;
    }

    @RequestMapping("/findByIdAndAllPermission")
    public ModelAndView findByIdAndAllPermission(String id) throws Exception {
        Role role = roleService.findById(id);
        List<Permission> permissions = permissionService.findUsableByUid(id);
        for (Permission permission : role.getPermissions()) {
            permission.setFlag(1);
        }
        for (Permission permission : permissions) {
            role.getPermissions().add(permission);
        }
        return new ModelAndView("role-permission-add","role",role);
    }

    @RequestMapping("/addPermission")
    public String addPermission(String roleId, @RequestParam(defaultValue = "")String[] ids) throws Exception {
        roleService.deletePermission(roleId);
        if(ids != null && ids.length >0){

            roleService.addPermission(roleId, ids);
        }
        return "redirect:findAll";
    }

    @RequestMapping("/update")
    public String update(Role role)throws Exception{
        roleService.update(role);
        return "redirect:findAll";
    }
    @RequestMapping("/delete")
    public String delete(String[] ids) throws Exception{
        roleService.delete(ids);
        return "redirect:findAll";
    }
}
