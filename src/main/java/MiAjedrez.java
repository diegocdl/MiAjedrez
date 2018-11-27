import java.util.Scanner;
/**
 * Clase MiAjedrez(Driver).
 * @author Diego Calderón
 * @version 1.0
 */
public class MiAjedrez {

    public static void main(String[] args) {
        new TableroGUI();
//        Scanner s = new Scanner(System.in);
//        String jugador1, jugador2;
//        int opcion;
//        System.out.print(" ¡¡BIENVENIDO AL JUEGO DE AJEDREZ!!\n");
//        System.out.print("-----------------------------------------\n ");
//        System.out.print("                    MENU                  \n");
//        opcion = 2;
//        while (opcion != 3){
//            System.out.print("1. Instrucciones\n");
//            System.out.print("2. Jugar \n");
//            System.out.print("3. Salir \n");
//            System.out.print("-----------------------------------------\n ");
//            System.out.print("Ingrese opcion (#)\n");
//            try{
//                opcion = s.nextInt();
//            }catch(Exception e){}
//            if(opcion == 1){
//                    System.out.print("INSTRUCCIONES\n");
//                    System.out.print("------------------------------------------------------------\n");
//                    System.out.print("! Para poder mover una pieza debe ingresar las coredenadas !\n");
//                    System.out.print("! de la pieza que desea mover, y con un guion(-) separa la !\n");
//                    System.out.print("! posicion  a la cual  se desea  mover.  Por  ejemplo      !\n");
//                    System.out.print("! H7-H5  quiere decir que me encuentro en la posicion H7 y !\n");
//                    System.out.print("! desea moverme a H5. (debe ingresar coordenadas correctas !\n");
//                    System.out.print("------------------------------------------------------------\n");
//            }else if(opcion ==2){
//                System.out.print(" JUGAR \n");
//                System.out.print(" Ingrese el nombre del primer jugador 1 \n");
//                jugador1 = "Diego";
//                System.out.print(" Ingrese el nombre del primer jugador 2 \n");
//                jugador2 = "Jose";
//                Tablero tablero = new Tablero(jugador1, jugador2);
//                    while(true){
//                        String movimiento;
//                        System.out.println();
//                        System.out.print(tablero.toString());
//                        if(tablero.isJuegoActivo()){
//                            if(tablero.estaEnJaque(tablero.getJ1())){
//                                System.out.println("El jugador: " + tablero.getJ1().getNombre() + " esta en Jaque.");
//                            }
//                            if(tablero.estaEnJaque(tablero.getJ2())){
//                                System.out.println("El jugador: " + tablero.getJ2().getNombre() + " esta en Jaque.");
//                            }
//                            System.out.print("TURNO DE "+ tablero.getJugadorTurno().getNombre()+"("+tablero.getJugadorTurno().getColor()+") : ");
//                            System.out.print("\n1. ingrese *SALIR* para salir juego o ingrese las coordenadas de la jugada: \n");
//                            System.out.print("Ingrese su movimiento: ");
//                            movimiento = s.nextLine();
//                            if(movimiento.equals("SALIR") || movimiento.equals("salir")){
//                                break;
//                            }else {
//                                if(!(tablero.mover(movimiento))){
//                                    System.out.println("    ¡¡Movimiento invalido!!     ");
//                                }
//                            }
//                        }else{
//                            System.out.println("El Juego ha terminado " +tablero.getGanador().getNombre() + " a ganado.");
//                            String nuevoJuego = s.nextLine();
//                            if("S".equals(nuevoJuego.toUpperCase())){
//                                tablero.nuevoJuego();
//                            }else{
//                                break;
//                            }
//                        }
//                    }
//            }else if (opcion ==3){
//                    System.out.print(" FIN DEL JUEGO ");
//                    break;
//            }
//        }
    }
}
