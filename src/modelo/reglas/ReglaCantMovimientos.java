/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.reglas;

import java.util.Vector;
import modelo.Modelo;

/**
 *
 * @author nick
 */
public class ReglaCantMovimientos implements IRegla {

    private Modelo modelo;

    public ReglaCantMovimientos(Modelo modelo) {
        this.modelo = modelo;
    }

    @Override

    public int comprobar() {
        int cantElementos = 0;
        for (String valor : modelo.getVecTablero()) {
            if (valor.compareTo(Modelo.ESTADOS[Modelo.VACIO]) != 0) {
                cantElementos++;
            }
        }
        if (cantElementos == modelo.getTamanio()) {
            return Modelo.TABLERO_LLENO;
        }
        return Modelo.TABLERO_NO_LLENO;
    }

    @Override
    public Vector<Integer> IndicesReglaAplicada() {
        Vector<Integer> indices = new Vector<>();
        for (int i = 0; i < modelo.getTamanio(); i++) {
            indices.add(i);
        }
        return indices;
    }

}
