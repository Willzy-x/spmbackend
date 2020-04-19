package com.example.spm.mapper;

import com.example.spm.model.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "studentMapper")
public interface StudentMapper {

    /**
     * @return
     */
    List<Student> selectAll();


    /**
     * @param name
     * @return
     */
    List<Student> selectByName(String name);


    /**
     * @param id
     * @return
     */
    Student selectById(int id);

    /**
     * @param student
     * @return
     */
    int insertStudent(Student student);


    /**
     * @param student
     * @return
     */
    int deleteStudent(Student student);

    /**
     * @param student
     * @return
     */
    int updateStudent(Student student);
}
