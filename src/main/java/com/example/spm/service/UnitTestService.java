package com.example.spm.service;

import com.example.spm.model.UnitTest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UnitTestService {
    List<UnitTest> findAll();

    UnitTest findById(int sid);

    int insert(UnitTest unitTest);

    int updateGradeById(UnitTest unitTest);
}
