/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.reglas;

import java.util.Vector;
import modelo.IModelo;
import modelo.Modelo;

/**
 *
 * @author nick
 */
public class ReglaTresElementos implements IRegla {

    private Vector<Integer> vecIndices;
    private final int CANT_INDICES = 3;
    private Modelo modelo;

    public ReglaTresElementos(int ind1, int ind2, int ind3, Modelo modelo) {
        vecIndices = new Vector(CANT_INDICES);
        vecIndices.add(ind1);
        vecIndices.add(ind2);
        vecIndices.add(ind3);
        this.modelo = modelo;
    }

    @Override
    public int comprobar() {
        int jugadorX = 0, jugadorO = 0;
        for (Integer i : vecIndices) {
            if (modelo.getVecTablero().get(i).compareTo(Modelo.ESTADOS[Modelo.JUGADOR_O]) == 0) {

                jugadorO++;
            }
            if (modelo.getVecTablero().get(i).compareTo(Modelo.ESTADOS[Modelo.JUGADOR_X]) == 0) {
                jugadorX++;
            }
        }
        if (jugadorO == CANT_INDICES) {
            return Modelo.JUGADOR_O;
        } else if (jugadorX == CANT_INDICES) {
            return Modelo.JUGADOR_X;
        }
        return Modelo.TABLERO_NO_LLENO;
    }

    @Override
    public Vector<Integer> IndicesReglaAplicada() {
        return vecIndices;
    }

}
