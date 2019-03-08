/*
 Clase oyente del boton "Nueva partida"
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlNuevaPartida implements ActionListener {

    private Controlador control;

    ControlNuevaPartida(Controlador control) {
        this.control = control;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        control.getModelo().reiniciarPartida();
        control.refrescarCambios();
    }

}
