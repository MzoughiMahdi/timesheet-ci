
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
		public void testretrieveAllEmploye() {
			List<Employe> listEmploye = es.retrieveAllEmploye(); 
			// if there are 7 employe in DB : 
			Assertions.assertEquals(5, listEmploye.size());
		
			
		}
		
		
		@Test
		@Order(2)
		public void testAddEmploye() throws ParseException {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date d = dateFormat.parse("2015-03-23");
			Employe e = new Employe("Mzoughi","Mahdi", "mahdi.mzoughi@esprit.tn" ,"123456789" ,true, Role.INGENIEUR);
			
			Employe EmployeAdded = es.addEmploye(e); 
			Assertions.assertEquals(e.getNom(), EmployeAdded.getNom());
		}
	 
		@Test
		@Order(3)
		public void testModifyEmploye() throws ParseException   {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date d = dateFormat.parse("2015-03-23");
			Employe e = new Employe(1,"Mzoughi1","Mahdi1", "mahdi.mzoughi@esprit.tn" ,"123456789" ,true, Role.INGENIEUR); 
			Employe EmployeUpdated  = es.updateEmploye(e); 
			Assertions.assertEquals(e.getId(), EmployeUpdated.getId());
		}
	
		@Test
		@Order(4)
		public void testRetrieveEmploye() {
			Employe EmployeRetrieved = es.retrieveEmploye(3); 
			Assertions.assertEquals(3L, EmployeRetrieved.getId());
		}
		
		@Test
		@Order(5)
		public void testDeleteEmploye() {
		
			es.deleteEmploye(14);
			Assertions.assertNull(es.retrieveEmploye(14));
	
		}
		
		// 5 tests unitaires  
 
}





