package mapper;

import java.util.List;

import entity.Student;
import mapper.base.BaseMapper;

public interface StudentMapper extends BaseMapper {

	int queryStudentNum(Student student) throws Exception;

	List<Student> findStudentByColumn(Student student) throws Exception;

	List<Student> queryStudent(Student student) throws Exception;
}
