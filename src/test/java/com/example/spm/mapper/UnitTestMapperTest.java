package com.example.spm.mapper;

import com.example.spm.model.Teacher;
import com.example.spm.model.UnitTest;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UnitTestMapperTest {
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

            UnitTestMapper unitTestMapper = sqlSession.getMapper(UnitTestMapper.class);
            List<UnitTest> unitTests = unitTestMapper.selectAll();

            for (UnitTest unitTest : unitTests) {
                System.out.println(unitTest.getSid());
                System.out.println(unitTest.getUnit1());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void selectById() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {

            UnitTestMapper unitTestMapper = sqlSession.getMapper(UnitTestMapper.class);
            UnitTest unitTest = unitTestMapper.selectById(26170223);

            System.out.println(unitTest.getSid());
            System.out.println(unitTest.getUnit1());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void insert() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {

            UnitTestMapper unitTestMapper = sqlSession.getMapper(UnitTestMapper.class);
            UnitTest unitTest = new UnitTest();
            unitTest.setSid(87654321);

            int lines = unitTestMapper.insert(unitTest);

            System.out.println(unitTest.getSid());
            System.out.println(lines);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void updateGradeById() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {

            UnitTestMapper unitTestMapper = sqlSession.getMapper(UnitTestMapper.class);
            UnitTest unitTest = new UnitTest();
            unitTest.setSid(26170223);
            unitTest.setUnit1(100);

            int lines = unitTestMapper.updateGradeById(unitTest);

            System.out.println(unitTest.getSid());
            System.out.println(lines);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}