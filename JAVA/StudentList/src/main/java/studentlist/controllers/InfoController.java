package studentlist.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import studentlist.models.Info;
import studentlist.models.Student;
import studentlist.services.InfoServices;
import studentlist.services.StudentServices;

@Controller
@RequestMapping("")
public class InfoController {
	@Autowired
	private InfoServices infoService;
	@Autowired
	private StudentServices studentService;
	
	public InfoController(InfoServices infoService) {
		this.infoService = infoService;
		
	}
	@RequestMapping("/new/info")
	public String newInfo(@ModelAttribute("info")Info info, Model model) {
		List<Student> students = studentService.studentList();
		model.addAttribute("list", students);
		return "createInfo.jsp";
	}
	@RequestMapping("/create")
	public String createInfo(@Valid @ModelAttribute("info")Info info, BindingResult result) throws Exception {
		if(result.hasErrors()) {
			return"createInfo.jsp";
		}
		else {
			infoService.createInfo(info);
		}
		return "redirect:/dashboard";
	}

}
