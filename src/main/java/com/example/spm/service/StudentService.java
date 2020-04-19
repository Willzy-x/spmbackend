package com.example.spm.service;

import com.example.spm.mapper.StudentMapper;
import com.example.spm.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

    public List<Student> selectAll();

    public List<Student> selectByName(String name);

    public Student selectById(int id);
}
