import java.util.ArrayList;

/**
 * Clase PiezaCaballo hereda de Pieza.
 * @author Diego Calderón
 * @version 1.0
 */
public class PiezaCaballo extends Pieza{
    
    /**
     * Constructor de Clase
     * @param posX Posición Horizontal de la pieza.
     * @param posY Posición Vertical de la pieza.
     * @param color String con el color de la pieza.
     */
    public PiezaCaballo(int posX, int posY, String color ){
        super(new Posicion(posX, posY), color, "Caballo");
    }
    
    /**
     * Valida un Movimiento.
     * Evalua el tablero en busca de las posibles movimientos y busca si el 
     * movimiento se encuentra en el listado de los movimientos posibles.
     * @param tablero Tablero.
     * @param p Posicion
     * @return Verdadero o Falso.
     */
    @Override
    public boolean validarMovimiento(Tablero tablero , Posicion p){
        //super.printPosiciones(this.posiblesMovimientos(tablero));
        return super.validarMovimiento(this.posiblesMovimientos(tablero), p);
    }
    
    /**
     * Analiza los posibles movimientos que puede realizar el Caballo.
     * Evalua el tablero y busca los posibles movimientos que puede realizar 
     * tomando en cuenta que el Caballo puede saltar piezas y se mueve en L en 
     * cualquier dirección, ademas de tomar en cuenta las piezas del tablero que 
     * puedan bloquear sus movimientos. 
     * @param t Tablero.
     * @return Listado de Posiciones.
     */
    public ArrayList posiblesMovimientos(Tablero t){
        ArrayList<Posicion> posiciones = new ArrayList();
        // Horizontales
        for(int i =super.getPosX()-2; i<= super.getPosX()+2; i=i+4){
            if(i >= 0 && i < 8){
                for(int j=super.getPosY()-1; j<= super.getPosY()+1; j=j+2){
                    if(j > 0 && j < 8){
                        if(!(t.posicionBloqueada(this, i, j))){
                            posiciones.add(new Posicion(i, j));
                        }
                    }
                }
            }
        }
        // Verticales
        for(int i =super.getPosY()-2; i<= super.getPosY()+2; i=i+4){
            if(i >= 0 && i < 8){
                for(int j=super.getPosX()-1; j<= super.getPosX()+1; j=j+2){
                    if(j > 0 && j < 8){
                        if(!(t.posicionBloqueada(this, j, i))){
                            posiciones.add(new Posicion(j, i));
                        }
                    }
                }
            }
        }
        return posiciones;
    }
}
