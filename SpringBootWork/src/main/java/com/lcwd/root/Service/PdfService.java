package com.lcwd.root.Service;

import com.lowagie.text.*;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.HeaderFooter;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfDocument;
import com.lowagie.text.pdf.PdfWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Service
public class PdfService {

    private Logger logger = LoggerFactory.getLogger(PdfService.class);

    //We return ByteArrayInputStream here so that we can read the data from that.
    public ByteArrayInputStream createPdf() {

        logger.info("Create PDF");
        String title = "Welcome to my Website";
        String content = "This program is used to generate a PDF file using Spring boot.";

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        Document document = new Document();
        PdfWriter.getInstance(document, outputStream);

        HeaderFooter footer = new HeaderFooter(true, new Phrase(" Hello"));
        footer.setAlignment(Element.ALIGN_CENTER);
        footer.setBorderWidthBottom(0);
        document.setFooter(footer);

        //writer.setPdfVersion(PdfWriter.VERSION_1_5);
        document.open();

        Font fontTitle = FontFactory.getFont(FontFactory.HELVETICA, 25, Font.BOLD);
        Paragraph paragraph = new Paragraph(title, fontTitle);
        paragraph.setAlignment(Element.ALIGN_CENTER);
        document.add(paragraph);

        Font fontContent = FontFactory.getFont(FontFactory.HELVETICA, 25, Font.ITALIC, Color.blue);
        Paragraph paragraphContent = new Paragraph(content, fontContent);
        paragraphContent.setAlignment(Element.ALIGN_CENTER);
        paragraphContent.add(new Chunk("This is text is added after creating paragraph"));
        document.add(paragraphContent);

        logger.info("Pdf Generated");
        document.close();

        return new ByteArrayInputStream(outputStream.toByteArray());

    }

}
