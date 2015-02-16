import java.util.ArrayList;

/**
 * Clase PiezaReina(♕ ♛) **Hereda de Pieza**.
 * Esta clase contiene los metodos y atributos especificos para la Reina.
 * Posee los movimientos de la torre, del alfil y los del rey.
 * @author Diego Calderón
 * @version 1.0
 */
public class PiezaReina extends Pieza{
    
    /**
     * Constructro de Clase.
     * @param posX Posicion Horizontal(x) de la pieza.
     * @param posY Posicion Vertical(y) de la pieza.
     * @param color String con el color de la pieza.
     */
    public PiezaReina(int posX, int posY, String color ){
        super(new Posicion(posX, posY),  color, "Reina");
    }
    
    /**
     * Valida un movimiento.
     * @param t Tablero.
     * @param p Posicion a la que se desea mover la pieza.
     * @return Verdadero o Falso.
     */
    @Override
    public boolean validarMovimiento(Tablero t, Posicion p){
        return super.validarMovimiento(this.posiblesMovimientos(t), p);
    }
    
    /**
     * Analiza los posibles movimientos que puede realizar la Reina.
     * Evalua el tablero y busca los posibles movimientos que puede realizar tomando 
     * en cuenta que la reina puede moverse en diagonal, horizontal y verticalmente
     * a cualquier casilla y no puede saltar piezas, ademas de tomar en cuenta las 
     * piezas del tablero que puedan bloquear sus movimientos.
     * @param t Tablero.
     * @return Listado con los posibles movimientos.
     */
    @Override
    public ArrayList posiblesMovimientos(Tablero t){
        ArrayList<Posicion> posiciones = new ArrayList();
        /*
         * *** Movimientos Horizontales ***
         */
        // Busca los movimientos posibles hacia la derecha
        for(int i=super.getPosX()+1; i<8; i++){ 
            try{
                if(t.posicionBloqueada(this, i, super.getPosY())){
                    if(t.esPiezaContraria(this, i, super.getPosY())){
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
                if(t.posicionBloqueada(this, i, super.getPosY())){
                    if(t.esPiezaContraria(this, i, super.getPosY())){
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
                if((t.posicionBloqueada(this, super.getPosX(), i))){
                    if((t.esPiezaContraria(this, super.getPosX(), i))){
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
                if((t.posicionBloqueada(this, super.getPosX(), i))){
                    if((t.esPiezaContraria(this, super.getPosX(), i))){
                        posiciones.add(new Posicion(super.getPosX(), i));
                    }
                    break;
                }else {
                    posiciones.add(new Posicion(super.getPosX(), i));
                }
            }catch(Exception e){}
        }
        
        
        /*
         * ** Movimientos en Diagonales **
         */
        // Busca los movimientos posibles hacia la derecha y hacia arriba de la posicion de la pieza
        for (int i=1; i<8; i++){
            if(super.getPosX()+i <8 && super.getPosX()+i >=0 && super.getPosY()+i <8 && super.getPosY()+i >=0 ){
                try{
                    if(t.posicionBloqueada(this, super.getPosX() + i, super.getPosY() + i)){
                        if(t.esPiezaContraria(this, super.getPosX() + i, super.getPosY() + i)){
                            posiciones.add(new Posicion(super.getPosX() + i, super.getPosY() + i));
                        }
                        break;
                    }else {
                        posiciones.add(new Posicion(super.getPosX() + i, super.getPosY() + i));
                    }
                }catch(Exception e){}
            }
        }
        
        // Busca los movimientos posibles hacia la izquierda y hacia arriba de la posicion de la pieza
        for (int i=1; i<8; i++){
            if(super.getPosX()-i <8 && super.getPosX()-i >=0 && super.getPosY()+i <8 && super.getPosY()+i >=0 ){
                try{
                    if(t.posicionBloqueada(this, super.getPosX() - i, super.getPosY() + i)){
                        if(t.esPiezaContraria(this, super.getPosX() - i, super.getPosY() + i)){
                            posiciones.add(new Posicion(super.getPosX() - i, super.getPosY() + i));
                        }
                        break;
                    }else {
                        posiciones.add(new Posicion(super.getPosX() - i, super.getPosY() + i));
                    }
                }catch(Exception e){}
            }
        }
        
        // Busca los movimientos posibles hacia la derecha y hacia abajo de la posicion de la pieza
        for (int i=1; i<8; i++){
            if(super.getPosX()+i <8 && super.getPosX()+i >=0 && super.getPosY()-i <8 && super.getPosY()-i >=0 ){
                try{
                    if(t.posicionBloqueada(this, super.getPosX() + i, super.getPosY() - i)){
                        if(t.esPiezaContraria(this, super.getPosX() + i, super.getPosY() - i)){
                            posiciones.add(new Posicion(super.getPosX() + i, super.getPosY() - i));
                        }
                        break;
                    }else {
                        posiciones.add(new Posicion(super.getPosX() + i, super.getPosY() - i));
                    }
                }catch(Exception e){}
            }
        }
        
        // Busca los movimientos posibles hacia la izquierda y hacia abajo de la posicion de la pieza
        for (int i=1; i<8; i++){
            if(super.getPosX()-i <8 && super.getPosX()-i >=0 && super.getPosY()-i <8 && super.getPosY()-i >=0 ){
                try{
                    if(t.posicionBloqueada(this, super.getPosX() - i, super.getPosY() - i)){
                        if(t.esPiezaContraria(this, super.getPosX() - i, super.getPosY() - i)){
                            posiciones.add(new Posicion(super.getPosX() - i, super.getPosY() - i));
                        }
                        break;
                    }else {
                        posiciones.add(new Posicion(super.getPosX() - i, super.getPosY() - i));
                    }
                }catch(Exception e){}
            }
        }
        return posiciones;
    }
    
}
