package cn.itcast.service;

import cn.itcast.domain.Role;

import java.util.List;

/**
 * @author yucongjun
 * @date 2018/12/2 9:42
 */
public interface RoleService {

    List<Role> findAll(String condition, int page, int rows) throws Exception;


    List<Role> findUsableByUid(String Uid) throws Exception;

    void save(Role role) throws Exception;

    Role findById(String id) throws Exception;

    void addPermission(String roleId, String[] ids) throws Exception;

    void deletePermission(String roleId)throws Exception;
    void update(Role role) throws Exception;

    void delete(String[] ids)throws Exception;
}
