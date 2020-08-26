

package pract7;

import pract4.Instante;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;
/** Clase Parking: representa la ocupacion de las plantas de un parking 
 *  junto con la tarifa en euros por minuto.
 *  @author IIP
 *  @version Curso 2017/2018
 */
public class Parking {
    /** Numero de plazas por planta. */
    public static final int PLAZAS_X_PLANTA = 5;
    // Definicion de atributos de instancia
    /* COMPLETAR */
    private Planta[] plantas;
    private double tarifa;// €/min 

    /** Crea un parking a partir del numero de plantas 
     *  y la tarifa en euros por minuto.
     *  El parking, al comienzo, esta vacio.
     *  @param numPlt int, el numero de plantas, numPlt > 0.      
     *  @param tf double, la tarifa en euros por minuto, tf > 0.
     */
    /* COMPLETAR */
    public Parking(int NumPlantas, double t){
        tarifa=t;
        plantas = new Planta[NumPlantas];

        for (int i=0; i<plantas.length; i++){
            plantas[i]=new Planta(i,PLAZAS_X_PLANTA); 
        }     
    }

    /** Crea un parking a partir de los datos de un fichero 
     *  cuyo nombre se pasa como parametro.<br>
     *  Formato del fichero:
     *  <pre>
     *  plantas 
     *  tarifa
     *  planta matricula horas minutos
     *  ...
     *  planta matricula horas minutos
     *  </pre>
     *  Los datos son correctos (no hay vehiculos ni plazas repetidas, 
     *  las plantas y las horas son correctas). 
     *  @param nomFich String, el nombre del fichero con los datos.
     */
    public Parking(String nomFich) {
        final String SEP = java.io.File.separator;
        final String DIR = this.getClass().getPackage().getName(); // "pract7"
        Scanner in = null;
        try {
            in = new Scanner(new File(DIR + SEP + nomFich)).useLocale(Locale.US);
            int numPlt = in.nextInt(); 
            double tf = in.nextDouble();

            plantas = new Planta[numPlt];
            for (int i = 0; i < plantas.length; i++) {
                plantas[i] = new Planta(i, PLAZAS_X_PLANTA);
            }            
            tarifa = tf;

            while (in.hasNext()) {
                int plt = in.nextInt(); 
                String mat = in.next(); 
                int h = in.nextInt(); 
                int m = in.nextInt();
                Ticket t = new Ticket(mat, new Instante(h, m));
                t.setPlanta(plt);
                plantas[plt].estacionar(t);
            }
        } catch (FileNotFoundException e) {
            System.out.println("\n***ERROR***: " 
                + "No se pudo acceder al fichero " + nomFich);
        } finally {
            if (in != null) { in.close(); }
        }          
    }

    /** Devuelve el numero de plantas.
     *  @return int, numero de plantas del parking.
     */
    /* COMPLETAR */   
    public int getNumPlantas(){ return plantas.length;}

    /** Devuelve la tarifa.
     *  @return double, tarifa del parking en euros por minuto.
     */
    /* COMPLETAR */
    public double getTarifa(){return tarifa;}

    /** Actualiza la tarifa.
     *  @param tf double, la nueva tarifa 
     *  (en euros por minuto), tf > 0.
     */
    /* COMPLETAR */
    public void setTarifa(double tf){tarifa=tf;}    

    /** Comprueba si el parking esta lleno.
     *  @return boolean, true si lleno, o false en caso contrario.
     */
    // Usa estaLlena() de Planta
    /* COMPLETAR */
    public boolean estaLleno(){
        int i= 0;
        while (i<plantas.length && plantas[i].estaLlena()){ 
            i++;
        }
        if (i<plantas.length){return false;}
        else  {return true;}
    } 

    /** Dado el ticket asociado a un vehiculo, estaciona el vehiculo
     *  en la planta de numero menor con plazas libres, en la plaza 
     *  de numero menor.
     *  Precondicion: parking con plazas libres y vehiculo no presente.
     *  @param t Ticket, el ticket del vehiculo a estacionar.
     */
    // Usa estaLlena() y estacionar(Ticket) de Planta y
    // setPlanta(int) de Ticket
    /* COMPLETAR */
    public void estacionar(Ticket t){
        int i = 0;
        while (i<plantas.length && plantas[i].estaLlena()){
            i++;
        }
        
        if (i<plantas.length){plantas[i].estacionar(t);
            t.setPlanta(i);}
    } 

