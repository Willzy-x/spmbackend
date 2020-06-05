package com.example.spm.mapper;

import com.example.spm.model.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentMapperTest {
    private static SqlSessionFactory sqlSessionFactory;

    @BeforeAll
    public static void init() {
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void selectAll() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {

            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            List<Student> students = studentMapper.selectAll();

            for (Student student : students) {
                System.out.println(student.getSname());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void selectByName() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()){

            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            List<Student> results = studentMapper.selectByName("胡与诚");

            System.out.println(results.get(0).getHashedPassword());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void selectById() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()){

            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            Student result = studentMapper.selectById(26170223);

            System.out.println(result.getSname());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void insertStudent() {
        Student student = new Student();
        student.setSid(12345678);
        student.setSname("张三");
        student.setGender(1);
        student.setGrade(60);
        student.setHashedPassword("123456");
        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)){

            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            int line = studentMapper.insertStudent(student);

            System.out.println(line);
            assertEquals(1, line);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void deleteByIdTest() {
        Student student = new Student();
        student.setSid(12345678);
        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)){
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            int lines = studentMapper.deleteStudentById(student);

            assertEquals(1, lines);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void updateStudentGradeByIdTest() {
        Student student = new Student();
        student.setSid(12345678);
        student.setGrade(99);
        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            int lines = mapper.updateStudentGradeById(student);

            assertEquals(1, lines);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}