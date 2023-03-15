/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finlogic.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;
import javax.servlet.ServletOutputStream;


/**
 *
 * @author njuser
 */
@Service
public class DownloadFileUtil {
    
    public void downloadFile(HttpServletResponse response, String fileName, String filePath) throws FileNotFoundException, IOException {
        File file = new File(filePath + fileName);
        if (file.exists()) {

            response.setContentType("application/octet-stream");
            response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
            try ( FileInputStream fileInputStream = new FileInputStream(filePath + fileName)) {
                ServletOutputStream out = response.getOutputStream();

              int i;
                while ((i = fileInputStream.read()) != -1) {
                    out.write(i);
                }
                fileInputStream.close();
                out.flush();
                out.close();
            }
        }
    }
}
