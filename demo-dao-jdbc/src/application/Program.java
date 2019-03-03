package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.dao.impl.DepartmentDaoJDBC;
import model.entities.Department;

public class Program {

	public static void main(String[] args) {

		SellerDao sellerDao = DaoFactory.createSellerDao();

		System.out.println("=== Teste 1: seller findById ===");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n=== Teste 2: seller findById ===");
        Department department = new Department(2,null);
		List<Seller> list =  sellerDao.findByDepartment(department);
		
		for (Seller obj: list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== Teste 3: seller findById ===");        
		list =  sellerDao.findAll();
		
		for (Seller obj: list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== Teste 4: seller insert ===");		
		
		Seller newSeller = new Seller(null, "Greg", "Greg@gmail.com", new Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id = "+ newSeller.getId());
		
		System.out.println("\n=== Teste 5: seller insert ===");	
		seller = sellerDao.findById(1);
		seller.setName("Martha Waine");
		sellerDao.update(seller);
		System.out.println("\n=== Update completed ===");
		
		System.out.println("\n=== Teste 5: department insert ===");	
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		Department newdep = new Department(null,"Desenvolvimento");
		departmentDao.insert(newdep);
		System.out.println("Inserted Department! new id = "+newdep.getId());
		
		System.out.println("\n=== Teste 6: department UPDATE ===");	
		newdep.setName("Dev");
		departmentDao.update(newdep);		
		
		List<Department> listDep = departmentDao.findAll();
		
		for (Department obj: listDep) {
			System.out.println(obj);			
		}		
		
	}
}
