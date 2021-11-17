
package tn.esprit.spring.service;

 
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.services.IEmployeService;
import tn.esprit.spring.services.EmployeServiceImpl;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)

public class EmployeServiceImplTest
{
	private static final Logger l = LogManager.getLogger(EmployeServiceImpl.class);
	

		@Autowired
		IEmployeService es; 
	
		@Test
		@Order(1)
		//size of list in Date base
		public void testretrieveAllEmploye() {
			List<Employe> listEmploye = es.retrieveAllEmploye(); 
			// if there are 7 employe in DB : 
			Assertions.assertEquals(2, listEmploye.size());
		
			
		}
		
		
		@Test
		@Order(2)
		//Ajouter les donnes 
		public void testAddEmploye() throws ParseException {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date d = dateFormat.parse("2015-03-23");
			Employe e = new Employe("Mzoughi","Mahdi", "mahdi.mzoughi@esprit.tn" ,"123456789" ,true, Role.INGENIEUR);
			
			Employe EmployeAdded = es.addEmploye(e); 
			Assertions.assertEquals(e.getNom(), EmployeAdded.getNom());
		}
	 
		@Test
		@Order(3)
		//modifier par ID
		public void testModifyEmploye() throws ParseException   {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date d = dateFormat.parse("2015-03-23");
			Employe e = new Employe(30,"Mzoughi1","Mahdi1", "mahdi.mzoughi@esprit.tn" ,"123456789" ,true, Role.INGENIEUR); 
			Employe EmployeUpdated  = es.updateEmploye(e); 
			Assertions.assertEquals(e.getId(), EmployeUpdated.getId());
		}
	
		@Test
		@Order(4)
		//afficher par ID
		public void testRetrieveEmploye() {
			Employe EmployeRetrieved = es.retrieveEmploye(31); 
			Assertions.assertEquals(31L, EmployeRetrieved.getId());
		}
		
		@Test
		@Order(5)
		//Supprimer Par ID
		public void testDeleteEmploye() {
		
			es.deleteEmploye(30);
			Assertions.assertNull(es.retrieveEmploye(30));
	
		}
		
		// 5 tests unitaires  
 
}





