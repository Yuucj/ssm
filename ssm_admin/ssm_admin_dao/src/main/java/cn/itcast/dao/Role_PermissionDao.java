package cn.itcast.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

/**
 * @author yucongjun
 * @date 2018/12/2 20:36
 */
public interface Role_PermissionDao {
    @Insert("insert into role_permission values (#{pid},#{rid})")
    public void save(@Param("rid") String rid, @Param("pid") String pid) throws Exception;
    @Delete("delete from role_permission where roleId = #{rid}")
    void deteleByRoleId(String roleId) throws Exception;
}
