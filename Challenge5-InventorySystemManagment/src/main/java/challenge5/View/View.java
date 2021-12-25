/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge5.View;

import javax.swing.JFrame;

/**
 * Interface implementada por todas las clase Views
 */
public interface View{
    
    public void close() throws Exception;
    public void initView() throws Exception;
    
}
