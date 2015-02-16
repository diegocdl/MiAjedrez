import java.util.ArrayList;
/**
 * Clase PiezaRey hereda de Pieza
 * @author Diego Calderón
 * @version 1.0
 */
public class PiezaRey extends Pieza{
    
    /**
     * Constructor de Clase
     * @param posX Posicion Horizontal.
     * @param posY Posicion Vertical.
     * @param color String con el Color del Rey.
     */
    public PiezaRey(int posX, int posY, String color ){
        super(new Posicion(posX,  posY),  color, "Rey");
    }
    
    /**
     * Valida un movimiento.
     * Evalua el tablero en busca de las posibles movimientos y busca si el 
     * movimiento se encuentra en el listado de los movimientos posibles.
     * @param tablero
     * @param p
     * @return 
     */
    @Override
    public boolean validarMovimiento(Tablero tablero , Posicion p){
        super.printPosiciones(this.posiblesMovimientos(tablero));
        return super.validarMovimiento(this.posiblesMovimientos(tablero), p);
    }
    
    /**
     * Analiza los posibles movimientos que puede realizar el Rey.
     * Evalua el tablero y busca los posibles movimientos que puede realizar 
     * tomando en cuenta que el Rey puede avanzar un espacio en cualquier 
     * dirección, ademas de tomar en cuenta las piezas del tablero que puedan 
     * bloquear sus movimientos. 
     * @param tablero Tablero.
     * @return Listado de Posiciones.
     */
    @Override
    public ArrayList posiblesMovimientos(Tablero tablero){
        ArrayList<Posicion> posiciones = new ArrayList();
        for(int i=super.getPosX()-1; i<=super.getPosX()+1; i++){ // Filas
            for(int j=super.getPosY()-1; j<=super.getPosY()+1; j++){ // Columnas
                // Si la posicion no esta vacia
                if(i != super.getPosX() || j != super.getPosY()){
                    try{
                        // Verifico que las piezas no sean del mismo color
                        if(!(tablero.getPiezas()[tablero.getPiezaIndex(i, j)].getColor().equals(super.getColor()))){
                            posiciones.add(new Posicion(i, j)); 
                        }
                    }catch(Exception e){
                        posiciones.add(new Posicion(i, j));
                    }
                }
            }
        }
        return posiciones;
    }
    
}
