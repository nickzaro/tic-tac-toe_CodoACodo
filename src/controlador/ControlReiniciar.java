/*
 Clase oyente del boton "Reiniciar"
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlReiniciar implements ActionListener {

    private Controlador control;

    public ControlReiniciar(Controlador control) {
        this.control = control;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        control.estadisticas(); // imprimir estadisticas antes de reiniciar el juego
        control.getModelo().inicializarContadores(); // contadores a 0
        control.getModelo().reiniciarPartida(); 
        control.refrescarCambios();
        control.refrescarContadores();
    }

}
