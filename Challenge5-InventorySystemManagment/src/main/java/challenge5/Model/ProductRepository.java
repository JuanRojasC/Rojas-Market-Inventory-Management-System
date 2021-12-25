/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge5.Model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Juan David Rojas Cañizales
 * Interface que se encarga de establecer la conexion con la DB
 */
@Repository
public interface ProductRepository extends CrudRepository<Product, Integer>{
    
}
