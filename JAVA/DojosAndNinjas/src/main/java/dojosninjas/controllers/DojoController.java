package dojosninjas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dojosninjas.models.Dojo;
import dojosninjas.models.Ninja;
import dojosninjas.services.DojoServices;
import dojosninjas.services.NinjaServices;

@Controller
@RequestMapping("")
public class DojoController {
	@Autowired
	private DojoServices dojoService;
	@Autowired 
	private NinjaServices ninjaService;

	
	public DojoController(DojoServices dojoService, NinjaServices ninjaService) {
		this.dojoService = dojoService;
		this.ninjaService = ninjaService;
	
	}
	@RequestMapping(path="/info/", method= {RequestMethod.GET})
	public String infoDojos(Model model) {
		List<Dojo> dojos = dojoService.dojoList();
		model.addAttribute("dojos", dojos);
		return"index.jsp";
	}
	@RequestMapping("/dojo/new")
	public String newDojo(@ModelAttribute("dojo") Dojo dojito) {
		return "newDojo.jsp";
	}
	@RequestMapping(path="createD", method= {RequestMethod.POST})
	public String createDojo(@ModelAttribute("dojo") Dojo dojito, BindingResult result)throws Exception {
		if(result.hasErrors()) {
			return"newDojo.jsp";
		}
		else {
			dojoService.createDojo(dojito);
		}
		return "redirect:/index.jsp";
	}
	@RequestMapping(path="dojo/{id}", method= {RequestMethod.GET})
	public String showDojo(@PathVariable("id")long id,Model model) {
		List<Ninja> ninjas = ninjaService.ninjasbyDojo(id);
		model.addAttribute("list", ninjas);
		model.addAttribute("dojo", dojoService.findDojo(id));
		return"dojoProfile.jsp";
	}
	
}
