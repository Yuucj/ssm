package cn.itcast.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

/**
 * @author yucongjun
 * @date 2018/12/2 19:11
 */
public interface User_RoleDao {

    @Insert("insert into users_role values(#{uid},#{rid})")
    void add(@Param("uid") String uid, @Param("rid") String rid) throws Exception;
    @Delete("delete from users_role where userId=#{uid}")
    void deleteByUid(String userId)throws Exception;
}
