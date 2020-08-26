package pract7;

import pract4.Instante;

import java.util.Scanner;
import java.util.Locale;
/** 
 *  Clase GestorParking: gestor de un parking.
 *  @author IIP
 *  @version Curso 2017/2018
 */
public class GestorParking {
    
    /**
     * Muestra un menu de opciones por pantalla y
     * lee desde teclado una opcion valida.
     * @param tec Scanner, representa el teclado.
     * @return int, opcion valida.
     */ 
    private static int menu(Scanner tec) {
        int op;
        do {
            System.out.println("\nGestor del parking");
            System.out.println("==================");
            System.out.println("1. Estacionar");
            System.out.println("2. Retirar");
            System.out.println("3. Buscar");
            System.out.println("4. Mostrar ocupacion");
            System.out.println("5. Vaciar parking");
            System.out.println("0. Salir");
            System.out.println();
            System.out.print("Elige una opcion: ");
            op = tec.nextInt();
        } while (op < 0 || op > 5);
        tec.nextLine();
        return op;
    }
  
    /**
     * Lectura desde teclado de un instante valido.
     * @param tec Scanner, representa el teclado.
     * @return Instante, hora valida.
     */
    private static Instante leerInstante(Scanner tec) {
        int h, m;
        do {
            System.out.println("Dame una hora valida:"); 
            System.out.print("  Horas: "); h = tec.nextInt();
            System.out.print("  Minutos: "); m = tec.nextInt();
        } while (h < 0 || h > 23 || m < 0 || m > 59);
        tec.nextLine();
        return new Instante(h, m);
    }
    
    /**
     * Lectura desde teclado de una matricula.
     * @param tec Scanner, representa el teclado.
     * @return String, la matricula.
     */
    private static String leerMatricula(Scanner tec) {
        System.out.print("Dame una matricula: "); 
        String mat = tec.nextLine();        
        return mat;
    }

    /**
     * Metodo principal.
     * @param args String[].     
     */
    public static void main(String [] args) {
        final String MSG_NO_ESTA = "El vehiculo no esta en el parking";
        final String MSG_SI_ESTA = "El vehiculo ya esta en el parking";
        final String MSG_LLENO = "No quedan plazas libres en el parking";
        
        Scanner tec = new Scanner(System.in).useLocale(Locale.US);
        // Parking p = new Parking(4, 0.015);
        Parking p = new Parking("parkingIIP.txt");
        int op, pref;
        String matricula;
        Instante h;
        Ticket t;

        do {
            op = menu(tec);
            switch(op) {
                case 1: // Estacionar
                    if (!p.estaLleno()) {                       
                        matricula = leerMatricula(tec);
                        t = p.buscarTicket(matricula);
                        if (t == null) {
                            h = leerInstante(tec);
                            do {
                                System.out.print("Dame una planta ");
                                System.out.print("de preferencia (0-");
                                System.out.print((p.getNumPlantas() - 1));
                                System.out.print("): ");
                                pref = tec.nextInt();
                            } while (pref < 0 || pref >= p.getNumPlantas());
                            t = new Ticket(matricula, h);
                            p.estacionar(t, pref);
                            System.out.println(t);
                        }
                        else { System.out.print(MSG_SI_ESTA); }
                    }
                    else { System.out.print(MSG_LLENO); }
                    break;
                    
                case 2: // Retirar                    
                    matricula = leerMatricula(tec);
                    t = p.buscarTicket(matricula);
                    if (t == null) { System.out.println(MSG_NO_ESTA); }
                    else {                        
                        do {
                            System.out.print("El vehiculo ha entrado a las ");
                            System.out.print(t.getEntrada());
                            System.out.print(" y debe salir "); 
                            System.out.println("despues de dicha hora.");
                            h = leerInstante(tec);
                        } while (t.getEntrada().aMinutos() >= h.aMinutos());
                        System.out.println(t);                        
                        System.out.printf(Locale.US, 
                            "Importe: %.2f euros\n", p.retirar(t, h));
                    }
                    break;
                    
                case 3: // Buscar                    
                    matricula = leerMatricula(tec);
                    t = p.buscarTicket(matricula);
                    if (t == null) { System.out.println(MSG_NO_ESTA); }
                    else { System.out.println(t); }
                    break;
                    
                case 4: // Mostrar ocupacion 
                    System.out.println(p);
                    break;
                    
                case 5: // Vaciar parking 
                    System.out.print("Paking vacio. Importe total restante: ");
                    System.out.printf(Locale.US, "%.2f\n", p.vaciarParking());
                    break;
                    
                case 0: // Acabar
                    System.out.println("Bye!"); 
                    break;
                    
                default: // Checkstyle
                    break;
            }
        } while (op != 0);
    }
}
