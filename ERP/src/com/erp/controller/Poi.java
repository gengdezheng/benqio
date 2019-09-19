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
		List<Orders> orderList = adminDao.orderList();     // ��Ҫ����������		
			String[] titles = { "�������", "�µ�ʱ��", "��������", "����", "�ͻ����", "���" };
			FileOutputStream out = new FileOutputStream(file);
			try {
				// ��һ��������һ��workbook����Ӧһ��Excel�ļ�
				HSSFWorkbook workbook = new HSSFWorkbook();

				// �ڶ�������webbook�����һ��sheet,��ӦExcel�ļ��е�sheet
				HSSFSheet hssfSheet = workbook.createSheet("sheet1");

				// ����������sheet����ӱ�ͷ��0��,ע���ϰ汾poi��Excel����������������short

				HSSFRow row = hssfSheet.createRow(0);
				// ���Ĳ���������Ԫ�񣬲�����ֵ��ͷ ���ñ�ͷ����
				HSSFCellStyle hssfCellStyle = workbook.createCellStyle();

				HSSFCell hssfCell = null;
				for (int i = 0; i < titles.length; i++) {
					hssfCell = row.createCell(i);// ��������0��ʼ
					hssfCell.setCellValue(titles[i]);// ����1
					hssfCell.setCellStyle(hssfCellStyle);// �о�����ʾ
				}
				// ���岽��д��ʵ������

				for (int i = 0; i < orderList.size(); i++) {
					row = hssfSheet.createRow(i + 1);
					Orders order = orderList.get(i);

					// ��������������Ԫ�񣬲�����ֵ
					
					row.createCell(0).setCellValue(order.getId());
					row.createCell(1).setCellValue(order.getOrderTime().toString());
					row.createCell(2).setCellValue(order.getOrderType());
					row.createCell(3).setCellValue(order.getOrderNumber());
					row.createCell(4).setCellValue(order.getClientId());
					row.createCell(5).setCellValue(order.getOrderBalance());

				}
				   workbook.write(out);//����Excel�ļ�
	                out.close();//�ر��ļ���
				// ���߲������ļ�������ͻ��������
				try {
					workbook.write(response.getOutputStream());
					response.getOutputStream().flush();
					response.getOutputStream().close();

				} catch (Exception e) {
					e.printStackTrace();
				}
			} catch (Exception e) {
				System.out.println("������Ϣʧ�ܣ�");
				e.printStackTrace();
			}
		
	}
	
	@RequestMapping("/input.action")
	@ResponseBody
	public String Input(String url,HttpServletRequest request,HttpServletResponse response) {
		String msg="�ϴ��쳣��"; 
		try {
              //�ļ�·��
              InputStream is = new FileInputStream(new File(url));
              Workbook hssfWorkbook = null;
              if (url.endsWith("xls")) {
                  hssfWorkbook = new HSSFWorkbook(is);//Excel 2003
                  // ѭ��������Sheet
                  for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
                      //HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
                      Sheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
                      if (hssfSheet == null) {
                          continue;
                      }
                      // ѭ����Row
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
                  msg="�ϴ��ɹ���";
              }
          }catch (Exception e){
            System.out.println(e.getMessage());
          }
		return JSON.toJSONString(msg);
	}
}
