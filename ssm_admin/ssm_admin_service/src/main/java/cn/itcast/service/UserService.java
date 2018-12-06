package cn.itcast.service;

import cn.itcast.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * @author yucongjun
 * @date 2018/11/30 21:11
 */
public interface UserService extends UserDetailsService {
    List<UserInfo> findAll(String condition, Integer page, Integer rows) throws Exception;

    void save(UserInfo user) throws Exception;

    UserInfo findById(String id) throws Exception;

    void addRole(String uid, String[] ids) throws Exception;

    void deleteRole(String userId) throws Exception;

    void update(UserInfo user, Integer flag) throws Exception;

    void delete(String[] ids)throws Exception;
}
