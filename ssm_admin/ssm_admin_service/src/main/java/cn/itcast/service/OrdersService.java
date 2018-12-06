package cn.itcast.service;

import cn.itcast.domain.Orders;

import java.util.List;

/**
 * @author yucongjun
 * @date 2018/11/29 9:03
 */
public interface OrdersService {

    List<Orders> findAll(String condition, int page, int rows) throws Exception;

    Orders findById(String id) throws Exception;

    void delete(String[] ids) throws Exception;

    void payed(String[] ids) throws Exception;

    void unPayed(String[] ids) throws Exception;

    void updatePayType(Orders orders) throws Exception;
}
