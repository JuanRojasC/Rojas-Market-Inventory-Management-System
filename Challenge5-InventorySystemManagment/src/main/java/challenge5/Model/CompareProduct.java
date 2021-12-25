/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge5.Model;

import java.util.Comparator;

/**
 *
 * @author juand
 */
public class CompareProduct implements Comparator<Product>{
    
    public int compare(Product a, Product b){
        if(a == null) return 1;
        if(b == null) return -1;
        if(b.getPrice() > a.getPrice()) return 1;
        return -1;
    }
}
