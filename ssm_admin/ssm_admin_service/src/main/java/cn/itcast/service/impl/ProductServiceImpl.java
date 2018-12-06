package cn.itcast.service.impl;


import cn.itcast.dao.ProductDao;
import cn.itcast.domain.Product;
import cn.itcast.service.ProductService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.security.RolesAllowed;
import java.util.List;

/**
 * @author yucongjun
 * @date 2018/11/27 21:05
 */
@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;

    /**
     * 查询所有product
     *
     * @param condition
     * @param page
     * @param rows
     * @return
     * @throws Exception
     */
    @Override
    public List<Product> findAll(String condition, int page, int rows) throws Exception {
        PageHelper.startPage(page,rows);
        if (condition != null) {
            condition = condition.trim();
        }
        return productDao.findAll(condition);
    }

    /**
     * 添加product
     *
     * @param product
     * @throws Exception
     */
    @Override
    public void save(Product product) throws Exception {
        productDao.save(product);
    }

    /**
     * 删除product
     *
     * @param ids
     * @throws Exception
     */
    @Override
    public void delete(String[] ids) throws Exception {
        productDao.delete(ids);
    }

    /**
     * 屏蔽
     *
     * @param ids
     * @throws Exception
     */
    @Override
    public void block(String[] ids) throws Exception {
        for (String id : ids) {
            Product product = productDao.findById(id);
            product.setProductStatus(0);
            productDao.update(product);
        }
    }

    /**
     * 激活
     *
     * @param ids
     * @throws Exception
     */
    @Override
    public void active(String[] ids) throws Exception {
        for (String id : ids) {
            Product product = productDao.findById(id);
            product.setProductStatus(1);
            productDao.update(product);
        }
    }

    /**
     * 通过id查找
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public Product findById(String id) throws Exception {
        return productDao.findById(id);
    }

    /**
     * 修改product
     * @param product
     * @throws Exception
     */
    @Override
    public void update(Product product) throws Exception {
        productDao.update(product);
    }
}
