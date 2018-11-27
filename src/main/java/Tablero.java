import java.util.ArrayList;

/**
 * Clase Tablero.
 * El tablero contiene a los jugadores y las piezas ademas lleva el control de turnos.
 * @author Diego Calderón
 * @version 1.0
 */
public class Tablero {
    /** Jugador 1. */
    private Jugador j1;
    
    /** Jugador 2. */
    private Jugador j2;
    
    /** Piezas. */
    private Pieza[] piezas;
    
    /** Control del turno del Jugador 1. */
    private boolean turnoj1;
    
    /** Indica si el juego esta activo. */
    private boolean juegoActivo;
    
    /**
     * Constructor de Clase.
     * Se crean y establecen los dos jugadores, ademas se inicializa el arreglo 
     * que contiene las 32 piezas.
     * @param j1 String con el nombre del jugador 1.
     * @param j2 String con el nombre del jugador 2.
     */
    public Tablero(String j1, String j2){
        this.setJ1(new Jugador (j1, "Blanco"));
        this.setJ2(new Jugador (j2, "Negro"));
        piezas = new Pieza[32];
        this.setJuegoActivo(true);
        this.iniciarTablero();
        turnoj1 = true;
    }
    
    /**
     * Establece al Jugador 1.
     * @param j1 Jugador.
     */
    public void setJ1(Jugador j1){
        this.j1 = j1;
    }

    /**
     * Devuelve al Jugador 1.
     * @return Jugador 1.
     */
    public Jugador getJ1() {
        return j1;
    }
    
    /**
     * Establece al Jugador 2.
     * @param j2 Jugador.
     */
    public void setJ2(Jugador j2) {
        this.j2 = j2;
    }

    /**
     * Devuelve al Jugador 2.
     * @return Jugador.
     */
    public Jugador getJ2() {
        return j2;
    }
    
    /**
     * Establece el turno del jugador 1.
     * @param turno Boolean.
     */
    public void setTurnoj1(boolean turno){
        this.turnoj1 = turno;
    }
    
    /**
     * Devuelve verdadero si es el turno del Jugador 1.
     * @return Boolean.
     */
    public boolean isTurnoj1(){
        return this.turnoj1;
    }

    /**
     * Devuelve si el juego esta activo o finalizo.
     * @return Verdadero o Falso
     */
    public boolean isJuegoActivo() {
        return this.juegoActivo;
    }

    /**
     * Establece si el juego esta activo.
     * @param juegoActivo Boolean
     */
    public void setJuegoActivo(boolean juegoActivo) {
        this.juegoActivo = juegoActivo;
    }
    
    /**
     * Devuelve al Jugador que se encuentra en turno.
     * @return Jugador en turno.
     */
    public Jugador getJugadorTurno(){
        if(this.isTurnoj1()){
            return this.getJ1();
        }else{
            return this.getJ2();
        }
    }
    
    /**
     * Inicia el Tablero.
     * Coloca todas las piezas en su lugar.
     */
    public void iniciarTablero(){
        String color;
        int cont =0;
        for(int i=0; i<8; i++){ //filas (y)
            if(i== 0 || i == 1){
                color = j1.getColor();
            }else{
                color = j2.getColor();
            }
            for(int j=0; j<8; j++){ //columnas (x)
                if(i == 0 || i==7){
                    if(j== 0 || j == 7){
                        piezas[cont] = new PiezaTorre(j, i, color);
                    }else if(j == 1 || j == 6){
                        piezas[cont] = new PiezaCaballo(j, i, color);
                    }else if(j == 2 || j == 5){
                        piezas[cont] = new PiezaAlfil(j, i, color);
                    }else if(j == 3){
                        piezas[cont] = new PiezaReina(j, i, color);
                    }else if(j == 4){
                        piezas[cont] = new PiezaRey(j, i, color);
                    }
                    cont++;
                }else if(i == 1 || i == 6){
                    piezas[cont] = new PiezaPeon(j, i, color);
                    cont++;
                }
            }
        }
    }
    
