package cn.itcast.service.impl;

import cn.itcast.dao.OrdersDao;
import cn.itcast.domain.Orders;
import cn.itcast.service.OrdersService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author yucongjun
 * @date 2018/11/29 9:03
 */
@Service
@Transactional
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private OrdersDao ordersDao;

    @Override
    public List<Orders> findAll(String condition, int page, int rows) throws Exception {
        PageHelper.startPage(page, rows);
        if (condition != null) {
            condition = condition.trim();
        }
        return ordersDao.findAll(condition);
    }

    @Override
    public Orders findById(String id) throws Exception {
        return ordersDao.findById(id);
    }

    @Override
    public void delete(String[] ids) throws Exception {
        for (String id : ids) {
            ordersDao.delete(id);
        }
    }

    @Override
    public void payed(String[] ids) throws Exception {
        for (String id : ids) {
            ordersDao.payed(id);
        }
    }

    @Override
    public void unPayed(String[] ids) throws Exception {
        for (String id : ids) {
            ordersDao.unPayed(id);
        }
    }

    @Override
    public void updatePayType(Orders orders) throws Exception {
        ordersDao.updatePayType(orders);
    }
}
