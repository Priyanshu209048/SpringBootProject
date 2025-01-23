package com.lcwd.root.Controller;

import com.lcwd.root.Service.PdfService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;
import java.io.IOException;

@Controller
public class PdfController {

    @Autowired
    private PdfService pdfService;

    private Logger logger = LoggerFactory.getLogger(PdfController.class);

    @GetMapping(value = "/create", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> createPdfs() throws IOException {

        ByteArrayInputStream pdf = pdfService.createPdf();
        System.out.println(pdf);
        logger.info("PdfService Class called");

        HttpHeaders headers = new HttpHeaders();
        logger.info("HttpHeaders Class called");

        headers.add("Content-Disposition", "inline;file=lcwd.pdf");
        logger.info("added");
        return ResponseEntity.ok().headers(headers).body(new InputStreamResource(pdf));

    }

}
