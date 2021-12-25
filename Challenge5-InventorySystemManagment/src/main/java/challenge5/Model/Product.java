/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge5.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 * @author juand
 */

@Table("productos")
public class Product{
    
    // ATTRIBUTES
    @Id
    @Column("codigo")
    private Integer code;
    
    @Column("nombre")
    private String name;
    
    @Column("precio")
    private Double price;
    
    @Column("inventario")
    private Integer stock;
    
    // CONSTRUCTOR PRODUCT
    public Product(Integer code, String name, Double price, Integer stock){
        this.code = code;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public Product(String name, Double price, Integer stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
    
    public Product(){
        
    }
    
    
    // GETTERS
    public Integer getCode(){
        return this.code;
    }
    
    public String getName(){
        return this.name;
    }
    
    public Double getPrice(){
        return this.price;
    }
    
    public Integer getStock(){
        return this.stock;
    }
    
    // SETTERS
    public void setCode(Integer code){
        this.code = code;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setPrice(Double price){
        this.price = price;
    }
    
    public void setStock(Integer stock){
        this.stock = stock;
    }
}
