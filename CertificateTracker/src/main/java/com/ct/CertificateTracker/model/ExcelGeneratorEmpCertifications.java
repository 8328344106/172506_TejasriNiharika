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
 
 
public class ExcelGeneratorEmpCertifications {
  
  public static ByteArrayInputStream employeeToExcel(List<EmployeeDetailsCertificationDetails> employees) throws IOException {
    String[] COLUMNs = {"Employee Id", "Employee Name", "Certification Category", "Certification Name","Certified Date", "Expiration Date",
    		"Certification Month", "Location","Local Grade", "Global Practice","File Name"};
    try(
        Workbook workbook = new XSSFWorkbook();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
    ){
      CreationHelper createHelper = workbook.getCreationHelper();
   
      Sheet sheet = workbook.createSheet("Certifications");
   
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
      for (EmployeeDetailsCertificationDetails employee : employees) {
        Row employeeRow = sheet.createRow(rowIdx++);
        
        employeeRow.createCell(0).setCellValue(employee.getEmpId());
        employeeRow.createCell(1).setCellValue(employee.getEmpName());
        employeeRow.createCell(2).setCellValue(employee.getCerCategory());
        employeeRow.createCell(3).setCellValue(employee.getCerName());
        employeeRow.createCell(4).setCellValue(employee.getCerDate());
        employeeRow.createCell(5).setCellValue(employee.getExpDate());
        employeeRow.createCell(6).setCellValue(employee.getCerMonth());
        employeeRow.createCell(7).setCellValue(employee.getLocation());
        employeeRow.createCell(8).setCellValue(employee.getLocalGrade());
        employeeRow.createCell(9).setCellValue(employee.getGlobalPractice());
        employeeRow.createCell(10).setCellValue(employee.getFileName());

      }
   
      workbook.write(out);
      return new ByteArrayInputStream(out.toByteArray());
    }
  }
}