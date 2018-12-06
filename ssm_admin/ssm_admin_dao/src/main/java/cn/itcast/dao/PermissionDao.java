package cn.itcast.dao;

import cn.itcast.domain.Permission;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yucongjun
 * @date 2018/11/30 21:10
 */
public interface PermissionDao {
    List<Permission> findByRoleId(String id) throws Exception;

    List<Permission> findUsableByRoleId(String id) throws Exception;

    List<Permission> findAll(String condition) throws Exception;

    @Select("select * from permission where id = #{id}")
    Permission findById(String id) throws Exception;

    @Update("update permission set permissionName=#{permissionName},url=#{url} where id=#{id}")
    void update(Permission permission);

    @Insert("insert into permission (permissionName,url) values (#{permissionName},#{url})")
    void save(Permission permission);
    @Delete("delete from permission where id=#{id}")
    void delete(String id)throws Exception;
}
