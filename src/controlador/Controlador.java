/*
Controlador del Juego, encargado de asignar oyentes a la vista y manejar
funciones controlador generico 
 */
package controlador;

import java.awt.Color;
import modelo.Modelo;
import javax.swing.JButton;
import vista.Vista;

public final class Controlador {

    protected Vista vista;
    protected ControladorVentana controVentana;
    protected ControlNuevaPartida controlNuevaPartida;
    protected ControlReiniciar controlReiniciar;
    protected ControlBtnJuego controlBtnJuego;
    protected Modelo modelo;

    public Controlador(Vista vista, Modelo modelo) {
        this.vista = vista;
        this.modelo = modelo;
        this.controVentana = new ControladorVentana(this);
        this.controlNuevaPartida = new ControlNuevaPartida(this);
        this.controlReiniciar = new ControlReiniciar(this);
        this.controlBtnJuego = new ControlBtnJuego(this);
        agregarOyentes();
    }

    public Vista getVista() {
        return vista;
    }

    public Modelo getModelo() {
        return modelo;
    }

    private void agregarOyentes() {
        getVista().addWindowListener(controVentana);
        getVista().getBtnNuevaPartida().addActionListener(controlNuevaPartida);
        getVista().getBtnReiniciar().addActionListener(controlReiniciar);
        asignarOyentesTablero();
    }

    private void asignarOyentesTablero() {
        for (JButton btn : getVista().getBtnesTablero()) {
            btn.addActionListener(controlBtnJuego);
        }
    }

    public void refrescarCambios() {
        for (int i = 0; i < modelo.getTamanio(); i++) {
            vista.getBtnesTablero().get(i).setText(modelo.getVecTablero().get(i));
            if (modelo.getVecTablero().get(i).compareTo(Modelo.ESTADOS[Modelo.VACIO]) != 0) {
                // si el vector del modelo esta usado entonces deshabilito
                vista.getBtnesTablero().get(i).setEnabled(false);
            } else {
                // si no lo esta, entonces habilitado
                vista.getBtnesTablero().get(i).setEnabled(true);
                vista.getBtnesTablero().get(i).setBackground(null);
            }
        }
        // si alguien gano dehabilito los botones  y muestro la jugada
        int respuesta = modelo.hayganador();
        if (respuesta == Modelo.JUGADOR_O || respuesta == Modelo.JUGADOR_X || respuesta ==Modelo.TABLERO_LLENO) {
            deshabilitarTablero();
            mostrarJugada();            
        }  else {
            mostrarTruno();
        }   
    }

    private void deshabilitarTablero() {
        for (int i = 0; i < modelo.getTamanio(); i++) {
            vista.getBtnesTablero().get(i).setEnabled(false); // deshabilitar el tablero
        }
    }

    private void mostrarJugada() {
        for(Integer i:getModelo().getReglaDeterminante().IndicesReglaAplicada()){
            getVista().getBtnesTablero().get(i).setBackground(Color.LIGHT_GRAY);
        }
    }

    void refrescarContadores() {
        getVista().getTxtPuntosCruz().setText(getModelo().getGanadasX().toString());
        getVista().getTxtPuntosZero().setText(getModelo().getGanadasO().toString());
    }
    
    void mostrarTruno(){
        getVista().getLblTurno().setText(Modelo.ESTADOS[getModelo().getJugador()]);
    } 

    void estadisticas() {
        String salida = "Partidas ganadas por X: " + modelo.getGanadasX()
                + "\nParidas ganadas por O: " + modelo.getGanadasO() + "\nPartidas no ganadas: "
                + (modelo.getCantidadDePartidas() - modelo.getGanadasO() - modelo.getGanadasX())
                + "\nTotal de partidas jugadas: " + modelo.getCantidadDePartidas();
        vista.informar(salida);
    }
}
