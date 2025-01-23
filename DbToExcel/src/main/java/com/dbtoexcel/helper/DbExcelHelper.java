package com.dbtoexcel.helper;

import com.dbtoexcel.model.Person;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

public class DbExcelHelper {

    public static String[] HEADERS = {
            "id",
            "email",
            "first_name",
            "last_name",
            "gender"
    };

    public static String SHEET_NAME = "person_data";

    public static ByteArrayInputStream dataToExcel(List<Person> personList){

        try(Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream outputStream = new ByteArrayOutputStream();){

            //Create workbook

            //Create sheet
            Sheet sheet = workbook.createSheet(SHEET_NAME);

            //Create row : Header row
            Row row = sheet.createRow(0);
            for (int i = 0; i < HEADERS.length; i++) {
                Cell cell = row.createCell(i);
                cell.setCellValue(HEADERS[i]);
            }

            //Rows value
            int rowIndex = 1;
            for (Person person : personList) {
                Row dataRow = sheet.createRow(rowIndex);

                dataRow.createCell(0).setCellValue(person.getId());
                dataRow.createCell(1).setCellValue(person.getEmail());
                dataRow.createCell(2).setCellValue(person.getFirstName());
                dataRow.createCell(3).setCellValue(person.getLastName());
                dataRow.createCell(4).setCellValue(person.getGender());
                rowIndex++;
            }

            workbook.write(outputStream);
            return new ByteArrayInputStream(outputStream.toByteArray());

        }catch(IOException e){
            e.printStackTrace();
            System.out.println("Fail to import data into Excel");
            return null;
        }
        /*return null;*/
    }

}
