
import java.util.ArrayList;

/**
 * Esta Clase PiezaPeon(♙ ♟) *hereda* de la clase Pieza.
 * El peon en su primer movimiento puede avanzar 2 espacio, luego puede avanzar 
 * solo 1 posición y solo puede comer en diagonal avanzando 1 espacio.
 * @author Diego Calderón
 * @version 1.0
 */
public class PiezaPeon extends Pieza {
    
    /** Controla si es el primer movimiento que realiza. */
    private boolean primerMovimiento;
    
    /** 
     * Posicion en la que se encontraba el peon al inicio del juego.
     * Servira para poder validar los movimientos ya que no puede retroceder.
     */
    private Posicion posInicial;
    
    /**
     * Constructor de la Clase.
     * @param posX Posicion Horizontal(x) de la peon.
     * @param posY Posicion Vertical(y) de la peon.
     * @param color String con el color de la peon.
     */
    public PiezaPeon(int posX, int posY, String color ){
        super(new Posicion(posX, posY),  color,  "Peon");
        this.setPosInicial(new Posicion(posX, posY));
        this.setPrimerMovimiento(true);
    }
    /**
     * Devuelve si es el primer movimiento del peon.
     * @return Verdadero o Falseo
     */
    public boolean isPrimerMovimiento() {
        return primerMovimiento;
    }
    
    /**
     * Establece si es el primer movimiento del peon.
     * @param primerMovimiento Boolean (Verdadero o Falso)
     */
    public void setPrimerMovimiento(boolean primerMovimiento) {
        this.primerMovimiento = primerMovimiento;
    }
    
    /**
     * Devuelve la posicion Inicial del Peon.
     * @return Posicion Inicial.
     */
    public Posicion getPosInicial() {
        return posInicial;
    }
    
    /**
     * Establece la posicion en la que se encontraba el Peon en la pieza de juego.
     * @param pos Posicion inicial.
     */
    public void setPosInicial(Posicion pos) {
        this.posInicial = pos;
    }
    
    /**
     * Valida un Movimiento.
     * @param tablero Tablero
     * @param p Posicion a la cual se desea mover el Peon.
     * @return Verdadero o Falso.
     */
    @Override
    public boolean validarMovimiento(Tablero tablero , Posicion p){
        // super.printPosiciones(this.posiblesMovimientos(tablero));
        return  super.validarMovimiento(this.posiblesMovimientos(tablero), p);
    }
    
    /**
     * Mueve el Peon.
     * Se sobrescribe el metodo de la super clase para cambiar el estado del atributo
     * primerMovimiento en false.
     * @param p Posicion a la que se desea mover al Peon.
     */
    @Override
    public void mover(Posicion p){
        super.mover(p);
        this.setPrimerMovimiento(false);
    }
    
    /**
     * Analiza los posibles movimientos que puede realizar el Peon.
     * Evalua el tablero y busca los posibles movimientos que puede realizar tomando en
     * cuenta que el peon solo puede avanzar un espacio excepto en su primer movimiento
     * que puede avanzar dos espacios, solo puede comer avanzando en diagonal un espacio
     * ademas de tomar en cuenta las piezas del tablero que puedan bloquear sus movimientos.
     * @param t Tablero.
     * @return Listado con los movimientos que puede realizar.
     */
    public ArrayList posiblesMovimientos(Tablero t){
        ArrayList<Posicion> posiciones = new ArrayList();
        try{
            // si inicio en la posY 6 entonces avanzara restando a posY
            if(this.getPosInicial().getPosY() == 6){
                // Si el espacio de adelante esta vacio
                for(int i=super.getPosX()-1; i<= super.getPosX()+1; i++){
                    // Si esta entre los espacios del tablero
                    if(i>= 0 && i<8){
                        // Si el espacio de adelante esta vacio
                        if(t.getPiezaIndex(i, super.getPosY()-1) == -1){
                            if(super.getPosX() == i){
                                posiciones.add(new Posicion(i, super.getPosY()-1));
                            }
                        }else if(i != super.getPosX() && !(t.getPieza(i, super.getPosY()-1).getColor().equals(super.getColor()))){
                            posiciones.add(new Posicion(i, super.getPosY()-1));
                        }
                    }
                }
                if(this.isPrimerMovimiento() == true && t.getPiezaIndex(super.getPosX(), super.getPosY()-2) == -1){
                    posiciones.add(new Posicion(super.getPosX(), super.getPosY()-2));
                }
            }else{
                // Si la casilla de adelante esta vacia
                for(int i=super.getPosX()-1; i<= super.getPosX()+1; i++){
                    if(i>= 0 && i<8){
                        if(t.getPiezaIndex(i, super.getPosY()+1) == -1){
                            if(super.getPosX() == i){
                                posiciones.add(new Posicion(i, super.getPosY()+1));
                            }
                        }else if(i != super.getPosX() && !(t.getPieza(i, super.getPosY()+1).getColor().equals(super.getColor()))){
                            posiciones.add(new Posicion(i, super.getPosY()+1));
                        }
                    }
                }
                if(this.isPrimerMovimiento() == true && t.getPiezaIndex(super.getPosX(), super.getPosY()+2) == -1){
                    posiciones.add(new Posicion(super.getPosX(), super.getPosY()+2));
                }
            }
        }catch(Exception e){
            
        }
        return posiciones;
    }
}
