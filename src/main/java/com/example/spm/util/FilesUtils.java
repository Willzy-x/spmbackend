package com.example.spm.util;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Log
@Component
public class FilesUtils {

    public static String path = "";

    @Value("${file.path}")
    public void setPath(String path) {
        FilesUtils.path = path;
    }

    /**
     * 保存文件或图片
     *
     * @param file
     * @param fileName
     *            文件名 使用uuid
     */
    public static String fileOut(HttpServletRequest request, MultipartFile file, String fileName) throws Exception {
        return getString(file, fileName, path);
    }

    public static String fileUpload(HttpServletRequest request, MultipartFile file, String fileName, String path)
            throws Exception {
        return getString(file, fileName, path);
    }

    private static String getString(MultipartFile file, String fileName, String path) throws Exception {
        try {
            File uploadFilePath = new File(path);
            if (!uploadFilePath.exists()) {
                boolean mkdirs = uploadFilePath.mkdirs();
            }
            file.transferTo(new File(path + fileName));
        } catch (Exception e) {
            throw new Exception("文件保存异常");
        }
        return path + fileName;
    }

    public static void fileDownload(HttpServletResponse response, String path, String filepathname) throws Exception {
        File file = new File(path + filepathname);
        if (!file.exists()) {
            throw new Exception("文件不存在，请联系管理员！");
        }
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
        BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
        byte[] buf = new byte[1024];
        while (bis.read(buf, 0, buf.length) != -1) {
            bos.write(buf, 0, buf.length);
        }
        bis.close();
        bos.close();
    }



    /**
     * 读取文件或图片
     * @param response
     * @param fileName
     * @param type
     *            类型 1 图片 2 文件
     * @throws Exception
     */
    public static void fileIn(HttpServletResponse response, String fileName, Integer type) throws Exception {
        try {
            File file = new File(path + fileName);
            if (!file.exists()) {
                throw new Exception("文件不存在，请联系管理员！");
            }
            response.setContentType("image/jpeg");
            response.setHeader("Content-Disposition", "inline;");
            if (type != null && type == 2) {
                response.setContentType("application/octet-stream");
                response.setHeader("Content-Disposition", "inline;");
            }
            BufferedOutputStream bos = null;
            InputStream fis = null;
            BufferedInputStream bis = null;
            try {
                bos = new BufferedOutputStream(response.getOutputStream());
                fis = new FileInputStream(path + fileName);
                bis = new BufferedInputStream(fis);
                byte[] buff = new byte[2048];
                int bytesRead;
                while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
                    bos.write(buff, 0, bytesRead);
                }
                bos.flush();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (bos != null) {
                    bos.close();
                }
                if (bis != null) {
                    bis.close();
                }
                if (fis != null) {
                    fis.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Integer isImg(String fileName, long fileSize) {
        String fileType = fileName.substring(fileName.lastIndexOf("."), fileName.length());
        if (!".jpg".equals(fileType) && !".jpeg".equals(fileType) && !".png".equals(fileType)
                && !".gif".equals(fileType)) {
            return -1;
        }
        if (fileSize / 1024 > 1024) {
            return -2;
        }
        return 1;
    }
}
