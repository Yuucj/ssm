package cn.itcast.service.impl;

import cn.itcast.dao.PermissionDao;
import cn.itcast.dao.RoleDao;
import cn.itcast.dao.Role_PermissionDao;
import cn.itcast.domain.Role;
import cn.itcast.service.RoleService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author yucongjun
 * @date 2018/12/2 9:42
 */
@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private Role_PermissionDao role_permissionDao;

    @Override
    public List<Role> findAll(String condition, int page, int rows) throws Exception {
        PageHelper.startPage(page, rows);
        return roleDao.findAll(condition);
    }

    @Override
    public List<Role> findUsableByUid(String Uid) throws Exception {
        return roleDao.findUsableByUid(Uid);
    }

    @Override
    public void save(Role role) throws Exception {
        roleDao.save(role);
    }

    @Override
    public Role findById(String id) throws Exception {
        return roleDao.findById(id);
    }

    @Override
    public void addPermission(String roleId, String[] ids) throws Exception {
        for (String id : ids) {
            role_permissionDao.save(roleId, id);
        }
    }

    @Override
    public void deletePermission(String roleId) throws Exception {
        role_permissionDao.deteleByRoleId(roleId);
    }

    @Override
    public void update(Role role) throws Exception {
        roleDao.update(role);
    }

    @Override
    public void delete(String[] ids) throws Exception {
        if(ids !=null){
            for (String id : ids) {
                roleDao.delete(id);
            }
        }
    }

}
