package pract5;

import java.util.*;

/** VentaEntradas: clase "Programa" que usa la clase Entrada para, 
 *  a partir de datos leidos de teclado, crear una entrada de cine 
 *  y mostrar por pantalla su precio final.
 *  
 *  @author IIP
 *  @version Curso 2017/18
 */

public class VentaEntradas {
    public static void main(String [] args) {
        Scanner teclado = new Scanner(System.in).useLocale(Locale.US);
        
        // Lectura de los datos que caracterizan a la entrada a crear:
        System.out.println("Caracteristicas de la entrada: ");
        System.out.print("   Titulo: ");
        String t = teclado.nextLine();
        System.out.print("   Cine: ");
        String c = teclado.nextLine();
        System.out.print("   Hora: ");
        int h = teclado.nextInt();
        System.out.print("   Minutos: ");
        int m = teclado.nextInt(); 
        
        // Creacion de la entrada para la pelicula de titulo t,
        // que se proyecta en el cine c a partir de las h horas
        // y m minutos
        Entrada e = new Entrada(t,c,h,m);
    
        // Lectura de datos para determinar recargos y/o descuentos
        // que se deben aplicar para obtener el precio final de e.
        System.out.print("Edad? ");
        int edad = teclado.nextInt(); teclado.nextLine();
        
        // Las variables locales boolean se inicializan al 
        // valor por defecto del tipo (false); de esta forma,
        // el if posterior se simplifica (no necesita else)
        boolean diaEspectador = false, festivo = false, 
                vispera = false, esCliente = false;
        
        String respuesta;
        
        System.out.print("Es el dia del espectador? (SI/NO) ");
        respuesta = teclado.next().toUpperCase();
        if (respuesta.equals("SI")) { diaEspectador = true; }
        
        System.out.print("Es festivo? (SI/NO) ");
        respuesta = teclado.next().toUpperCase();
        if (respuesta.equals("SI")) { festivo = true; }
        
        System.out.print("Es la vispera de un festivo? (SI/NO) ");
        respuesta = teclado.next().toUpperCase();
        if (respuesta.equals("SI")) { vispera = true; }
        
        System.out.print("Es cliente? (SI/NO) ");
        respuesta = teclado.next().toUpperCase();
        if (respuesta.equals("SI")) { esCliente = true; }
        

        // Obtencion del precio final de e mediante la invocacion
        // al metodo precioFinal de la clase Entrada 
        double res = e.precioFinal(edad, diaEspectador, festivo, vispera, esCliente);
    
        // Se muestra por pantalla res, un valor con dos decimales 
        // como maximo
        System.out.println("El precio final de la entrada es: " 
                           + res + " euros");
    }
}