package pract7;

import pract4.Instante;
/** Clase Ticket: define los datos de estacionamiento 
 *  de un vehiculo en un parking: matricula, hora de
 *  entrada y localizacion (numero de planta y numero 
 *  de plaza).
 *  @author IIP
 *  @version Curso 2017/2018
 */
public class Ticket {
    private String matricula;
    private Instante entrada;    
    private int planta;
    private int plaza;
    
    /** Crea un Ticket para un vehiculo con una matricula y 
     *  una hora de llegada dadas, sin localizacion asignada.
     *  @param mat String, la matricula.
     *  @param hEnt Instante, la hora de entrada al parking.      
     */
    public Ticket(String mat, Instante hEnt) {
        /* COMPLETAR */
        this.matricula = mat;
        this.entrada = hEnt;
        planta = -1;
        plaza = -1;        
        
    }

    /** Devuelve la matricula.
     *  @return String, la matricula. 
     */
    public String getMatricula() { return matricula; }

    /** Devuelve la hora de entrada.
     *  @return Instante, la hora de entrada. 
     */
    public Instante getEntrada() { return entrada; }    

    /** Devuelve la planta.
     *  @return int, la planta. 
     */
    public int getPlanta() { return planta; }
    
    /** Devuelve la plaza.
     *  @return int, la plaza. 
     */
    public int getPlaza() { return plaza; }
        
    /** Actualiza la planta.
     *  @param plt int, la planta.
     */
    public void setPlanta(int plt) { planta = plt; }
    
    /** Actualiza la plaza.
     *  @param plz int, la plaza.
     */
    public void setPlaza(int plz) { plaza = plz; }
    
    /** Devuelve un String representando los datos del Ticket 
     *  en el siguiente formato: <br>
     *  - si el ticket NO tiene localizacion: <pre>
     *    "Matricula: MATRICULA - Entrada: ENTRADA" 
     *    </pre>
     *  - si el ticket SI tiene localizacion: <pre>
     *    "Matricula: MATRICULA - Entrada: ENTRADA - Planta: PLANTA - Plaza: PLAZA"
     *    </pre>
     *  @return String, la representacion del Ticket.
     */
    public String toString() {
        String res = "Matricula: " + matricula + " - Entrada: " + entrada;
        if (planta!=-1 && plaza!=-1){
            return res + " - Planta: " + planta + " - Plaza: " + plaza;
       
       }
       return res; 
    }
}
