/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge5.Model.DAO;

import java.util.List;

/**
 * @author Juan David Rojas Cañizales
 */
public interface IDAO <T> {
    
    public Boolean save(T t);
    public Boolean update(T t);
    public Boolean delete(Integer i);
    public T find(Integer i);
    public List<T> findAll();
    
}

