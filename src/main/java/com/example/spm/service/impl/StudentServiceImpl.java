package com.example.spm.service.impl;

import com.example.spm.mapper.StudentMapper;
import com.example.spm.model.Student;
import com.example.spm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> selectAll() {
        return studentMapper.selectAll();
    }

    @Override
    public List<Student> selectByName(String name) {
        return studentMapper.selectByName(name);
    }

    @Override
    public Student selectById(int id) {
        return studentMapper.selectById(id);
    }


}
