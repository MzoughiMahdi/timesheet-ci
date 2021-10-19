package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Employe;

public interface IEmployeService { 
	 
	List<Employe> retrieveAllEmploye(); 
	Employe addEmploye(Employe e);
	void deleteEmploye(int id);
	Employe updateEmploye(Employe e);
	Employe retrieveEmploye(int id);

} 
 