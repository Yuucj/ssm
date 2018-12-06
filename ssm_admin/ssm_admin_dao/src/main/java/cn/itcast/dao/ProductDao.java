package cn.itcast.dao;

import cn.itcast.domain.Product;

import java.util.List;

/**
 * @author yucongjun
 * @date 2018/11/27 21:03
 */
public interface ProductDao {
    /**
     * 查询所有
     *
     * @param condition
     * @return
     * @throws Exception
     */
    List<Product> findAll(String condition) throws Exception;

    /**
     * 添加
     *
     * @param product
     * @throws Exception
     */
    void save(Product product) throws Exception;

    /**
     * 删除
     *
     * @param ids
     * @throws Exception
     */
    void delete(String[] ids) throws Exception;


    /**
     * 通过id查找
     *
     * @param id
     * @return
     */
    Product findById(String id) throws Exception;

    /**
     * 更新
     *
     * @param product
     */
    void update(Product product);
}
