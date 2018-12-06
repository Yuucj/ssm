package cn.itcast.dao;

import cn.itcast.domain.SysLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author yucongjun
 * @date 2018/12/3 18:52
 */
public interface SysLogDao {
    @Select("select * from sysLog where url like '%${value}%' order by visitTime Desc ")
    List<SysLog> findAll(String condition)throws Exception;

    @Insert("insert into sysLog (visitTime,username,ip,url,executionTime,method)" +
            " values(#{visitTime},#{username},#{ip},#{url},#{executionTime},#{method})")
    void save(SysLog sysLog)throws Exception;

    @Select("select * from sysLog")
    List<SysLog> find();
}
