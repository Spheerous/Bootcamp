package dojooverflow.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import dojooverflow.models.Answer;
import dojooverflow.models.Question;
import dojooverflow.models.Tag;
import dojooverflow.services.AnswerServices;
import dojooverflow.services.QuestionServices;
import dojooverflow.services.TagServices;

@Controller
@RequestMapping("")
public class TagController {
	@Autowired
	@Lazy
	private TagServices tagService;
	@Autowired
	@Lazy
	private QuestionServices questService;
	@Autowired
	@Lazy
	private AnswerServices anwService;
	
	
	TagController(TagServices tagService, QuestionServices questService){
		this.questService = questService;
		this.tagService = tagService;
	}
	
	
	@GetMapping("home")
	public String home(Model model) {
		model.addAttribute("questions", questService.questionList());
		
		return"home.jsp";
	}
	@GetMapping("/new/question")
	public String newQuestion(@ModelAttribute("quest")Question question, Model model) {
		List<Tag> tags = tagService.tagList();
		model.addAttribute("tags", tags);
		return "newQuestion.jsp";
	}
	@PostMapping("create")
	public String createQuestion(@ModelAttribute("quest")Question question, BindingResult result) throws Exception {
		if(result.hasErrors()) {
			return "newQuestion.jsp";
		}
		else {
			questService.create(question);
		}
		return "redirect:/home";
	}
	@GetMapping("show/{id}")
	public String showQuestion(@PathVariable("id")long id, Model model,@ModelAttribute("ans")Answer answer) {
		Question check = questService.findQuestion(id);
			model.addAttribute("Question", check);
			model.addAttribute("answers", anwService.listaAnswers());
			return"showQuestion.jsp";

	}
	@PostMapping("create/answer")
	public String createAnswer(@Valid @ModelAttribute("ans")Answer answer, BindingResult result)throws Exception {
		Answer a = anwService.create(answer);
	return "redirect:/show/" + a.getQuestion().getId();
	}

}



