package com.dbtoexcel.controller;

import com.dbtoexcel.service.DbExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;
import java.io.IOException;

@RestController
@RequestMapping("/persons")
public class PersonCategory {

    @Autowired
    private DbExcelService dbExcelService;

    @RequestMapping("/excel")
    public ResponseEntity<Resource> downloadExcel() throws IOException {
        String filename = "person.xlsx";

        ByteArrayInputStream data = dbExcelService.getData();
        InputStreamResource inputStreamResource = new InputStreamResource(data);

        //Content-Disposition : It is a header indicating if the content is expected to be displayed inline in the browser, that is, as a Web page or as part of a Web page, or as an attachment, that is downloaded and saved locally.
        ResponseEntity<Resource> body = ResponseEntity.ok().header("Content-Disposition", "attachment; filename=" + filename)
                .contentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
                .body(inputStreamResource);

        return body;

    }

}
