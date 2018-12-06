package cn.itcast.service;

import cn.itcast.domain.SysLog;

import java.util.List;

/**
 * @author yucongjun
 * @date 2018/12/3 18:50
 */
public interface SysLogService {
    List<SysLog> findAll(String condition, int page, int rows) throws Exception;

    void save(SysLog sysLog) throws Exception;

    List<SysLog> findAll1();
}
