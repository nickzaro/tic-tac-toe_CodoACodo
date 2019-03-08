/*
 Clase oyente que se encarga de las interacciones con la ventana principal 
 de la vista,apertura.
 */
package controlador;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class ControladorVentana implements WindowListener {

    private Controlador control;

    ControladorVentana(Controlador control) {
        this.control = control;
    }

    @Override
    public void windowActivated(WindowEvent e) {
        control.refrescarCambios(); // inicializar los controles del juego
        control.refrescarContadores();
    }

    @Override
    public void windowClosing(WindowEvent e) {
        
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }

}
