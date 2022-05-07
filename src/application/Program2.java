package application;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program2 {
	public static void main(String[] args){
	DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
	
	System.out.println("=== TEST 1: department findById ===");
	Department department = departmentDao.findById(3);
	System.out.println(department);
	
	System.out.println("=== TEST 3: department findAll ===");
	List<Department> list = new ArrayList<Department>();
	list =  departmentDao.findAll();
	for (Department department2 : list) {
		System.out.println(department2);
	}
	/*
	System.out.println("=== TEST 4: department insert ===");
	departmentDao.insert(new Department(null, "Music"));
	*/
	
	System.out.println("=== TEST 5: department update ===");
	department = departmentDao.findById(1);
	department.setName("TI");
	departmentDao.update(department);
	System.out.println("Update completed");
	
	System.out.println("=== TEST 6: department delete ===");
	departmentDao.deleteById(1);
	
	}
}
