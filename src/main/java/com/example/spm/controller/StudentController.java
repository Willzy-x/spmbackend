package com.example.spm.controller;


import com.example.spm.model.Student;
import com.example.spm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
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
    @GetMapping(value = "students")
    public List<Student> findList() {
        return studentService.selectAll();
    }
}
