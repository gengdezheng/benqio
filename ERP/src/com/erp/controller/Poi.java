package com.erp.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.erp.dao.AdminDao;
import com.erp.model.Orders;
import com.erp.service.OrderService;

@Controller
public class Poi {

	@Autowired
	AdminDao adminDao;
	
	@Autowired
	OrderService orderService;
	@RequestMapping("/exportFile.action")
	//@ResponseBody
	public void exportFile(HttpServletResponse response) throws Exception {
        File file = new File("G:\\desktop\\OrderForm.xls");
        if(!file.exists())
         file.createNewFile();
		List<Orders> orderList = adminDao.orderList();     // 需要导出的数据		
			String[] titles = { "订单编号", "下单时间", "订单类型", "数量", "客户编号", "金额" };
			FileOutputStream out = new FileOutputStream(file);
			try {
				// 第一步，创建一个workbook，对应一个Excel文件
				HSSFWorkbook workbook = new HSSFWorkbook();

				// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
				HSSFSheet hssfSheet = workbook.createSheet("sheet1");

				// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short

				HSSFRow row = hssfSheet.createRow(0);
				// 第四步，创建单元格，并设置值表头 设置表头居中
				HSSFCellStyle hssfCellStyle = workbook.createCellStyle();

				HSSFCell hssfCell = null;
				for (int i = 0; i < titles.length; i++) {
					hssfCell = row.createCell(i);// 列索引从0开始
					hssfCell.setCellValue(titles[i]);// 列名1
					hssfCell.setCellStyle(hssfCellStyle);// 列居中显示
				}
				// 第五步，写入实体数据

				for (int i = 0; i < orderList.size(); i++) {
					row = hssfSheet.createRow(i + 1);
					Orders order = orderList.get(i);

					// 第六步，创建单元格，并设置值
					
					row.createCell(0).setCellValue(order.getId());
					row.createCell(1).setCellValue(order.getOrderTime().toString());
					row.createCell(2).setCellValue(order.getOrderType());
					row.createCell(3).setCellValue(order.getOrderNumber());
					row.createCell(4).setCellValue(order.getClientId());
					row.createCell(5).setCellValue(order.getOrderBalance());

				}
				   workbook.write(out);//保存Excel文件
	                out.close();//关闭文件流
				// 第七步，将文件输出到客户端浏览器
				try {
					workbook.write(response.getOutputStream());
					response.getOutputStream().flush();
					response.getOutputStream().close();

				} catch (Exception e) {
					e.printStackTrace();
				}
			} catch (Exception e) {
				System.out.println("导出信息失败！");
				e.printStackTrace();
			}
		
	}
	
	@RequestMapping("/input.action")
	@ResponseBody
	public String Input(String url,HttpServletRequest request,HttpServletResponse response) {
		String msg="上传异常！"; 
		try {
              //文件路径
              InputStream is = new FileInputStream(new File(url));
              Workbook hssfWorkbook = null;
              if (url.endsWith("xls")) {
                  hssfWorkbook = new HSSFWorkbook(is);//Excel 2003
                  // 循环工作表Sheet
                  for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
                      //HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
                      Sheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
                      if (hssfSheet == null) {
                          continue;
                      }
                      // 循环行Row
                      for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                          //HSSFRow hssfRow = hssfSheet.getRow(rowNum);
                          Row hssfRow = hssfSheet.getRow(rowNum);
                          if (hssfRow != null) {


                              Cell orderTime = hssfRow.getCell(0);
                              orderTime.setCellType(CellType.STRING);
                              double date=Double.parseDouble(orderTime.getStringCellValue());
                              Cell orderType = hssfRow.getCell(1);
                              Cell orderNumber = hssfRow.getCell(2);
                              Cell clientId = hssfRow.getCell(3);
                              Cell orderBalance = hssfRow.getCell(4);
                              
                              Orders o = new Orders();
                              o.setOrderType(orderType+"");
                              o.setOrderTime(HSSFDateUtil.getJavaDate(date));
                              double t=Double.parseDouble(orderNumber+"");           
                              o.setOrderNumber((int)t);                              
                              double c=Double.parseDouble(clientId+"");
                              o.setClientId((int)c);                             
                              o.setOrderBalance(Double.parseDouble(orderBalance+""));
                              orderService.addOrder(o);
                          }                      
                      }
                  } 
                  msg="上传成功！";
              }
          }catch (Exception e){
            System.out.println(e.getMessage());
          }
		return JSON.toJSONString(msg);
	}
}
