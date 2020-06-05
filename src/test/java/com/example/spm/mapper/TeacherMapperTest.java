package com.example.spm.mapper;

import com.example.spm.model.Teacher;
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

class TeacherMapperTest {
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

            TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
            List<Teacher> teachers = teacherMapper.selectAll();

            for (Teacher teacher : teachers) {
                System.out.println(teacher.getTname());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void selectByName() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {

            TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
            List<Teacher> teachers = teacherMapper.selectByName("HYC");

            for (Teacher teacher : teachers) {
                System.out.println(teacher.getTname());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void selectById() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {

            TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
            Teacher teacher = teacherMapper.selectById(19101);

            System.out.println(teacher.getTname());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void insertTeacher() {
        Teacher teacher = new Teacher(
                8080,
                "John",
                "123456"
        );

        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {

            TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
            int lines = teacherMapper.insertTeacher(teacher);

            assertEquals(1, lines);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void deleteTeacherById() {
        Teacher teacher = new Teacher();
        teacher.setTid(8080);

        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {

            TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
            int lines = teacherMapper.deleteTeacherById(teacher);

            assertEquals(1, lines);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}