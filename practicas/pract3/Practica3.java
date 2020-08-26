package pract3;

import java.util.Scanner;
/**
 *  Clase Practica3.
 *  Una primera clase con lectura de datos desde teclado, 
 *  y uso de operaciones con int, long, Math y String.
 *  Contiene tres errores de compilacion.
 *  @author IIP 
 *  @version Curso 2017-18
 */
public class Practica3  {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Lectura de teclado de una hora.");
        System.out.print("   -> Introduzca las horas (entre 0 y 23): ");
        int h = teclado.nextInt();
        System.out.print("   -> Introduzca los minutos (entre 0 y 59): ");
        int m = teclado.nextInt();
        String hh = "0" + h;
        hh = hh.substring(hh.length()-2);
        
        String mm = "0" + m;
        mm = mm.substring(mm.length()-2);
        
        //cálculo de hora UTC
        long tMinTotal = System.currentTimeMillis() / (60 * 1000);
        int tMinActual = (int) (tMinTotal % (24 * 60));
        
        //Hora y minuto
        int hA = (tMinActual / 60);
        int mA = (tMinActual % 60); 
        
        String hhA = "0" + hA;
        hhA = hhA.substring(hhA.length()-2);
        
        String mmA = "0" + mA;
        mmA = mmA.substring(mmA.length()-2);
        
        int mintot = h*60 + m;
        int difmintot = Math.abs(tMinActual-mintot);
        
        System.out.println("Hora introducida: " + hh + ":" + mm);   
        System.out.println("Hora actual: " + hhA + ":" + mmA + "(Tiempo UTC)");
        System.out.println("La diferencia en minutos entre ambas horas: " + difmintot +" (" + difmintot / 60 + " horas y "+ difmintot % 60 + " minutos)");
        
    }    
 
}