    /**
     * Devuelve en String el Tablero.
     * Imprime el tablero en texto.
     * @return String del Tablero.
     */
    @Override
    public String toString(){
        String e = "|", res = "";
        int ancho = 0;

        for (int i = 7; i >=0 ; i--){ //recorre las filas (y)
            res += (i + 1) + " " + e +" ";
            for (int j = 0; j < 8; j++){ //recorre las ciolumnas (x)
                if(this.getPiezaIndex(j, i) != -1) {
                    res += piezas[this.getPiezaIndex(j, i)].getNombre().subSequence(0, 2) + "" + piezas[this.getPiezaIndex(j, i)].getColor().subSequence(0, 1) + " " + e + " ";
                }else {
                    res += "    " + e + " ";
                }//cada vez que se que cumplan las condiciones se sumará a la variable
            }
            res += "\n";
            if (i == 7) {
                ancho = res.length();
                res = "\n" + res;
                for (int h = 0; h < ancho ; h++) {
                    res = "-"+res;
                }
            }
            for (int h = 0; h < ancho ; h++) {
                res += "-";
            }
            res += "\n";
        }
        res = "    A     B     C     D     E     F     G     H \t\n" + res;
        return res;
    }

    /**
     * Mueve Piezas.
     * Verifica que la posicion de Inicio contenga una pieza para ser movida,
     * que sea del jugador en turno y que el movimiento sea valido, si hay una
     * pieza del jugador contrario en la posicion de destino esta sera "comida"
     * por ultimo se realiza el cambio de turno.
     * @param posInicio Posicion de la pieza que se movera.
     * @param posFinal Posicion a la que se desea mover.
     * @return Boolean.
     */
    public boolean mover(Posicion posInicio, Posicion posFinal){
        boolean result= false;
        // Si hay una pieza en la posición Inicial
        if(this.getPiezaIndex(posInicio) != -1){
            // Si la pieza es del color del jugador en turno
            if(this.getJugadorTurno().getColor().equals(this.piezas[this.getPiezaIndex(posInicio)].getColor())){
                // verifica que el movimiento sea valido
                if(this.getPiezas()[this.getPiezaIndex(posInicio)].validarMovimiento(this, posFinal)){
                    // veifica si hay una pieza en la posicion de destino 
                    if(this.getPiezaIndex(posFinal) != -1){
                        // si la pieza que este no es del color del jugador puede comerse la pieza
                        if(this.getJugadorTurno().getColor().equals(this.piezas[this.getPiezaIndex(posInicio)].getColor())){
                            this.comer(posFinal);
                        }
                    }
                    this.piezas[this.getPiezaIndex(posInicio)].mover(posFinal); // mueve la pieza
                    result = true;
                    if(this.isTurnoj1()){
                        this.setTurnoj1(false); // cambia al turno del jugador 2
                    }else{
                        this.setTurnoj1(true); // cambia al turno del jugador 1
                    }  
                }
            }
        }
        return result;
    }
    
    /**
     * Come una pieza.
     * Establece como inactiva la pieza comida.
     * @param p Posición.
     */
    public void comer(Posicion p){
        // Si la pieza a comer es un rey entonces termina el juego
        if(this.getPieza(p).getNombre().equals("Rey")){
            this.setJuegoActivo(false);
            if(this.isTurnoj1()){
                this.j1.addJuegoGanado();
            }else{
                this.j2.addJuegoGanado();
            }
        }
        this.piezas[this.getPiezaIndex(p)].setActiva(false);
    }
    
