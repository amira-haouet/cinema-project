package org.sid.web;

import java.util.List;

import org.sid.entities.Scenariste;
import org.sid.services.ScenaristeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/scenariste/api")
@CrossOrigin
public class ScenaristeController {

	
	@Autowired
	ScenaristeService scenaristeService ;
	
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Scenariste> getAllSpecialite()
	{
		return scenaristeService.getAllSpecialite();
	}
	@RequestMapping(value="/{id}" , method=RequestMethod.GET)
	public Scenariste getSpecialiteById(@PathVariable("id")Long id)
	{
		return scenaristeService.getSpecialite(id);
	}
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public void deleteSpecialiteById(@PathVariable("id") Long id)
	{
		scenaristeService.deleteSpecialiteById(id);
	}
	@RequestMapping(method=RequestMethod.PUT)
	public Scenariste updateSpecialite(@RequestBody Scenariste s)
	{
		return scenaristeService.updateSpecialite(s);
	}
	@RequestMapping(method=RequestMethod.POST)
	public Scenariste saveSpecialite(@RequestBody Scenariste s)
	{
		return scenaristeService.saveSpecialite(s);
	}
	
	@GetMapping("/page")
	public Page<Scenariste> showPage(@RequestParam(name = "p", defaultValue="0") int page)
	{
		Page<Scenariste> p =  scenaristeService.getAllSpecialitePage(page, 3);
		return p;
	}
}
