package com.example.spm.controller;

import com.example.spm.model.UnitTest;
import com.example.spm.service.UnitTestService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@RestController
@RequestMapping(value = "/api/unittest", produces = "application/json;charset=utf-8")
public class UnitTestController {

    private final UnitTestService unitTestService;

    public UnitTestController(UnitTestService unitTestService) {
        this.unitTestService = unitTestService;
    }

    @CrossOrigin
    @GetMapping("findAll")
    public List<UnitTest> findList() {
        return unitTestService.findAll();
    }

    @CrossOrigin
    @PostMapping(value = "findById", consumes = "application/json")
    public UnitTest findById(@RequestBody UnitTest unitTest, HttpServletResponse response) {
        UnitTest principal =  unitTestService.findById(unitTest.getSid());
        if (principal != null) {
            return principal;
        }

        response.setStatus(403);
        return null;
    }

    @CrossOrigin
    @PostMapping("insert")
    public int insert(@RequestBody UnitTest unitTest, HttpServletResponse response) throws IOException {
        int lines = unitTestService.insert(unitTest);
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
    @PostMapping("updateGrade")
    public int  updateGradeById(@RequestBody UnitTest unitTest, HttpServletResponse response) throws IOException {
        int lines = unitTestService.updateGradeById(unitTest);
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
