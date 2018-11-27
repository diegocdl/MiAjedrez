import java.util.ArrayList;
import javax.swing.ImageIcon;
/**
 * Esta clase contiene los atributos y metodos basicos que posee cada pieza del Ajedrez.
 * @author Diego Calderón
 * @version 1.0
 */
public class Pieza {
    /** Color de la pieza. */
    private String color;
    
    /** Nombre de la pieza. */
    private String nombre;
    
    /** Posicion en la que se encuentra la pieza. */
    private Posicion posicion;
    
    /** Status de la pieza.
     * Contendra true indica que la pieza esta activa
     * false indica que la pieza fue comida por el oponente
     */
    private boolean activa;
    
    
    
    /**
     * Constructor de la clase
     * @param p Posicion del tablero en la que iniciara la pieza
     * @param color Color de la pieza
     * @param nombre Nombre de la pieza
     */
    public Pieza(Posicion p, String color, String nombre){
        this.setPosicion(p);
        this.setColor(color);
        this.setActiva(true);
        this.setNombre(nombre);
    }
    
    /**
     * Establece la pieza como activa o inactiva.
     * @param activa Valor booleano que indica si la pieza esta activa
     */
    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    /**
     * Devuelve la pocicion en la que se encuentra la pieza.
     * @return (Posicion) Posicion en la que se encuentra la pieza
     */
    public Posicion getPosicion() {
        return posicion;
    }
    
    /**
     * Establece una Posicion para la pieza.
     * @param posicion Posicion en la que se establece la pieza
     */
    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }
    
    /**
     * Devuelve el status de la pieza.
     * @return (boolean) estado de la pieza
     */
    public boolean isActiva() {
        return this.activa;
    }
    
    /**
     * Establece la posicion en el eje X(Horizontal).
     * @param pos Valor entero con la posición Horizontal de la pieza
     */
    public void setPosX(int pos){
        this.posicion.setPosX(pos);
    }
    
    /**
     * Devuelve la posicion Horizontal(x) de la pieza.
     * @return valor entero con la posición Horizontal
     */
    public int getPosX(){
        return this.getPosicion().getPosX();
    }
    
    /**
     * Establece la posicion Vertical(y) de la pieza.
     * @param pos Valor entero con la posición vertical de la pieza.
     */
    public void setPosY(int pos){
        this.posicion.setPosY(pos);
    }
    
    /**
     * Devuelve la posicion Vertical(y) de la pieza.
     * @return 
     */
    public int getPosY(){
        return this.getPosicion().getPosY();
    }
    
    /**
     * Establece el color de la pieza.
     * @param c String con el color de la pieza.
     */
    public void setColor(String c){
        this.color = c;
    }
    
    /**
     * Devuelve el color de la pieza.
     * @return String con el color de la pieza.
     */
    public String getColor(){
        return this.color;
    }

    /**
     * Devuelve el nombre de la pieza.
     * @return String con el nombre de la pieza.
     */
    public String getNombre() {
        return this.nombre;
    }
    
    /**
     * Establece el nombre de la pieza.
     * @param nombre String con el nombre de la pieza.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Mueve la pieza a una nueva posición.
     * @param p Posicion a la cual se movera la pieza.
     */
    public void mover(Posicion p){
        this.setPosicion(p);
    }
    
    /**
     * Valida si un movimiento es valido.
     * Compara todos los movimientos que puede tener una pieza y busca si el movimiento 
     * es posible retorna true si no retorna false.
     * @param p ArrayList con todas las Posiciones validas.
     * @param posDestino Posicion de destino para validar.
     * @return Verdadero si el movimiento es valido, falso si el movimiento es invalido.
     */
    public boolean validarMovimiento(ArrayList<Posicion> p , Posicion posDestino){
        for(int i=0; i< p.size(); i++){
            if(p.get(i).getPosX() == posDestino.getPosX() && p.get(i).getPosY()== posDestino.getPosY()){
                return true;
            }
        }
        return false;
    }
    
    /**
     * Valida si un movimiento es valido.
     * Este metodo se sobrescribe en las subclases.
     * @param tablero Tablero que contiene todas las piezas y jugadores 
     * @param p Posicion para validar
     * @return Verdadero si el movimiento es valido, falseo si el movimiento es invalido.
     */
    public boolean validarMovimiento(Tablero tablero , Posicion p){
        return false;
    }
    
    /**
     * Imprime Posiciones.
     * Imprime todo el Listado de Posciones que recibe como parametro
     * @param p Listado con Posiciones
     */
    public void printPosiciones(ArrayList<Posicion> p){
        System.out.println("Posicion actual x: " +this.getPosX() + " y:" + this.getPosY()+"\n");
        for(int i=0; i<p.size(); i++){
            System.out.println(" \t" + p.get(i).toString() +" (x:" + p.get(i).getPosX() + " y:" + p.get(i).getPosY() +")");
        }
    }
    
    
    public ArrayList posiblesMovimientos(Tablero t){
        return null;
    }

    public ImageIcon getIcon(){
        if(!nombre.equals("") && !color.equals("")){
                //return new ImageIcon("imagenes/"+nombre+color+".png");
                return new ImageIcon(getClass().getResource("imagenes/" +nombre+color+".png"));
                //return new ImageIcon(getClass().getResource("imagenes/AlfilBlanco.png"));
        }else{
            return new ImageIcon("AlfilBlanco.png");
        }
    }
}
