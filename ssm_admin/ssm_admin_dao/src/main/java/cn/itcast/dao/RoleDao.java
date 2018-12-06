package cn.itcast.dao;

import cn.itcast.domain.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author yucongjun
 * @date 2018/11/30 21:09
 */
public interface RoleDao {

    List<Role> findAll(String condition) throws Exception;

    List<Role> findUsableByUid(String uid) throws Exception;

    @Insert("insert into role (roleName,roleDesc) values(#{roleName},#{roleDesc})")
    void save(Role role) throws Exception;

    Role findById(String id) throws Exception;

    @Update("update role set roleName=#{roleName},roleDesc=#{roleDesc} where id=#{id}")
    void update(Role role) throws Exception;
    @Delete("delete from role where id=#{id}")
    void delete(String id)throws Exception;
}
