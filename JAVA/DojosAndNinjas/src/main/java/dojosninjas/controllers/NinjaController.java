package dojosninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dojosninjas.models.Dojo;
import dojosninjas.models.Ninja;
import dojosninjas.services.DojoServices;
import dojosninjas.services.NinjaServices;

@Controller
@RequestMapping("")
public class NinjaController {
	@Autowired
	private NinjaServices ninjaService;
	@Autowired
	private DojoServices dojoService;
	
	public NinjaController(NinjaServices ninjaService) {
		this.ninjaService = ninjaService;
	}
	@RequestMapping("ninjas/new")
	public String newNinja(@ModelAttribute("ninja")Ninja ninja, Model model) {
		List<Dojo> dojos = dojoService.dojoList();
		model.addAttribute("dojos", dojos);
		return "newNinja.jsp";
	}
	@RequestMapping(path="/createN", method= {RequestMethod.POST})
	public String createNinja(@Valid @ModelAttribute("ninja")Ninja ninja, BindingResult result ) throws Exception {
		if(result.hasErrors()) {
			return "newNinja.jsp";
		}
		else {
			ninjaService.createNinja(ninja);
		}
		return"redirect:/info";
	}

}
