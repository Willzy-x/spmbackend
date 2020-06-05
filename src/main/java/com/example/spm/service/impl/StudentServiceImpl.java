package com.example.spm.service.impl;

import com.example.spm.mapper.StudentMapper;
import com.example.spm.model.Student;
import com.example.spm.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    private final StudentMapper studentMapper;

    public StudentServiceImpl(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

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

    @Override
    public int insert(Student student) {
        return studentMapper.insertStudent(student);
    }

    @Override
    public int deleteStudentById(Student student) {
        return studentMapper.deleteStudentById(student);
    }

    @Override
    public int updateStudentGradeById(Student student) {
        return studentMapper.updateStudentGradeById(student);
    }

}
