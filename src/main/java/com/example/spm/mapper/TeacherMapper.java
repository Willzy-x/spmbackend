package com.example.spm.mapper;

import com.example.spm.model.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "teacherMapper")
public interface TeacherMapper {

    List<Teacher> selectAll();

    List<Teacher> selectByName(String name);

    Teacher selectById(int id);

    int insertTeacher(Teacher teacher);

    int deleteTeacherById(Teacher teacher);
}
