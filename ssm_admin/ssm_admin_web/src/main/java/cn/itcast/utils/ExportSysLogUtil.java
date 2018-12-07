package cn.itcast.utils;

import cn.itcast.domain.SysLog;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.List;

/**
 * @author yucongjun
 * @date 2018/12/5 16:06
 */
public class ExportSysLogUtil {
    public static XSSFWorkbook getWorkBook(List<SysLog> logs){

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("sysLog");
        Row titleRow = sheet.createRow(0);//创建第一行，起始为0
        titleRow.createCell(0).setCellValue(0);
        titleRow.createCell(1).setCellValue("ID");//第一列
        titleRow.createCell(2).setCellValue("访问时间");
        titleRow.createCell(3).setCellValue("访问用户");
        titleRow.createCell(4).setCellValue("访问ip");
        titleRow.createCell(5).setCellValue("资源url");
        titleRow.createCell(6).setCellValue("执行时间");
        titleRow.createCell(7).setCellValue("访问方法");

        int cell = 1 ;

        for (SysLog log : logs) {

            Row row = sheet.createRow(cell);
            row.createCell(0).setCellValue(cell);
            row.createCell(1).setCellValue(log.getId());//第一列
            row.createCell(2).setCellValue(log.getVisitTimeStr());
            row.createCell(3).setCellValue(log.getUsername());
            row.createCell(4).setCellValue(log.getIp());
            row.createCell(5).setCellValue(log.getUrl());
            row.createCell(6).setCellValue(log.getExecutionTime()+"毫秒");
            row.createCell(7).setCellValue(log.getMethod());
            cell++;
        }

        return workbook;
    }
}
