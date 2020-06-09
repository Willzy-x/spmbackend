package com.example.spm.service.impl;

import com.example.spm.mapper.UnitTestMapper;
import com.example.spm.model.UnitTest;
import com.example.spm.service.UnitTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnitTestServiceImpl implements UnitTestService {

    private final UnitTestMapper unitTestMapper;

    public UnitTestServiceImpl(UnitTestMapper unitTestMapper) {
        this.unitTestMapper = unitTestMapper;
    }

    @Override
    public List<UnitTest> findAll() {
        return unitTestMapper.selectAll();
    }

    @Override
    public UnitTest findById(int sid) {
        return unitTestMapper.selectById(sid);
    }

    @Override
    public int insert(UnitTest unitTest) {
        return unitTestMapper.insert(unitTest);
    }

    @Override
    public int updateGradeById(UnitTest unitTest) {
        return unitTestMapper.updateGradeById(unitTest);
    }
}
