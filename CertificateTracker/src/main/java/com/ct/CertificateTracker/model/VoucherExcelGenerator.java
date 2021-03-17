package com.ct.CertificateTracker.model;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
 
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 
 
public class VoucherExcelGenerator {
  
  public static ByteArrayInputStream vToExcel(List<voucher> vouchers) throws IOException {
    String[] COLUMNs = {"Voucher Code", "Stream", "Certification Name", "Status","Procurement Date", "Expiration Date",
    		"Assigned To(Emp Id)", "Assigned To(Emp Name)"};
    try(
        Workbook workbook = new XSSFWorkbook();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
    ){
      CreationHelper createHelper = workbook.getCreationHelper();
   
      Sheet sheet = workbook.createSheet("Vouchers");
   
      Font headerFont = workbook.createFont();
      headerFont.setBold(true);
      headerFont.setColor(IndexedColors.BLUE.getIndex());
   
      CellStyle headerCellStyle = workbook.createCellStyle();
      headerCellStyle.setFont(headerFont);
   
      // Row for Header
      Row headerRow = sheet.createRow(0);
   
      // Header
      for (int col = 0; col < COLUMNs.length; col++) {
        Cell cell = headerRow.createCell(col);
        cell.setCellValue(COLUMNs[col]);
        cell.setCellStyle(headerCellStyle);
      }
   
      // CellStyle for Age
      CellStyle ageCellStyle = workbook.createCellStyle();
      ageCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("#"));
   
      int rowIdx = 1;
      for (voucher v : vouchers) {
        Row vRow = sheet.createRow(rowIdx++);
        
        vRow.createCell(0).setCellValue(v.getVoucherCode());
        vRow.createCell(1).setCellValue(v.getStream());
        vRow.createCell(2).setCellValue(v.getExamName());
        vRow.createCell(3).setCellValue(v.getStatus());
        vRow.createCell(4).setCellValue(v.getProcurementDate());
        vRow.createCell(5).setCellValue(v.getExpiryDate());
        vRow.createCell(6).setCellValue(v.getEmpName());
        vRow.createCell(7).setCellValue(v.getEmpId());
      }
   
      workbook.write(out);
      return new ByteArrayInputStream(out.toByteArray());
    }
  }
}