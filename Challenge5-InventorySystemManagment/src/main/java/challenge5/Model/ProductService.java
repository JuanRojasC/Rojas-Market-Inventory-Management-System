/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge5.Model;

import challenge5.Model.DAO.IDAO;
import challenge5.Model.DAO.Implement.ProductImplementation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author juand
 */
public class ProductService {

    // ATTRIBUTES
    private static ProductService instance;
    private IDAO productImplementation;

    // CONSTRUCTOR
    private ProductService() {
        this.productImplementation = ProductImplementation.getInstance();
    }

    public static ProductService getInstance() {
        if (instance == null) {
            instance = new ProductService();
        }
        return instance;
    }

    // ADD PRODUCT
    public Boolean addProduct(String name, Double price, Integer stock) {
        return productImplementation.save(new Product(name, price, stock));
    }

    // DELETE PRODUCT
    public Boolean deleteProduct(Integer code) {
        return productImplementation.delete(code);
    }

    // UPDATE PRODUCT
    public Boolean updateProduct(Integer code, String name, Double price, Integer stock) {
        return productImplementation.update(new Product(code, name, price, stock));
    }

    // CHECK THE EXISTS OF PRODUCT
    public Boolean checkProduct(Integer code) {
        if (getProduct(code) != null) {
            return true;
        }
        return false;
    }

    // FIND A RETURN A PRODUCT IF EXIST
    public Product getProduct(Integer code) {
        return (Product)productImplementation.find(code);
    }

    // GET THE PRODUCTS LIST
    public List getProductList() {
        return productImplementation.findAll();
    }

    // GENERATE REPORT
    public List generateReportList() {
        List productsList = getProductList();
        Product expensiveProducts[] = new Product[productsList.size()];
        Integer i = 0;
        for (Product product : (List<Product>) productsList) {
            expensiveProducts[i] = product;
            i++;
        }
        Arrays.sort(expensiveProducts, new CompareProduct());
        List<Product> list = new ArrayList<>();
        for (int x = 0; x < expensiveProducts.length && x < 3; x++) {
            list.add(expensiveProducts[x]);
        }
        return list;
    }
}
