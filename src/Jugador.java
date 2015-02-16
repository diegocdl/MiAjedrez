/**
 * Esta clase contiene el nombre, color y cantidad de juegos ganados por un jugador.
 * @author Diego Calderón
 * @version 1.0
 */
public class Jugador {
    
    /** Contiene la cantidad de juegos que a ganado el jugador */
    private int juegosGanados;
    
    /** Contiene el nombre del jugador */
    private String nombre;
    
    /** Contiene el color que identificara al jugador durante el juego*/
    private String color;
    
    /**
     * Constructor de la Clase Jugador
     * @param nombre Nombre del Jugador
     * @param color Color que identificara al jugador
     */
    public Jugador(String nombre, String color){
        this.setNombre(nombre);
        this.setColor(color);
    }
    
    /**
     * Establece un valor al atributo nombre(Contiene el nombre del jugador).
     * @param nombre 
     */
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    /**
     * Devuelve el nombre del jugador
     * @return String con el nombre del Jugador
     */
    public String getNombre(){
        return this.nombre;
    }
    
    /**
     * Establece un color para el Jugador
     * @param color Color que identificara al jugador
     */
    public void setColor(String color){
        this.color = color;
    }
    
    /**
     * Devuelve el color de Jugador
     * @return String con el color del jugador
     */
    public String getColor(){
        return this.color;
    }
    
    /**
     * Establece el numero de juegos ganados por el Jugador
     * @param num cantidad de juegos ganados
     */
    public void setJuegosGanados(int num){
        this.juegosGanados = num;
    }
    
    /**
     * Devuelve la cantidad de juegos ganados por el Jugador
     * @return int cantidad de juegos Ganados
     */
    public int getJuegosGanados(){
        return this.juegosGanados;
    }
    
    /**
     * Aumenta en 1 el numero de Juegos ganados por el Jugador
     */
    public void addJuegoGanado(){
        this.setJuegosGanados(this.getJuegosGanados()+1);
    }
}
