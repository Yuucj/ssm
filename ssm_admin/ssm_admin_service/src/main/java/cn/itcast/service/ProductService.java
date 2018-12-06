package cn.itcast.service;

import cn.itcast.domain.Product;

import java.util.List;

/**
 * @author yucongjun
 * @date 2018/11/27 21:05
 */
public interface ProductService {
    List<Product> findAll(String condition, int page, int rows) throws Exception;

    void save(Product product) throws Exception;

    void delete(String[] ids) throws Exception;

    void block(String[] ids) throws Exception;

    void active(String[] ids) throws Exception;

    Product findById(String id) throws Exception;

    void update(Product product) throws Exception;
}
