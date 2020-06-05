package com.example.spm.controller;

import com.example.spm.model.Teacher;
import com.example.spm.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@RestController
@RequestMapping(value = "/api/teacher", produces = "application/json;charset=utf-8")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    /**
     * @param teacher
     * @param response
     * @return
     */
    @CrossOrigin
    @PostMapping(value = "login",  consumes = "application/json")
    public Teacher login(@RequestBody Teacher teacher, HttpServletResponse response) {
        Teacher principle = teacherService.selectById(teacher.getTid());

        if (principle != null) {
            return principle;
        }

        response.setStatus(403);

        return null;
    }

    @CrossOrigin
    @GetMapping(value = "teachers")
    public List<Teacher> findList() { return teacherService.selectAll(); }


    @CrossOrigin
    @PostMapping(value = "insert", consumes = "application/json")
    public int insertTeacher(@RequestBody Teacher teacher, HttpServletResponse response) throws IOException {
        int lines = teacherService.insertTeacher(teacher);
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

    @CrossOrigin
    @PostMapping(value = "delete", consumes = "application/json")
    public int deleteTeacherById(@RequestBody Teacher teacher, HttpServletResponse response) throws IOException {
        int lines = teacherService.deleteTeacherById(teacher);
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        if (lines > 0) {
            out.print("数据删除成功");
        } else {
            out.print("数据删除失败");
        }
        out.close();
        return lines;
    }
}
