package org.sid.services;

import java.util.List;

import org.sid.entities.Scenariste;
import org.springframework.data.domain.Page;



public interface ScenaristeService {
	Scenariste saveSpecialite(Scenariste s);
	Scenariste updateSpecialite(Scenariste s);
	void deleteSpecialite(Scenariste s);
	void deleteSpecialiteById(Long id);
	Scenariste getSpecialite(Long id);
	List<Scenariste> getAllSpecialite();
	
	Page<Scenariste>  getAllSpecialitePage(int page , int size);
}
