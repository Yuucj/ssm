package cn.itcast.controller;
import cn.itcast.domain.Product;
import cn.itcast.service.ProductService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


/**
 * @author yucongjun
 * @date 2018/11/27 21:10
 */
@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    /**
     * 查询所有product
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(defaultValue = "")String condition, @RequestParam(required = false, defaultValue = "1") Integer page,
                                @RequestParam(required = false, defaultValue = "5") Integer rows) throws Exception {
        List<Product> productList = productService.findAll(condition, page, rows);
        PageInfo<Product> pageInfo = new PageInfo<>(productList);
        ModelAndView modelAndView = new ModelAndView("product-list", "pageInfo", pageInfo);
        modelAndView.addObject("condition", condition);
        return modelAndView;
    }

    /**
     * 增加新product
     *
     * @param product
     * @return
     * @throws Exception
     */
    @RequestMapping("/save")
    public String save(Product product) throws Exception {
            productService.save(product);
        return "redirect:findAll";
    }

    /**
     * 删除
     *
     * @param ids
     * @return
     * @throws Exception
     */
    @RequestMapping("/delete")
    public String delete(String[] ids) throws Exception {
        productService.delete(ids);
        return "redirect:findAll";
    }

    /**
     * 激活
     *
     * @param ids
     * @return
     * @throws Exception
     */
    @RequestMapping("/active")
    public String active(String[] ids) throws Exception {
        productService.active(ids);
        return "redirect:findAll";
    }

    /**
     * 屏蔽
     *
     * @param ids
     * @return
     * @throws Exception
     */
    @RequestMapping("/block")
    public String block(String[] ids) throws Exception {

        productService.block(ids);
        return "redirect:findAll";
    }

    /**
     * 修改,回传数据
     * @param id
     * @param next
     * @return
     * @throws Exception
     */
    @RequestMapping("/findById")
    public String findById(String id, String next, Model model) throws Exception {
        Product product = productService.findById(id);
        model.addAttribute("product",product);
        return next;
      //  return new ModelAndView(next,"product",product);
    }

    @RequestMapping("/update")
    public String update(Product product) throws Exception {
        productService.update(product);
        return "redirect:findAll";
    }
}
