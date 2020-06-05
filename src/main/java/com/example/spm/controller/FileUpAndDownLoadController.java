package com.example.spm.controller;

import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;


@RestController
@RequestMapping(value = "/api/")
public class FileUpAndDownLoadController {
    private final String filePath = "/Users/yucheng/IdeaProjects/spm/src/main/java/com/example/spm/static/";

    static class FileInfo {
        private String filePath;

        public String getFilePath() {
            return filePath;
        }

        public void setFilePath(String filePath) {
            this.filePath = filePath;
        }

        public FileInfo(String _filePath) {
            this.filePath = _filePath;
        }
    }

    /**
     * @param fileName
     * @param file
     * @return
     * @throws Exception
     */
    @CrossOrigin
    @PostMapping("/upload/{fileName}")
    public FileInfo upload(@PathVariable String fileName,  MultipartFile file) throws Exception {
        File localFile = new File(filePath, fileName);
        file.transferTo(localFile);
        return new FileInfo(localFile.getAbsolutePath());
    }

    /**
     * @param fileName
     * @param req
     * @param resp
     * @throws Exception
     */
    @CrossOrigin
    @GetMapping("/download/{fileName}")
    public void download(@PathVariable String fileName,
                         HttpServletRequest req, HttpServletResponse resp) throws Exception {
        try (InputStream inputStream = new FileInputStream(new File(filePath, fileName));
             OutputStream outputStream = resp.getOutputStream();){
            resp.setContentType("application/x-download");
            resp.addHeader("Content-Disposition", "attachment;filename=" + fileName);
            IOUtils.copy(inputStream, outputStream);
            outputStream.flush();
        }
    }

}
