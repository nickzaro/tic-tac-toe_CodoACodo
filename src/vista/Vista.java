package vista;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ComponentListener;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Vista extends JFrame {

    private final String TITULO_VENTANA = "Tres en raya";
    private final String INFORMACION = "Juego del TaTeTi o tres en raya"
            + "\nJuegue con precaución :)";
    private final int ANCHO_VENTANA = 800;
    private final int ALTO_VENTANA = 600;
    // medidas para el tablero
    private final int ANCHO_TABLERO = 500;
    private final int ALTO_TABLERO = 500;

    // texto para los componentes
    private final String textOPuntosX = "Puntos X";
    private final String textOPuntosO = "Puntos O";
    private final String textoNuevaPartida = "Nueva";
    private final String textoNuevaPartidaExplicado = "Inicia una nueva partida...";
    private final String textoReiniciar = "Reiniciar";
    private final String textoReiniciarExplicado = "Reinicia el juego y los scores a cero...";
    private final String textoTurno = "Es truno de:";
    private Dimension tamanio = new Dimension(ANCHO_TABLERO, ALTO_TABLERO);
    private final int GAP_HORIZONTAL = 90;
    private final int GAP_VERTICAL = 10;
    // cantidad de filas y columnas del tablero
    private final int FILAS = 3;
    private final int COLUMNAS = 3;
    private GroupLayout layGrupal;

    // para el jugador X
    private JLabel lblPuntosCruz;
    private JTextField txtPuntosCruz;

    // para el jugador O
    private JLabel lblPuntosZero;
    private JTextField txtPuntosZero;

    // botones de nueva partida y reiniciar
    private JButton btnNuevaPartida;
    private JButton btnReiniciar;
    private JPanel pnlTablero;
    private Vector<JButton> btnesTablero;
    private JLabel lblEsElTurno;
    private JLabel lblTurno;

    public Vista() {
        this.inicializarVentana();
        this.inicializarComponentes();
        this.configurarPosicionComponentes();
        this.mistrarInformacion();
        this.ver();
       
    }

    //inicializo la ventana principal
    private void inicializarVentana() {
        this.layGrupal = new GroupLayout(this.getContentPane());
        this.setLayout(layGrupal);   // grouplayout como layout de la vista                 
        this.setTitle(TITULO_VENTANA);
        this.setSize(ANCHO_VENTANA, ALTO_VENTANA);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // creo los objetos de los componentes a utilizar
    private void inicializarComponentes() {
        lblPuntosCruz = new JLabel(textOPuntosX);
        txtPuntosCruz = new JTextField(2);
        txtPuntosCruz.setEditable(false);
        lblPuntosZero = new JLabel(textOPuntosO);
        txtPuntosZero = new JTextField(2);
        txtPuntosZero.setEditable(false);
        btnNuevaPartida = new JButton(textoNuevaPartida);
        btnNuevaPartida.setToolTipText(textoNuevaPartidaExplicado);
        btnReiniciar = new JButton(textoReiniciar);
        btnReiniciar.setToolTipText(textoReiniciarExplicado);
        lblEsElTurno = new JLabel(textoTurno);
        lblTurno = new JLabel(textoTurno);
        inicializarTablero();

    }

    // inicializo el tablero
    private void inicializarTablero() {

        pnlTablero = new JPanel(new GridLayout(FILAS, COLUMNAS));
        pnlTablero.setSize(tamanio);
        pnlTablero.setMinimumSize(tamanio);
        pnlTablero.setMaximumSize(tamanio);
        btnesTablero = new Vector<>();
        for (Integer i = 0; i < FILAS * COLUMNAS; i++) {
            JButton btn = new JButton(i.toString());
            btn.setActionCommand(i.toString());
            pnlTablero.add(btn);
            btnesTablero.add(btn);
        }
    }

    private void ver() {
        this.setVisible(true);
    }

    // usando el GroupLayout para posicion de los componentes
    private void configurarPosicionComponentes() {
        this.layGrupal.setAutoCreateGaps(true);
        this.layGrupal.setAutoCreateContainerGaps(true);

        layGrupal.setHorizontalGroup(layGrupal.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addGroup(layGrupal.createSequentialGroup()
                        .addComponent(lblPuntosCruz)
                        .addComponent(txtPuntosCruz)
                        .addGap(GAP_HORIZONTAL)
                        .addComponent(lblEsElTurno)
                        .addGap(GAP_HORIZONTAL)
                        .addComponent(lblPuntosZero)
                        .addComponent(txtPuntosZero))
                .addGroup(layGrupal.createSequentialGroup()
                        .addComponent(btnNuevaPartida)
                        .addGap(GAP_HORIZONTAL)
                        .addComponent(lblTurno)
                        .addGap(GAP_HORIZONTAL)
                        .addComponent(btnReiniciar))
                .addGroup(layGrupal.createSequentialGroup()
                        .addComponent(pnlTablero))
        );
        layGrupal.setVerticalGroup(layGrupal.createSequentialGroup()
                .addGap(GAP_VERTICAL)
                .addGroup(layGrupal.createParallelGroup()
                        .addComponent(lblPuntosCruz)
                        .addComponent(txtPuntosCruz)
                        .addComponent(lblEsElTurno)
                        .addComponent(lblPuntosZero)
                        .addComponent(txtPuntosZero))
                .addGap(GAP_VERTICAL)
                .addGroup(layGrupal.createParallelGroup()
                        .addComponent(btnNuevaPartida)
                        .addComponent(lblTurno)
                        .addComponent(btnReiniciar))
                .addGroup(layGrupal.createParallelGroup()
                        .addComponent(pnlTablero))
        );
        layGrupal.linkSize(SwingConstants.HORIZONTAL, btnNuevaPartida, btnReiniciar);
        layGrupal.linkSize(SwingConstants.VERTICAL, btnNuevaPartida, btnReiniciar);
        // layGrupal.linkSize(SwingConstants.HORIZONTAL,pnlTablero);
        //layGrupal.linkSize(SwingConstants.VERTICAL, pnlTablero);
        pack();

    }

    public JTextField getTxtPuntosCruz() {
        return txtPuntosCruz;
    }

    public JTextField getTxtPuntosZero() {
        return txtPuntosZero;
    }

    public JButton getBtnNuevaPartida() {
        return btnNuevaPartida;
    }

    public Vector<JButton> getBtnesTablero() {
        return btnesTablero;
    }

    // para mostrar la info de acuerdo al caso.
    public void informar(String msj) {
        JOptionPane.showMessageDialog(this, msj);
       
    }

    public JButton getBtnReiniciar() {
        return btnReiniciar;
    }

    public JLabel getLblTurno() {
        return lblTurno;
    }

    private void mistrarInformacion() {
        informar(INFORMACION);
    }

}
