package cn.itcast.service.impl;

import cn.itcast.dao.PermissionDao;
import cn.itcast.domain.Permission;
import cn.itcast.service.PermissionService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author yucongjun
 * @date 2018/12/2 20:16
 */
@Service
@Transactional
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionDao permissionDao;

    @Override
    public List<Permission> findUsableByUid(String id) throws Exception {
        return permissionDao.findUsableByRoleId(id);
    }

    @Override
    public List<Permission> findAll(String condition, int page, int rows) throws Exception {
        PageHelper.startPage(page, rows);
        return permissionDao.findAll(condition);
    }

    @Override
    public Permission findById(String id) throws Exception {
        return permissionDao.findById(id);
    }

    @Override
    public void update(Permission permission) throws Exception {
        permissionDao.update(permission);
    }

    @Override
    public void save(Permission permission) throws Exception {
        permissionDao.save(permission);
    }

    @Override
    public void delete(String[] ids) throws Exception {
        if(ids != null){
            for (String id : ids) {
                permissionDao.delete(id);
            }
        }
    }
}
