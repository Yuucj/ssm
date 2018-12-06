package cn.itcast.dao;

import cn.itcast.domain.Orders;

import java.util.List;

/**
 * @author yucongjun
 * @date 2018/11/29 9:03
 */
public interface OrdersDao {

    List<Orders> findAll(String condition) throws Exception;

    Orders findById(String id) throws Exception;

    void delete(String id) throws Exception;

    void payed(String id) throws Exception;

    void unPayed(String id) throws Exception;

    void updatePayType(Orders orders) throws Exception;
}
