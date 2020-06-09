package com.example.spm.mapper;

import com.example.spm.model.UnitTest;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "unitTestMapper")
public interface UnitTestMapper {

    List<UnitTest> selectAll();

    UnitTest selectById(int sid);

    int insert(UnitTest unitTest);

    int updateGradeById(UnitTest unitTest);
}
