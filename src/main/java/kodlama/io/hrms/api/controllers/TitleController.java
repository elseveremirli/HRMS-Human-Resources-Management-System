package kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.TitleService;
import kodlama.io.hrms.entities.concretes.Title;

@RestController
@RequestMapping("/api/titles")
public class TitleController {

	private TitleService titleService;

	@Autowired
	public TitleController(TitleService titleService) {
		this.titleService = titleService;
	}
	
	
	@GetMapping("/getall")
	public List<Title> getAll(){
		return titleService.getAll();
	}
		
}
