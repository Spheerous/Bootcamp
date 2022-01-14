package studentlist.servicesimp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import studentlist.models.Student;
import studentlist.repository.StudentRepository;
import studentlist.services.StudentServices;
@Service
public class StudentServicesimp implements StudentServices {
	
	@Autowired
	private StudentRepository studentRepo;
	@Override
	public List<Student> studentList() {
		return(List<Student>) studentRepo.findAll();
	}
	@Override
	public Student findStudent(long id) {
		Optional<Student> otp = studentRepo.findById(id);
		if(otp.isPresent()) {
			return otp.get();
		}
		return null;
	}
	@Override 
	public Student createStudent(Student student) throws Exception {
		try {
			Student s = studentRepo.save(student);
			return s;
		} catch(Exception a) {
			a.printStackTrace();
			throw a;
		}
	}

}
