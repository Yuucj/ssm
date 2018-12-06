package cn.itcast.dao;

import cn.itcast.domain.UserInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author yucongjun
 * @date 2018/11/30 21:09
 */
public interface UserDao {

    List<UserInfo> findAll(String condition) throws Exception;

    @Insert("insert into users(email,username,password,phoneNum,status) values (#{email},#{username},#{password},#{phoneNum},#{status})")
    void save(UserInfo user) throws Exception;

    UserInfo findById(String id) throws Exception;

    UserInfo findByUsername(String username) throws Exception;
    @Update("update users set email=#{email},password=#{password},phoneNum=#{phoneNum},status=#{status} where id=#{id}")
    void update(UserInfo user) throws Exception;
    @Delete("delete from users where id=#{id}")
    void delete(String id)throws Exception;
}
