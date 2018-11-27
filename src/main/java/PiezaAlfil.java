import java.util.ArrayList;

/**
 * Clase PiezaAlfil(♗ ♝) **Hereda Pieza**.
 * Esta clase contiene los metodos y atributos especificos para el Alfil.
 * El alfil se mueve siempre en diagonal, sin límite de casillas y tanto 
 * hacia adelante como hacia atrás.
 * @author Diego Calderón
 * @version 1.0
 */
public class PiezaAlfil extends Pieza{
    
    /**
     * Constructor de Clase.
     * @param posX Entero con la posicion Horizontal de la pieza.
     * @param posY Entero con la posicion Vertical de la pieza.
     * @param color String con el color de la pieza.
     */
    public PiezaAlfil(int posX, int posY, String color ){
        super(new Posicion(posX, posY),  color, "Alfil");
    }
    
    /**
     * Validación de movimientos del Alfil.
     * @param tablero Tablero con las piezas
     * @param p Posicion a validar.
     * @return Verdadero o Falso.
     */
    @Override
    public boolean validarMovimiento(Tablero tablero , Posicion p){
        this.printPosiciones(this.posiblesMovimientos(tablero));
        return super.validarMovimiento(this.posiblesMovimientos(tablero), p);
    }
    
    /**
     * Evalua los posibles movimientos que pueden realizar.
     * Evalua el tablero y busca los posibles movimientos que puede realizar tomando 
     * en cuenta que el alfil puede moverse en diagonal a cualquier casilla y no puede 
     * saltar piezas, ademas de tomar en cuenta las piezas del tablero que puedan 
     * bloquear sus movimientos.
     * @param t Tablero.
     * @return Listado con las posiciones que puede realizar el Alfil.
     */
    @Override
    public ArrayList posiblesMovimientos(Tablero t){
        ArrayList<Posicion> posiciones = new ArrayList();
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
