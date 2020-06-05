package com.example.spm.service;

import com.example.spm.model.Teacher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TeacherService {

    List<Teacher> selectAll();

    List<Teacher> selectByName(String name);

    Teacher selectById(int id);

    int insertTeacher(Teacher teacher);

    int deleteTeacherById(Teacher teacher);
}
