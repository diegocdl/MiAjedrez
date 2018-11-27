/**
 * Clase Posición.
 * Almacena la posicion vertical(Y) y Horizontal(X).
 * @author Diego Calderón
 * @version 1.0
 */
public class Posicion {
    /** Posicion Horizontal. */
    private int posX;
    
    /** Posicion Vertical. */
    private int posY;
    
    /**
     * Constructor de Clase.
     * Recibe las posiciones horizontales y verticales en valores enteros.
     * @param posX Posicion Horizontal.
     * @param posY Posicion Vertical.
     */
    public Posicion(int posX, int posY){
        this.setPosX(posX);
        this.setPosY(posY);
    }
    
    /**
     * Constructor de Clase.
     * Recibe la posición como un valor String
     * @param pos String con posicion.
     */
    public Posicion(String pos) throws Exception{
        this.setPos(pos);
    }
    
    /**
     * Establece la posicion desde un String.
     * Convierte un String ej. D3 y establece la posicion Horizontal y Vertical.
     * @param pos String con posicion.
     */
    public void setPos(String pos) throws Exception{
        this.setPosX(this.toInteger(pos.substring(0, 1)));
        this.setPosY(Integer.parseInt(pos.substring(1, 2))-1);
        System.out.print(this.toString());
    }
    
    /**
     * Convierte la posicion a String.
     * @return String con la posicion
     */
    @Override
    public String toString(){
        String letras = "ABCDEFGH";
        return letras.substring(this.getPosX(), this.getPosX()+1) + (this.getPosY()+1);
    }

    /**
     * Devuelve la posicion Horizontal.
     * @return Posicion Horizontal.
     */
    public int getPosX() {
        return posX;
    }

    /**
     * Devuelve la posicion Vertical.
     * @return Posicion Vertical.
     */
    public int getPosY() {
        return posY;
    }

    /**
     * Establece la posicion Horizontal.
     * @param posX Posicion Horizontal.
     */
    public void setPosX(int posX) {
        this.posX = posX;
    }

    /**
     * Establece la posicion Vertical.
     * @param posY Posicion Vertical.
     */
    public void setPosY(int posY) {
        this.posY = posY;
    }
    
    /**
     * Convierte una letra a Entero.
     * @param letra String con una letra.
     * @return numero equivalente a la letra(la a tiene la posicion 0).
     */
    public int toInteger(String letra) throws Exception{
        String letras = "ABCDEFGH";
        for(int i=0; i<letras.length(); i++){
            if(letras.subSequence(i, i+1).equals(letra)){
                return i;
            }
        }
         throw new Exception(letra);
    }
    
    public boolean equals(Posicion p){
        if(this.getPosX() == p.getPosX() && this.getPosY() == p.getPosY()){
            return true;
        }else{
            return false;
        }
        
    }
}
