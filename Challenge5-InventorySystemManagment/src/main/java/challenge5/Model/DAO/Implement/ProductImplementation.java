/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge5.Model.DAO.Implement;

import challenge5.Model.DAO.IDAO;
import challenge5.Model.Product;
import challenge5.Model.ProductRepository;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

/**
 *
 * @author juand
 */
public class ProductImplementation implements IDAO<Product> {

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
            logger.info("Fala al buscar el producto con codigo " + code);
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
