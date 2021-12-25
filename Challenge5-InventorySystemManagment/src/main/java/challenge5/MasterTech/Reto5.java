/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge5.MasterTech;

import challenge5.Model.CompareProduct;
import challenge5.Model.Product;
import challenge5.Model.ProductRepository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

/**
 * @author juand
 */
public class Reto5 {
}

/**
 * Interface usada para las implementaciones de las diferentes entidades
 * @author Juan David Rojas Cañizales
 */
interface IDAO <T> {
    
    public Boolean save(T t);
    public Boolean update(T t);
    public Boolean delete(Integer i);
    public T find(Integer i);
    public List<T> findAll();
    
}

/**
 * Implementacion de la entidad productos de la BD
 * @author Juan David Rojas Cañizales
 */
class ProductImplementation implements IDAO<Product> {

    // ATTRIBUTES
    private static final Logger logger = Logger.getLogger(String.valueOf(ProductImplementation.class));
    private static ProductImplementation instance;
    private ProductRepository repository;

    private ProductImplementation(ProductRepository repository) {
        this.repository = repository;
    }

    // CONSTRUCTOR USED FOR APPLY THE REPOSITORY
    public static ProductImplementation getInstance(ProductRepository repository) {
        if (instance == null) {
            instance = new ProductImplementation(repository);
        }
        return instance;
    }

    // CONSTRUCTOR USED FOR USE THE IMPLEMENTATION
    public static ProductImplementation getInstance() {
        if (instance == null) {
            instance = new ProductImplementation(null);
        }
        return instance;
    }

    @Override
    public Product find(Integer code) {
        try {
            Optional<Product> productOptional = repository.findById(code);
            Product product = productOptional.get();
            logger.info("El producto fue encontrado y retornado");
            return product;
        } catch (Exception e) {
            logger.info("Falla al buscar el producto con codigo " + code);
            return null;
        }
    }

    @Override
    public Boolean save(Product product) {
        try {
            repository.save(product);
            logger.info("Producto insertado correctamente");
            return true;
        } catch (Exception e) {
            logger.info("Fallo la insercion del producto a la Base de Datos");
            return false;
        }
    }

    @Override
    public Boolean update(Product product) {
        try {
            Optional<Product> produOptional = repository.findById(product.getCode());
            Product productFinded = produOptional.get();
            productFinded.setName(product.getName());
            productFinded.setPrice(product.getPrice());
            productFinded.setStock(product.getStock());
            repository.save(productFinded);
            logger.info("Producto actualizado correctamente");
            return true;
        } catch (Exception e) {
            logger.info("Fallo la actualizacion del producto");
            return true;
        }
    }

    @Override
    public Boolean delete(Integer code) {
        try {
            Optional<Product> productOptional = repository.findById(code);
            Product product = productOptional.get();
            repository.delete(product);
            logger.info("Producto eliminado exitosamente");
            return true;
        } catch (Exception e) {
            logger.info("Fallo la eliminacion del producto en la Base de Datos");
            return false;
        }
    }

    @Override
    public List<Product> findAll() {
        return (List) repository.findAll();
    }

}

/**
 * Servicio de la clase Producto que es el usado por los diferentes
 * controladores en el proyecto, y que a su vez se comunica con la implemntacion
 * para lanzar la query en la BD.
 * @author Juan David Rojas Cañizales
 */
class ProductService {

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