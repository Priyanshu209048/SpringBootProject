package com.api.helper;

import com.api.entity.Person;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelHelper {

    //This method check that file is of Excel type or not
    public static boolean checkExcelFormat(MultipartFile file) {
        String contentType = file.getContentType();

        if (contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
        //if (contentType.equals("text/csv"))
            return true;
        else
            return false;
    }

    //This method is used to convert the Excel to list of persons
    public static List<Person> convertExcelToListOfPerson(InputStream is) {
        List<Person> list = new ArrayList<Person>();

        try {

            try (XSSFWorkbook workbook = new XSSFWorkbook(is)) {
                XSSFSheet sheet = workbook.getSheet("data");

                int rowNumber = 0;
                Iterator<Row> iterator = sheet.iterator();

                while (iterator.hasNext()){
                    Row row = iterator.next();

                    if (rowNumber == 0) {
                        rowNumber++;
                        continue;
                    }

                    Iterator<Cell> cells = row.iterator();
                    int cid = 0;
                    Person p = new Person();

                    while (cells.hasNext()){
                        Cell cell = cells.next();
                        switch (cid){
                            case 0:
                                p.setId((int)cell.getNumericCellValue());
                                break;
                            case 1:
                                p.setFirstName(cell.getStringCellValue());
                                break;
                            case 2:
                                p.setLastName(cell.getStringCellValue());
                                break;
                            case 3:
                                p.setGender(cell.getStringCellValue());
                                break;
                            case 4:
                                p.setEmail(cell.getStringCellValue());
                                break;
                            default:
                                break;
                        }
                        cid++;
                    }
                    list.add(p);

                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return list;
    }

}
