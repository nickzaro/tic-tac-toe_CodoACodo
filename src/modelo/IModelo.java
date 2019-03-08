/*
 Constantes usadas para definir las variables del juego
 */
package modelo;

public interface IModelo {

    public final int JUGADOR_X = 1;
    public final int JUGADOR_O = 0;
    public final int VACIO = 2;
    public final int NADIE_GANO = 3;
    public final String[] ESTADOS = {"O", "X", " ", "Nadie ganó"};
    public final int TABLERO_LLENO = 4;
    public final int TABLERO_VACIO = 5;
    public final int TABLERO_NO_LLENO = 6;
    public final int TAMANIO_TABLERO = 9;

}
