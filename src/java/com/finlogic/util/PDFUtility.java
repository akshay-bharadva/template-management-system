/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finlogic.util;

//import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import java.io.FileNotFoundException;
//import java.util.Date;
import java.io.FileOutputStream;

/**
 *
 * @author njuser
 */
public class PDFUtility {

    public String generatePDF(String refNo,String data ,String pdfName) throws FileNotFoundException {

        pdfName = pdfName.replace(" ", "-");
        String fileName = pdfName + "-" +refNo + ".pdf";
        String filePath = CommonUtil.pdfFilePath() + fileName;

        String HTML = "<!DOCTYPE html>\n"
                + "<html>\n"
                + "  <head>\n"
                + "    <meta charset=\"utf-8\" />\n"
                + "    <title> "+ fileName + "</title>\n"
                + "    <style type=\"text/css\">\n"
                + "      * {\n"
                + "        font-family: sans-serif;\n"
                + "      }\n"
                + "      div.header {\n"
                + "        width: 700px;\n"
                + "        position: running(header);\n"
                + "      }\n"
                + "      div.footer {\n"
                + "        width: 700px;\n"
                + "        position: running(footer);\n"
                + "      }\n"
                + "      @page {\n"
                + "        margin-top: 1in;\n"
                + "        margin-bottom: 1.5in;\n"
                + "        @top-center {\n"
                + "          content: element(header);\n"
                + "        }\n"
                + "        @bottom-center {\n"
                + "          content: element(footer);\n"
                + "        }\n"
                + "      }\n"
                + "    </style>\n"
                + "  </head>\n"
                + "  <body>\n"
                + "    <div class=\"header\" style=\"width: 700px\">\n"
                + "      <img\n"
                + "        src=\"file:////home/njuser/NetBeansProjects/tms/web/Asset/images/nj/comp_header_27.png\"\n"
                + "        width=\"700px\"\n"
                + "      />\n"
                + "    </div>\n"
                + "    <div class=\"footer\" style=\"width: 700px\">\n"
                + "      <img\n"
                + "        src=\"file:////home/njuser/NetBeansProjects/tms/web/Asset/images/nj/comp_footer_27.png\"\n"
                + "        width=\"700px\"\n"
                + "      />\n"
                + "    </div>\n"
                + "    <div>\n"
                + data
                + "    </div>\n"
                + "  </body>\n"
                + "</html>";
//        System.out.println("filePath : " + filePath);
//        System.out.println("HTML : " + HTML);
        ConverterProperties props = new ConverterProperties();
        props.setBaseUri("/home/njuser/NetBeansProjects/tms/web/Asset/images/nj");

        HtmlConverter.convertToPdf(HTML, new FileOutputStream(filePath));

//        System.out.println("PDF Created!");
        
        HtmlConverter.convertToPdf(HTML, new FileOutputStream(filePath));

        return fileName;

    }
}
/* 

        String HTML = "<!DOCTYPE html>\n"
                + "<html lang=\"en\">\n"
                + "  <head>\n"
                + "    <meta charset=\"UTF-8\" />\n"
                + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\n"
                + "    <title>" + fileName + "</title>\n"
                + "  </head>\n"
                + "  <body>\n"
//                + "  <header>\n"
//                + "  <img src=\"/home/njuser/NetBeansProjects/tms/web/Asset/images/nj/comp_header_27.png\">\n"
//                + "  </header>\n"
                + data
//                + "  <footer>\n"
//                + "  <img src=\"/home/njuser/NetBeansProjects/tms/web/Asset/images/nj/comp_footer_27.png\">\n"
//                + "  </footer>\n"
                + "  </body>\n"
                + "</html>";

//        System.out.println("filePath : " + filePath);
//        System.out.println("HTML : " + HTML);
//        ConverterProperties props = new ConverterProperties();
//        props.setBaseUri("/home/njuser/NetBeansProjects/tms/web/Asset/images/nj/");
*/