package application;

import model_dao.DaoFactory;
import model_dao.SellerDao;
import model_entities.Department;
import model_entities.Seller;


import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program {

    public static void main(String[]args)  {

        Scanner sc = new Scanner(System.in);

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("=== Test 1: findById ===");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("=== Test 2: seller ByFindDepartment ===");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        for(Seller obj : list) {
            System.out.println(obj);
        }

        System.out.println("=== Test 3: seller findAll ===");
        list = sellerDao.findAll();
        for(Seller obj : list) {
            System.out.println(obj);
        }

        System.out.println("=== Test 4: seller Insert ===");
        Seller newSeller = new Seller(
                null,
                "Carlos",
                "carlos@gmail.com",
                new Date(),
                4000.0,
                department);
        sellerDao.insert(newSeller);
        System.out.println("Insert! new id: " + newSeller.getId());

        System.out.println("=== Test 5: seller update ===");
        seller = sellerDao.findById(1);
        seller.setName("Bruce Wayne");
        sellerDao.update(seller);
        System.out.println("Update Completed");

        System.out.println("=== Test 6: seller delete ===");
        System.out.println("Enter id for delete test: ");
        int id = sc.nextInt();
        sellerDao.deleteById(id);
        System.out.println("id successfully deleted: " + id);

        sc.close();
   }
}
