package studentlist.services;

import java.util.List;

import org.springframework.stereotype.Service;

import studentlist.models.Student;

@Service
public interface StudentServices {

	List<Student> studentList();

	Student findStudent(long id);

	Student createStudent(Student student) throws Exception;

}
