package com.example.spm.service.impl;

import com.example.spm.mapper.TeacherMapper;
import com.example.spm.model.Teacher;
import com.example.spm.service.TeacherService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherMapper teacherMapper;

    public TeacherServiceImpl(TeacherMapper teacherMapper) {
        this.teacherMapper = teacherMapper;
    }

    @Override
    public List<Teacher> selectAll() {
        return teacherMapper.selectAll();
    }

    @Override
    public List<Teacher> selectByName(String name) {
        return teacherMapper.selectByName(name);
    }

    @Override
    public Teacher selectById(int id) {
        return teacherMapper.selectById(id);
    }

    @Override
    public int insertTeacher(Teacher teacher) {
        return teacherMapper.insertTeacher(teacher);
    }

    @Override
    public int deleteTeacherById(Teacher teacher) {
        return teacherMapper.deleteTeacherById(teacher);
    }
}
