package com.example.spm.service;

import com.example.spm.mapper.StudentMapper;
import com.example.spm.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

    List<Student> selectAll();

    List<Student> selectByName(String name);

    Student selectById(int id);

    int insert(Student student);

    int deleteStudentById(Student student);

    int updateStudentGradeById(Student student);
}
