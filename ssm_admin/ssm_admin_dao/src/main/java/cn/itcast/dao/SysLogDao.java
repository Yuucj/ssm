package cn.itcast.dao;

import cn.itcast.domain.SysLog;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author yucongjun
 * @date 2018/12/3 18:52
 */
public interface SysLogDao {

    List<SysLog> findAll(String condition) throws Exception;

    @Insert("insert into sysLog (visitTime,username,ip,url,executionTime,method)" +
            " values(#{visitTime},#{username},#{ip},#{url},#{executionTime},#{method})")
    void save(SysLog sysLog) throws Exception;

    @Select("select * from sysLog order by visitTime Desc")
    List<SysLog> find() throws Exception;

    @Delete("truncate table sysLog")
    void deleteAll() throws Exception;

}