    /** Dados el ticket asociado a un vehiculo y un numero de planta 
     *  de preferencia, estaciona el vehiculo en dicha planta, si hay 
     *  plazas libres, o si no, en la planta mas cercana con plazas 
     *  libres, siguiendo la estrategia del boletin.   
     *  Precondicion: parking con plazas libres y vehiculo no presente.      
     *  @param t Ticket, el ticket del vehiculo a estacionar.       
     *  @param pref int, la planta de preferencia.
     */
    // Usa estaLlena() y estacionar(Ticket) de Planta y
    // setPlanta(int) de Ticket
    /* COMPLETAR */
    
    public void estacionar(Ticket t , int pref){
        if(plantas[pref].estaLlena() == false){
            plantas[pref].estacionar(t);
            t.setPlanta(pref);
        }
        
        else{
            for(int i = 1; i<plantas.length; i++){
                if((pref+i)<plantas.length){
                    if(plantas[(pref+i)].estaLlena() == false){
                        t.setPlanta(pref+i);
                        this.plantas[(pref+i)].estacionar(t);
                        break;
                    }
                }
                else{
                    if((pref-i)>=0){
                        if(plantas[(pref-i)].estaLlena()== false){
                            t.setPlanta(pref-i);
                            this.plantas[(pref-i)].estacionar(t);
                            break;
                        }
                    }
                }
            }
        }
    
    }

    /** Comprueba si un vehiculo de matricula dada esta en el parking. 
     *  @param m String, la matricula del vehiculo a buscar.
     *  @return Ticket, el ticket asociado al vehiculo de matricula dada, 
     *  si se encuentra, o null si no se encuentra.
     */
    // Usa buscarTicket(String) de Planta
    /* COMPLETAR */
    
    public Ticket buscarTicket(String m){
            
            int i=0;
            while (i<plantas.length && plantas[i].buscarTicket(m)==null){i++;} 
            
            if (i==plantas.length){
                return null;
            }
            
            else {return plantas[i].buscarTicket(m);}
    }

    /** Retira del parking, dada una hora de salida, el vehiculo 
     *  asociado al ticket dado y devuelve el importe a pagar.
     *  @param t Ticket, el ticket asociado al vehiculo a retirar. 
     *       Precondicion: siempre esta.
     *  @param hSal Instante, la hora de salida del vehiculo. 
     *       Precondicion: posterior a la hora de entrada.
     *  @return double, importe en euros a pagar.
     */
    // Usa retirar(int, Instante) de Planta
    /* COMPLETAR */
    
    public double retirar(Ticket t, Instante hSal){
    
        double precio = plantas[t.getPlanta()].retirar(t.getPlaza(),hSal)*tarifa;
        return precio;
    }

    /** Vacia el parking, retirando todos los vehiculos, suponiendo   
     *  que son las 23:59, y devuelve el importe total.
     *  @return double, importe total en euros a pagar por 
     *  todos los vehiculos retirados del parking.
     */
    // Usa retirarTodos(Instante) de Planta
    /* COMPLETAR */
    
    public double vaciarParking(){
        Instante h = new Instante(23,59);
        int x = 0;
        double precio;
        
        for(int i=0; i<plantas.length; i++){
            x = x + plantas[i].retirarTodos(h); 
        }
        return precio = x * tarifa;
    
    }

    /** Devuelve un String que representa la ocupacion del parking, 
     *  con 'X' ocupada, con ' ' libre.
     *  Debe colocar una primera linea con los numeros de 
     *  plaza correspondientes.<br>
     *  Ejemplo: el siguiente String representa un parking, con 
     *  3 plantas y 5 plazas por planta, en el que estan ocupadas:
     *  en la planta 0, las plazas 0, 1 y 3;
     *  en la planta 1, las plazas 1, 2 y 4;
     *  en la planta 2, las plazas 0 y 1.
     *  <pre>
     *          "      0   1   2   3   4 
     *             0   X   X       X    
     *             1       X   X       X
     *             2   X   X             " </pre>
     *  @return String, representacion del parking.
     */
    // Usa toString() de Planta
    /* COMPLETAR */   
    
    public String toString(){
        String b = " ";
        String c= " ";
        String cabecera ="   "+"  0"+"  "+" 1"+"  "+" 2"+"  "+" 3"+"  "+" 4";
        System.out.println();
        for (int i=0; i<plantas.length; i++){
            b=plantas[i].toString();
        }
        c= c+cabecera+c+"\n"+b;
        
        return c;
    }
}
