package com.example.spm.controller;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.spm.model.Files;
import com.example.spm.util.FilesUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/file")
public class FileController {
    List<Files> listFile = new LinkedList<>();

    /**
     * 上传文件
     */
    @CrossOrigin
    @ResponseBody
    @PostMapping("upload")
    public Object upload(HttpServletRequest request, MultipartFile file) {
        String name = "";
        try {
            String fileName = file.getOriginalFilename();
            System.out.println(fileName);
            name = fileName;
            FilesUtils.fileOut(request, file, name);
            Files f = new Files();
            f.setName(name);
            listFile.add(f);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 1;
    }

    /**
     * 文件列表
     */
    @CrossOrigin
    @GetMapping("listFile")
    @ResponseBody
    public Object listFile(HttpServletResponse response) {
        return listFile;
    }
    /**
     * 获取文件
     */
    @CrossOrigin
    @GetMapping("getFile/{name}")
    public void getFile(HttpServletResponse response, @PathVariable("name") String name) {
        try {
            FilesUtils.fileIn(response, name, 2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
