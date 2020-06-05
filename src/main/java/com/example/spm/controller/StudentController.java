package com.example.spm.controller;


import com.example.spm.model.Student;
import com.example.spm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@RestController
// 默认是ISO--8859-1，会导致中文乱码
@RequestMapping(value = "/api/student", produces = "application/json;charset=utf-8")
public class StudentController {

    @Autowired
    private StudentService studentService;


    /**
     * @param student
     * @param response
     * @return
     */
    @CrossOrigin
    @PostMapping(value = "login", consumes = "application/json")
    public Student login(@RequestBody Student student, HttpServletResponse response) {
        Student principal = studentService.selectById(student.getSid());

        if (principal != null) {
            return principal;
        }

        response.setStatus(403);

        return null;
    }


    /**
     * @return
     */
    @CrossOrigin
    @GetMapping(value = "students")
    public List<Student> findList() {
        return studentService.selectAll();
    }

    /**
     * @param student
     * @param response
     * @return
     */
    @CrossOrigin
    @PostMapping(value = "insert", consumes = "application/json")
    public int insertStudent(@RequestBody Student student, HttpServletResponse response) throws IOException {
        int lines = studentService.insert(student);
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        if (lines > 0) {
            out.print("数据插入成功！");
        }
        else {
            out.print("数据插入失败！");
        }
        out.close();
        return lines;
    }

    /**
     * @param student
     * @param response
     * @return
     * @throws IOException
     */
    @CrossOrigin
    @PostMapping(value = "delete", consumes = "application/json")
    public int deletStudentById(@RequestBody  Student student, HttpServletResponse response) throws IOException {
        int lines = studentService.deleteStudentById(student);
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        if (lines > 0) {
            out.print("数据删除成功！");
        }
        else {
            out.print("数据删除失败！");
        }
        out.close();
        return lines;
    }

    @CrossOrigin
    @PostMapping(value = "updateGrade", consumes = "application/json")
    public int  updateStudentGradeById(@RequestBody Student student, HttpServletResponse response) throws IOException {
        int lines = studentService.updateStudentGradeById(student);
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        if (lines > 0) {
            out.print("数据更新成功！");
        }
        else {
            out.print("数据更新失败！");
        }
        out.close();
        return lines;
    }
}
