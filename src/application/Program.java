package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		SellerDao sellerDao = DaoFactory.createSellerDao();
		System.out.println("=== TEST 1: seller findById ===");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		System.out.println("=== TEST 2: seller findByDepartment ===");
		List<Seller> list = new ArrayList<Seller>();
		list =  sellerDao.findByDepartment(new Department(2, "Electronics"));
		for (Seller seller2 : list) {
			System.out.println(seller2);
		}
		System.out.println("=== TEST 3: seller findAll ===");
		list =  sellerDao.findAll();
		for (Seller seller2 : list) {
			System.out.println(seller2);
		}
		
		System.out.println("=== TEST 4: seller insert ===");
		sellerDao.insert(new Seller(null, "Felipe", "felipe@gmail.com", sdf.parse("13/06/2000"), 3000.0, new Department(2, "Electronics")));
		
		System.out.println("=== TEST 5: seller update ===");
		seller = sellerDao.findById(1);
		seller.setName("Martha Waine");
		sellerDao.update(seller);
		System.out.println("Update completed");
		
	}

}
