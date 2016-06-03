package com.hiyond.dao.mapper;

import java.util.List;

import com.hiyond.dao.mapper.base.BaseMapper;

import entity.Student;

public interface StudentMapper extends BaseMapper {

	int queryStudentNum(Student student) throws Exception;

	List<Student> findStudentByColumn(Student student) throws Exception;

	List<Student> queryStudent(Student student) throws Exception;
}
