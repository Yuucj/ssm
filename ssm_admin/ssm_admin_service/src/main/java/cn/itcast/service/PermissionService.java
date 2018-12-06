package cn.itcast.service;

import cn.itcast.domain.Permission;

import java.util.List;

/**
 * @author yucongjun
 * @date 2018/12/2 20:16
 */
public interface PermissionService {
    List<Permission> findUsableByUid(String id) throws Exception;

    List<Permission> findAll(String condition, int page, int rows) throws Exception;

    Permission findById(String id) throws Exception;

    void update(Permission permission) throws Exception;

    void save(Permission permission) throws Exception;

    void delete(String[] ids)throws Exception;
}
