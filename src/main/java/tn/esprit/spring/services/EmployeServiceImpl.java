package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Employe;

import tn.esprit.spring.repository.EmployeRepository;

@Service
public class EmployeServiceImpl implements IEmployeService {

	@Autowired
	EmployeRepository employeRepository;

	private static final Logger l = LogManager.getLogger(EmployeServiceImpl.class);



	
	
	@Override
	public List<Employe> retrieveAllEmploye() { 
		List<Employe> employes = null; 
		try {
	
			l.info("In retrieveAllUsers() : ");
			employes = (List<Employe>) employeRepository.findAll();  
			for (Employe employe : employes) {
				l.debug("user +++ : " + employe);
			} 
			l.info("Out of retrieveAllUsers() : ");
		}catch (Exception e) {
			l.error("Error in retrieveAllUsers() : " + e);
		}

		return employes;
	}


	@Override
	public Employe addEmploye(Employe u) {
		return employeRepository.save(u); 
	}

	@Override 
	public Employe updateEmploye(Employe u) { 
		return employeRepository.save(u);
	}

	@Override
	public void deleteEmploye(int id) {
		employeRepository.deleteById(id);
	}

	@Override
	public Employe retrieveEmploye(int id) {
		Employe u = null;
		try{
			//l.info("in  retrieveUser id = " + id);
			//User u =  userRepository.findById(Long.parseLong(id)).orElse(null);
			u =  employeRepository.findById(id).get(); 
			l.info("user returned : " + u);

		}catch (Exception e) {
			// TODO: handle exception
			l.error("error in retrieveUser() : "+e);
		}
		return u; 

	}

}
