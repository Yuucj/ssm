package cn.itcast.dao;

import cn.itcast.domain.Member;

/**
 * @author yucongjun
 * @date 2018/11/29 9:04
 */
public interface MemberDao {
    Member findById(String id);
}
