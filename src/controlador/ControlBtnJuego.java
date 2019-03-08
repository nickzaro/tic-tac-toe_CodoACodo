/*
Clase oyente del tablero de juego
*/
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import modelo.Modelo;

public class ControlBtnJuego implements ActionListener {

    private Controlador control;

    public ControlBtnJuego(Controlador controlador) {
        this.control = controlador;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        control.getModelo().addNroMovimiento(Integer.valueOf(e.getActionCommand()));
        control.refrescarCambios();
        Integer estado = control.getModelo().estado();
        if (estado != Modelo.TABLERO_NO_LLENO) { // veo si alguien gano o termino la partida        
            control.getVista().informar("El ganador es: " + Modelo.ESTADOS[estado]);
            control.refrescarContadores();
        }
    }
}
