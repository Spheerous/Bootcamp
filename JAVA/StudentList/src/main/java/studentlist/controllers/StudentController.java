package studentlist.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import studentlist.models.Student;
import studentlist.services.StudentServices;

@Controller
@RequestMapping("")
public class StudentController {
	@Autowired
	private StudentServices studentService;
	
	public StudentController(StudentServices studentService) {
		this.studentService = studentService;
	}
	@RequestMapping(path="dashboard")
	public String dashboard(Model model){
		List<Student> student = studentService.studentList();
		model.addAttribute("student", student);
		return"dashboard.jsp";
	}
	@RequestMapping("new/student")
	public String newStudent(@ModelAttribute("student")Student student) {
		return"createStudent.jsp";
	}
	@RequestMapping(path="/student", method = {RequestMethod.POST})
	public String createStudent(@Valid @ModelAttribute("student")Student student, BindingResult result) throws Exception {
		if(result.hasErrors()) {
			return"createStudent.jsp";
		}
		else {
			studentService.createStudent(student);
		}
		return "redirect:/dashboard";
	}
//	@RequestMapping("/student/{id}")
//	public String profile(@PathVariable("id") long id, Model model)
//	{
//		Student student = studentService.findStudent(id);
//		if(student!=null) {
//			model.addAttribute("info")
//		}
//	}
}
