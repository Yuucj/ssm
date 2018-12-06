package cn.itcast.controller;

import cn.itcast.domain.SysLog;
import cn.itcast.service.SysLogService;
import cn.itcast.utils.ExportSysLogUtil;
import com.github.pagehelper.PageInfo;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

/**
 * @author yucongjun
 * @date 2018/12/3 18:49
 */
@Controller
@RequestMapping("/sysLog")
public class SysLogController {
    @Autowired
    private SysLogService sysLogService;

    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(defaultValue = "") String condition, @RequestParam(required = false, defaultValue = "1") Integer page,
                                @RequestParam(required = false, defaultValue = "10") Integer rows) throws Exception {
        PageInfo<SysLog> pageInfo = new PageInfo<SysLog>(sysLogService.findAll(condition, page, rows));
        ModelAndView modelAndView = new ModelAndView("syslog-list", "pageInfo", pageInfo);
        modelAndView.addObject("condition", condition);
        return modelAndView;
    }

    @RequestMapping("/export")
    public void exportSysLog(HttpServletResponse response) throws Exception {
        List<SysLog> logs = sysLogService.findAll1();
        try {
            XSSFWorkbook wb = ExportSysLogUtil.getWorkBook(logs);
            String fileName = "sysLog.xlsx";
            fileName = URLEncoder.encode(fileName, "UTF-8");
            //设置ContentType请求信息格式
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-disposition", "attachment;filename=" + fileName);
            OutputStream  out = response.getOutputStream();
            wb.write(out);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
