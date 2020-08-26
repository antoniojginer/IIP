package pract4;

/**
 * <p>
 * Esta clase permite representar instantes o marcas de tiempo
 * (<code>Timestamp</code>) con detalle de horas y minutos. Así, esta 
 * clase representa el momento que define un instante de tiempo,
 * en este caso, las horas y los minutos de un día cualquiera.
 * </p>
 * 
 *  @author IIP 
 *  @version Curso 2017-18
 */
public class Instante {

    // ATRIBUTOS:
    /** Variable entera para almacenar el atributo horas. 
     *  Debe pertenecer al rango <code>[0..23]</code>. */
        private int horas;
    /** Variable entera para almacenar el atributo minutos. 
     *  Debe pertenecer al rango <code>[0..59]</code>. */
        private int minutos;
    
    // CONSTRUCTORES:
    /**
     *  Crea un <code>Instante</code> con el valor de
     *  las horas y los minutos que recibe como argumentos,
     *  <code>h</code> y <code>m</code> respectivamente.
     *
     *  <p> Debe cumplirse la precondición: 
     *  <code>0 <= h < 24, 0 <= m < 60</code>. </p>
     */
           public Instante (int h, int m){
           horas=h;
           minutos=m;
           }

    
    /**
     * Crea un <code>Instante</code> con el valor del instante
     * actual UTC (tiempo universal coordinado).
     */
        public Instante(){
        long tMinTotal = System.currentTimeMillis() / (60 * 1000);
        int tMinActual = (int) (tMinTotal % (24 * 60));
        
        //Hora y minuto
        horas = (tMinActual / 60);
        minutos = (tMinActual % 60); 
    }
    

    // CONSULTORES Y MODIFICADORES:
    /** Devuelve las <code>horas</code> del Instante. */
        public int getHoras(){
        return horas;
        }
    

    /** Devuelve los <code>minutos</code> del Instante. */
        public int getMinutos(){
        return minutos;
        }
    
   
    /** Actualiza las <code>horas</code> del Instante. */ 
        public void setHoras(int h1){
        this.horas=h1;
        }
    
   
    /** Actualiza los <code>minutos</code> del Instante. */ 
        public void setMinutos(int m1){
        this.minutos=m1;
        }
           
    
   
    // OTROS MÉTODOS:
    /** Devuelve el Instante en el formato "<code>hh:mm</code>". */
        public String toString() {
        String hh = "0" + horas;
        hh = hh.substring(hh.length()-2);
        
        String mm = "0" + minutos;
        mm = mm.substring(mm.length()-2);
        
        return hh + ":" + mm;
        }
        
    
   
    /** Devuelve <code>true</code> sii <code>o</code> es 
     *  un objeto de la clase <code>Instante</code>
     *  y sus <code>horas</code> y <code>minutos</code>
     *  coinciden con los del objeto en curso. 
     */
    public boolean equals (Object o){
        return o instanceof Instante
        && this.horas==((Instante)o).horas
        && this.minutos==((Instante)o).minutos;
    }
      
      
    /** Devuelve el número de minutos transcurridos desde las 00:00 
     *  hasta el instante representado por el objeto en curso.
     */
    public int aMinutos(){
        return horas*60 + minutos;
    }
    
    
    /** Compara cronológicamente el instante almacenado por el objeto en curso
     *  con el almacenado en el objeto de la clase <code>Instante</code>
     *  referenciado por <code>otro</code>.
     *  <p>
     *  El resultado es la resta entre la conversión <code>aMinutos</code>
     *  de ambos objetos, en particular, este resultado será un valor:
     *  <ul>
     *     <li> negativo si el instante del objeto en curso es anterior
     *          al del <code>otro</code>, </li>
     *     <li> cero si son iguales, </li>
     *     <li> positivo si el instante del objeto en curso es posterior
     *          al del <code>otro</code>. </li>
     *  </ul>
     *  </p>
     */
    public int compareTo(Instante otro){
        return this.aMinutos()-otro.aMinutos();
    }
    

    // ACTIVIDAD EXTRA:
    /** Devuelve un <code>Instante</code> a partir de la descripción 
     *  textual (<code>String</code>) en formato "<code>hh:mm</code>".
     */
        public static Instante valueOf(String hhmm){
        int horanueva = (hhmm.charAt(0)-'0')*10 +(hhmm.charAt(1)-'0');
        int minutosnuevo = (hhmm.charAt(3)-'0')*10 +(hhmm.charAt(4)-'0');
        return null;
        }
        
        
        

    
}
