package application;

import model_dao.DaoFactory;
import model_dao.SellerDao;
import model_entities.Department;
import model_entities.Seller;

import java.util.Date;
import java.util.List;

public class Program {

    public static void main(String[]args){

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("=== Teste 1: findById ===");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("=== Teste 2: seller ByFindDepartment ===");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        for(Seller obj : list) {
            System.out.println(obj);
        }

        System.out.println("=== Teste 3: seller findAll ===");
        list = sellerDao.findAll();
        for(Seller obj : list) {
            System.out.println(obj);
        }

   }


}
