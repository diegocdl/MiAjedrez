import java.util.ArrayList;

/**
 * Clase PiezaTorre hereda de Pieza.
 * @author Diego Calderón
 * @version 1.0
 */
public class PiezaTorre extends Pieza {
    
    /**
     * Constructor de Clase.
     * @param posX Posicion Horizontal de la Torre.
     * @param posY
     * @param color 
     */
    public PiezaTorre(int posX, int posY, String color ){
        super(new Posicion(posX, posY), color, "Torre");
    }

    /**
     * Valida un movimiento.
     * @param tablero Tablero.
     * @param p Posicion a la que se desea mover la torre.
     * @return Verdadero o Falso.
     */
    @Override
    public boolean validarMovimiento(Tablero tablero , Posicion p){
        super.printPosiciones(this.posiblesMovimientos(tablero));
        return super.validarMovimiento(this.posiblesMovimientos(tablero), p);
    }
    
    /**
     * Analiza los posibles movimientos que puede realizar la Torre.
     * Evalua el tablero y busca los posibles movimientos que puede realizar tomando en 
     * cuenta que la torre puede avanzar Horizontalmente y Verticalmente pero solo en una 
     * dirección sin limite de casillas, no puede saltar piezas,ademas de tomar en cuenta 
     * las piezas del tablero que puedan bloquear sus movimientos. 
     * @param tablero Tablero.
     * @return Listado de Posiciones.
     */
    public ArrayList posiblesMovimientos(Tablero tablero){
        ArrayList<Posicion> posiciones = new ArrayList();
// Busca los movimientos posibles hacia la derecha
        for(int i=super.getPosX()+1; i<8; i++){ 
            try{
                if(tablero.posicionBloqueada(this, i, super.getPosY())){
                    if(tablero.esPiezaContraria(this, i, super.getPosY())){
                        posiciones.add(new Posicion(i, super.getPosY()));
                    }
                    break;
                }else {
                    posiciones.add(new Posicion(i, super.getPosY()));
                }
            }catch(Exception e){}
        }
        // Busca los movimientos posibles hacia la izquierda
        for(int i=super.getPosX()-1; i>=0 ; i--){ 
            try{
                if(tablero.posicionBloqueada(this, i, super.getPosY())){
                    if(tablero.esPiezaContraria(this, i, super.getPosY())){
                        posiciones.add(new Posicion(i, super.getPosY()));
                    }
                    break;
                }else {
                    posiciones.add(new Posicion(i, super.getPosY()));
                }
            }catch(Exception e){}
        }
        // Busca los movimientos posibles hacia arriba
        for(int i=super.getPosY()+1; i<8; i++){ 
            try{
                if((tablero.posicionBloqueada(this, super.getPosX(), i))){
                    if((tablero.esPiezaContraria(this, super.getPosX(), i))){
                        posiciones.add(new Posicion(super.getPosX(), i));
                    }
                    break;
                }else {
                    posiciones.add(new Posicion(super.getPosX(), i));
                }
            }catch(Exception e){}
        }
        // Busca los movimientos posibles hacia abajo
        
        for(int i=super.getPosY()-1; i>=0; i--){ 
            try{
                if((tablero.posicionBloqueada(this, super.getPosX(), i))){
                    if((tablero.esPiezaContraria(this, super.getPosX(), i))){
                        posiciones.add(new Posicion(super.getPosX(), i));
                    }
                    break;
                }else {
                    posiciones.add(new Posicion(super.getPosX(), i));
                }
            }catch(Exception e){}
        }        return posiciones;
    }
}
