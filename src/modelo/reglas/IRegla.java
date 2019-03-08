/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.reglas;

import java.util.Vector;

/**
 *
 * @author nick
 */
public interface IRegla {
    public int comprobar();
    public Vector<Integer> IndicesReglaAplicada();
    
}
