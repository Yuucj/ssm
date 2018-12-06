package cn.itcast.service.impl;

import cn.itcast.dao.UserDao;
import cn.itcast.dao.User_RoleDao;
import cn.itcast.domain.Role;
import cn.itcast.domain.UserInfo;
import cn.itcast.service.UserService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yucongjun
 * @date 2018/11/30 21:11
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private User_RoleDao user_roleDao;

    @Override
    public List<UserInfo> findAll(String condition, Integer page, Integer rows) throws Exception {
        PageHelper.startPage(page, rows);
        return userDao.findAll(condition);
    }

    @Override
    public void save(UserInfo user) throws Exception {
        String hashedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);
        userDao.save(user);
    }

    @Override
    public UserInfo findById(String id) throws Exception {
        return userDao.findById(id);
    }

    @Override
    public void addRole(String uid, String[] ids) throws Exception {
        for (String id : ids) {
            user_roleDao.add(uid, id);
        }

    }

    @Override
    public void deleteRole(String userId) throws Exception {
        user_roleDao.deleteByUid(userId);
    }

    @Override
    public void update(UserInfo user, Integer flag) throws Exception {
        if(flag ==1){
            String encode = passwordEncoder.encode(user.getPassword());
            user.setPassword(encode);
        }
        userDao.update(user);
    }

    @Override
    public void delete(String[] ids) throws Exception {
        if(ids !=null){
            for (String id : ids) {
                userDao.delete(id);
            }
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserInfo userInfo = new UserInfo();
        try {
            userInfo = userDao.findByUsername(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        User user = new User(userInfo.getUsername(), userInfo.getPassword(), userInfo.getStatus() == 1, true, true, true, getAuthority(userInfo.getRoles()));
        return user;
    }

    private List<SimpleGrantedAuthority> getAuthority(List<Role> roles) {
        List<SimpleGrantedAuthority> list = new ArrayList<SimpleGrantedAuthority>();
        for (Role role : roles) {

            list.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        }
        return list;
    }
}