    public boolean estaEnJaque(Jugador jugador){
        //buscar al rey del jugador
        Pieza r = null;
        for(int i=0; i<this.getPiezas().length; i++){
            
            if(this.getPiezas()[i].getNombre().equals("Rey") && this.getPiezas()[i].getColor().equals(jugador.getColor())){
                System.out.print("Se encontro al rey");
                r = this.getPiezas()[i];
            }
        }
        // recorre las piezas y busca entre sus posibles movimientos 
        for(int i=0; i<this.getPiezas().length; i++){
            if(!(jugador.getColor().equals(this.getPiezas()[i].getColor()))){
                //System.out.println("ciclo " + i);
                ArrayList<Posicion> p = this.getPiezas()[i].posiblesMovimientos(this);
                for(int j=0; j<p.size(); j++){
                    //System.out.print("ciclo 2");
                    if(p.get(j).equals(r.getPosicion()) && this.getPiezas()[i].isActiva()){
                        System.out.print(this.getPiezas()[i].getNombre() + " - " + p.get(j).toString());
                        this.getPiezas()[i].printPosiciones(p);
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    
    /**
     * Mueve una pieza.
     * Recibe un String con la sintaxis "posPieza"-"posDestino".
     * @param movimiento String con el movimiento.
     * @return 
     */
    public boolean mover(String movimiento){
        movimiento = movimiento.toUpperCase();
        String pos[];
        pos = movimiento.split("-");
        if(movimiento.replace("-", "").length() == 4){
            try{
                return this.mover(new Posicion(pos[0]), new Posicion(pos[1]));
            }catch(Exception e){
                return false;
            }
        }else{
            return false;
        }
        
    }
    
    /**
     * Evalua si una posición esta Bloqueada por una pieza del mismo jugador.
     * @param p Pieza.
     * @param posX Posicion Horizontal
     * @param posY Posicion Vertical
     * @return Boolean.
     */
    public boolean posicionBloqueada(Pieza p, int posX, int posY){
        if(this.getPiezaIndex(posX, posY) != -1){
            if(!(this.getPieza(posX, posY).getColor().equals(p.getColor()))){
                return false;
            }
            return true;
        }else{
            return false;
        }
    }
    
    /**
     * Devuelve la posicion(int) en el arreglo de piezas.
     * @param p Posicion.
     * @return Entero con la posicion del arreglo de la pieza.
     */
    public int getPiezaIndex(Posicion p){
        int index=-1;
        for(int i=0; i<piezas.length; i++){
            if(piezas[i].getPosX() == p.getPosX() && piezas[i].getPosY() == p.getPosY()){
                if(piezas[i].isActiva()){
                    index = i;
                }
            }
        }
        return index;
    }
    
    /**
     * Devuelve la posicion en el arreglo de piezas.
     * @param posX Posicion Horizontal.
     * @param posY Posicion vertical.
     * @return Entero con la posicion del arreglo.
     */
    public int getPiezaIndex(int posX, int posY){
        return this.getPiezaIndex(new Posicion(posX, posY));
    }
    
    /**
     * Devuelve una pieza.
     * @param posX Posicion Horizontal.
     * @param posY Posicion Vertical.
     * @return Pieza.
     */
    public Pieza getPieza(int posX, int posY){
        return this.getPieza(new Posicion(posX, posY));
    }
    
    /**
     * Devuelve una pieza.
     * @param p Posicion.
     * @return Pieza.
     */
    public Pieza getPieza(Posicion p){
        if(this.getPiezaIndex(p) != -1){
            return this.getPiezas()[this.getPiezaIndex(p)];
        }else{
            return null;
        }
    }
    
    /**
     * Devuelve un Arreglo con las Piezas.
     * @return Arreglo de Pieza
     */
    public Pieza[] getPiezas() {
        return piezas;
    }

    /**
     * Establece el Arreglo de Piezas.
     * @param piezas  Arreglo de Piezas.
     */
    public void setPiezas(Pieza[] piezas) {
        this.piezas = piezas;
    }
    
    public Jugador getGanador(){
        if(this.isTurnoj1()){
            return this.getJ2();
        }else{
            return this.getJ1();
        }
    }

    public void nuevoJuego(){
        this.iniciarTablero();
        this.setTurnoj1(true);
        this.setJuegoActivo(true);
    }
    
    /**
     * Verifica si una pieza en una Posicion es Contraria.
     * 
     * @param p Pieza
     * @param posX Posicion Horizontal del espacio a verificar. 
     * @param posY Posicion Vertical del espacio a verificar.
     * @return true o false
     * @throws Exception 
     */
    public boolean esPiezaContraria(Pieza p, int posX, int posY) throws Exception{
        if(p.getPosX() != posX || p.getPosY() != posY){
            if(posX >= 0 && posX < 8 && posX >= 0 && posX < 8){
                if(!(this.getPieza(posX, posY).getColor().equals(p.getColor()))){
                    return true;
                }else{
                    return false;
                }
            }
        }
        throw new Exception();
    }
}
