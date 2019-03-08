/*
 Clase que representa el modelo de la aplicacion, MVC
*/
package modelo;

import modelo.reglas.IRegla;
import modelo.reglas.ReglaTresElementos;
import java.util.Vector;
import modelo.reglas.ReglaCantMovimientos;

public class Modelo implements IModelo {

    private Integer cantidadDePartidas; // cantidad de partidas que se juega
    private Integer ganadasX; //cuantas partidas gano X
    private Integer ganadasO; //cuantas partidas gano Y
    private int tamanio;
    private Vector<String> vecTablero;   // representa el tablero de juego
    private Vector<IRegla> vecReglas;   // contiene las reglas del juego
    private IRegla reglaDeterminante;

    private int nroMovimiento;
    private String gano;

    public Modelo() {
        inicializarContadores();
        this.tamanio = Modelo.TAMANIO_TABLERO;
        vecTablero = new Vector();
        vecReglas = new Vector();
        cargarTablero();
        cargarReglas();
    }

    public void inicializarContadores() {
        gano = Modelo.ESTADOS[Modelo.VACIO];
        ganadasX = 0;
        ganadasO = 0;
        nroMovimiento=0;
        cantidadDePartidas = 0;
    }

    public Integer getCantidadDePartidas() {
        return cantidadDePartidas;
    }

    public Integer getGanadasX() {
        return ganadasX;
    }

    public Integer getGanadasO() {
        return ganadasO;
    }

    public int getTamanio() {
        return tamanio;
    }

    public Vector<String> getVecTablero() {
        return vecTablero;
    }

    public int getNroMovimiento() {
        return nroMovimiento;
    }

    public void addNroMovimiento(int i) {
        vecTablero.set(i, Modelo.ESTADOS[getJugador()]);
        nroMovimiento++;
    }

    public int getJugador() {
        return getNroMovimiento() % 2; // para asignar un jugador
    }

    private void cargarTablero() {
        for (int i = 0; i < tamanio; i++) {
            vecTablero.add(Modelo.ESTADOS[VACIO]);
        }
    }

    public void reiniciarPartida() {
        for (int i = 0; i < tamanio; i++) {
            vecTablero.set(i, Modelo.ESTADOS[VACIO]);
        }
        //nroMovimiento = 0;
        gano = Modelo.ESTADOS[Modelo.VACIO];
    }

    //podria poner otra combinacion para reglas L o T, creando otra clase que implemente
    // IRegla
    private void cargarReglas() {

        // reglas horizontales
        vecReglas.add(new ReglaTresElementos(0, 1, 2, this));
        vecReglas.add(new ReglaTresElementos(3, 4, 5, this));
        vecReglas.add(new ReglaTresElementos(6, 7, 8, this));

        // verticales
        vecReglas.add(new ReglaTresElementos(0, 3, 6, this));
        vecReglas.add(new ReglaTresElementos(1, 4, 7, this));
        vecReglas.add(new ReglaTresElementos(2, 5, 8, this));

        // reglas diagonales
        vecReglas.add(new ReglaTresElementos(0, 4, 8, this));
        vecReglas.add(new ReglaTresElementos(2, 4, 6, this));

        // esto va al ultimo, porque primero se comprueba que alguna regla de
        // posicion  se cumpla y al final la de llenado del tablero
        vecReglas.add(new ReglaCantMovimientos(this));
    }

    public int hayganador() {
        int respuesta = 0;
        for (IRegla regla : vecReglas) {
            respuesta = regla.comprobar();
            if (respuesta != Modelo.TABLERO_NO_LLENO) {
                reglaDeterminante=regla;
                break;
            }
        }
        return respuesta;
    }

    public int estado() {
        // solo entra a algun if y no a otro, saber si alguien gano
        int valor = hayganador();
        if (valor == Modelo.JUGADOR_O) {
            gano = Modelo.ESTADOS[Modelo.JUGADOR_O];
            ganadasO++;
            cantidadDePartidas++;
        }
        if (valor == Modelo.JUGADOR_X) {
            gano = Modelo.ESTADOS[Modelo.JUGADOR_X];
            ganadasX++;
            cantidadDePartidas++;
        }
        if (valor == Modelo.TABLERO_LLENO) {
            gano = Modelo.ESTADOS[Modelo.NADIE_GANO];
            cantidadDePartidas++;
            valor = Modelo.NADIE_GANO;
        }
        System.out.println("tablero: " + vecTablero);
        return valor;
    }

    public IRegla getReglaDeterminante() {
        return reglaDeterminante;
    }

    
}
