    package pract7;

import pract4.Instante;
/** Clase Planta: representa la ocupacion de una planta de parking,
 *  mediante los tickets asociados a los vehiculos estacionados en
 *  la misma.
 *  @author IIP
 *  @version Curso 2017/2018
 */
public class Planta {
    // Definicion de atributos
    /* COMPLETAR */
    private int numPlanta;
    private Ticket[] plazas;
    private int plazasLibres;
    
    public Planta(int numP, int numPlazas){
    /** Crea una Planta dados un numero de planta y un numero 
     *  de plazas.
     *  La planta, al comienzo, esta vacia (sin vehiculos).
     *  @param numP int, el numero de planta, numP >= 0.
     *  @param numPlazas int, el numero de plazas, numPlazas > 0.
     */
    /* COMPLETAR */
    numPlanta = numP;
    plazas = new Ticket[numPlazas];
    plazasLibres = plazas.length;
   }
   
   
   /** Devuelve el numero de planta.
     *  @return int, el numero de planta del parking.
     */
   /*COMPLETAR*/ 
   public int getPlanta(){ return numPlanta; }
  
    /** Devuelve el numero de plazas libres.
     *  @return int, el numero de plazas libres de la planta.
     */  
    /* COMPLETAR */
    public int getPlazasLibres(){ return plazasLibres; }

    /** Devuelve true si la planta esta llena o false 
     *  en caso contrario.
     *  @return boolean, true si planta llena (sin plazas libres),
     *  false en caso contrario.
     */
    /* COMPLETAR */
    public boolean estaLlena(){        
        if (plazasLibres == 0) {return true;}
        else {return false;}
        }
    

    /** Devuelve la primera plaza libre (de numero menor) en la planta, o 
      * -1 si no hay plazas libres. 
      * @return int, numero de la primera plaza libre (de numero menor) 
      * en la planta o -1 si no hay plazas libres.
      */
    // Usa estaLlena()
    /* COMPLETAR */
    public int primeraLibre(){
        int res = -1;
        int i = 0;
        if (estaLlena() == true){return res;}
        else { while (i<plazas.length && plazas[i] != null){i++;}
         }
         
        if (i<plazas.length){return i;}
        else { return res;}
               
       
    }

   /** Si hay plazas libres, asocia el ticket a la primera plaza
          *    libre (de numero menor).   
          *  Precondicion: el Ticket no esta asociado a ninguna plaza.
          *  @param t Ticket, el ticket del vehiculo a estacionar.     
   */
            // Usa primeraLibre()
            /* COMPLETAR */
     public void estacionar(Ticket t){
            int pLibre = primeraLibre();
            
            if (pLibre != -1){
               t.setPlaza(pLibre);
               plazasLibres--;
               
               plazas[pLibre]=t;
            }
                  
        }
       
    /** Comprueba si un vehiculo, dada su matricula, esta en la planta.
     *  @param m String, la matricula del vehiculo a buscar.
     *  @return Ticket, el ticket asociado al vehiculo, si se encuentra, 
     *  o null en caso contrario.
     */
    /* COMPLETAR */
    public Ticket buscarTicket(String mat){
        
        for (int i=0; i<plazas.length; i++){
            if (plazas[i]!=null && mat.equals(plazas[i].getMatricula())){return plazas[i];}
            
        } 

        return null;
    }

    /** Devuelve el numero de minutos trancurridos desde la entrada del
     *  vehiculo que ocupa una plaza dada hasta una hora de salida dada,
     *  actualizando la planta.
     *  @param plz int, el  numero de plaza. 
     *    Precondicion: 0 <= plz < plazas.length y plazas[plz] != null.
     *  @param hSal Instante, la hora de salida. 
     *    Precondicion: posterior a la hora de entrada del vehiculo.
     *  @return int, numero de minutos que el vehiculo ha permanecido
     *  en el parking.
     */
    /* COMPLETAR */
    public int retirar(int plz, Instante hSal){
        
        int tMin = hSal.compareTo(plazas[plz].getEntrada());
        plazasLibres++;
        plazas[plz]=null;
        return tMin;
    }

    /** Retira todos los vehiculos de la planta y devuelve el numero total 
     *  de minutos que los vehiculos han permanecido en la planta hasta 
     *  una hora de salida dada.
     *  @param hSal Instante, la hora de salida. 
     *    Precondicion: posterior a la hora de entrada de todos 
     *    los vehiculos de la planta.
     *  @return int, el numero total de minutos transcurridos.
     */
    // Usa retirar(int, Instante)
    /* COMPLETAR */
    public int retirarTodos(Instante hRet){
        int aux=0;
            for(int i=0; i<plazas.length; i++){
                if (plazas[i]!=null) {aux = aux + retirar(i,hRet);} }
        return aux;
    }
    /** Devuelve un String con la ocupacion de la planta, con 'X' ocupada, 
      * con ' ' libre. <br>
      * Formato: <pre> PLANTA (en 3 posiciones), espacio, ocupacion 
      * ("  X" o "   "), espacio, ..., ocupacion ("  X" o "   "), 
      * espacio, '\n'</pre>
      * Ejemplo de formato (Planta 2 con 5 plazas, ocupadas la 0, 2, 3 y 4): 
      * <pre> "--2---X-------X---X---X-" </pre>
      * Se ha utilizado el - para representar un espacio en blanco.
      * @return String, representacion de la ocupacion del planta.
      */
    public String toString() {        
        String res = String.format("%3d ", numPlanta);
        for (int i = 0; i < plazas.length; i++) {
            if (plazas[i] == null) { res += "    "; }
            else { res += "  X "; }
        }
        res += "\n";
        return res;
    }
}
