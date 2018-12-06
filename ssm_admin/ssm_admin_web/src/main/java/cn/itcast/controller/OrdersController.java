package cn.itcast.controller;

import cn.itcast.domain.Orders;
import cn.itcast.domain.Product;
import cn.itcast.service.OrdersService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.org.apache.regexp.internal.RE;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

/**
 * @author yucongjun
 * @date 2018/11/29 9:11
 */
@Controller
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;

    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(defaultValue = "")String condition, @RequestParam(required = false, defaultValue = "1") Integer page,
                                @RequestParam(required = false, defaultValue = "5") Integer rows) throws Exception {

        List<Orders> ordersList = ordersService.findAll(condition, page, rows);

        PageInfo<Orders> pageInfo = new PageInfo<>(ordersList);
        ModelAndView modelAndView = new ModelAndView("orders-list", "pageInfo", pageInfo);
        modelAndView.addObject("condition", condition);
        return modelAndView;
    }

    @RequestMapping("/findById")
    public String findById(String id,  String next,Model model) throws Exception {
        Orders orders = ordersService.findById(id);
        model.addAttribute("orders",orders);
        return next;
    }

    @RequestMapping("/delete")
    public String delete(String[] ids) throws Exception {
        ordersService.delete(ids);
        return "redirect:findAll";
    }

    @RequestMapping("/payed")
    public String payed(String[] ids) throws Exception {
        ordersService.payed(ids);
        return "redirect:findAll";
    }

    @RequestMapping("/unPayed")
    public String unPayed(String[] ids) throws Exception {
        ordersService.unPayed(ids);
        return "redirect:findAll";
    }

    @RequestMapping("/updatePayType")
    public String updatePayType(Orders orders) throws Exception {
        ordersService.updatePayType(orders);
        return "redirect:findAll";
    }
}
