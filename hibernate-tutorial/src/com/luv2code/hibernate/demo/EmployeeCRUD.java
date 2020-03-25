package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Employee;

public class EmployeeCRUD {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(Employee.class)
			.buildSessionFactory();
		
		try {
			
			// CREATE EMPLOYEE
			
				Session session = factory.getCurrentSession();
				
				session.beginTransaction();
				Employee employee = new Employee("Matias", "Fernandez", "Globant");
				session.save(employee);
				System.out.println("Create Employee: " + employee);
				
				session.getTransaction().commit();
				
			// RETRIEVE EMPLOYEE
				
				session = factory.getCurrentSession();
				
				session.beginTransaction();
				Employee employeeInDB = session.get(Employee.class, employee.getId());
				System.out.println("Get Employee: " + employeeInDB);
				
				session.getTransaction().commit();
				
			// RETRIEVE EMPLOYEES (QUERY)
				
				session = factory.getCurrentSession();
				
				session.beginTransaction();
				List<Employee> globers = session.createQuery("from Employee where "
						+ " company='Globant'").getResultList();
				for (Employee glober : globers) {
					System.out.println(glober);
				}
				
				session.getTransaction().commit();
				
			// UPDATE EMPLOYEE
				
				session = factory.getCurrentSession();
				
				session.beginTransaction();
				Employee employeeInDBtoUpdate = session.get(Employee.class, employee.getId());
				employeeInDBtoUpdate.setCompany("Workia");
				System.out.println("Update Employee: " + employeeInDBtoUpdate);
				
				session.getTransaction().commit();
				
			// DELETE EMPLOYEE
				
				session = factory.getCurrentSession();
				
				session.beginTransaction();
				Employee employeeInDBtoDelete = session.get(Employee.class, employee.getId());
				session.delete(employeeInDBtoDelete);
				
				session.getTransaction().commit();
				
		}
		finally {
			factory.close();
		}
	}

}
