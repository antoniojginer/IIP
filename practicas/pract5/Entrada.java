package pract5;

import pract4.Instante;

// importar la clase Instante del paquete pract4

/**
 *  Entrada, clase "Tipo de Datos": representa una
 *  entrada de cine
 *  
 *  @author IIP
 *  @version Curso 2017/18
 */

public class Entrada {
    
    // Una Entrada TIENE...
    
    // (a) Como atributos públicos, las siguientes "Constantes Java":
    
    /** El precio base en euros (double) redondeado
     *  a dos cifras decimales. */
    public static final double PRECIO_BASE = 7.60;    
    
    /** El limite para considerar una sesion matinal. */
    public static final Instante LIMITE_MATINAL = new Instante(15, 0);
    
    /** La edad (int) "senior", mayor que 64. */
    public static final int SENIOR = 65;
    
    /** La fraccion (double) del precio base a pagar
     *  por descuento "senior" (del 70%). */
    // NOTA: un espectador "senior" paga PRECIO_BASE * 0.3 euros  
    // por una entrada de cine, i.e. el 30% de su precio base
    public static final double DTO_SENIOR = 0.3;
    
    /** La fraccion (double) del precio base a pagar
     *  por descuento del dia del espectador (del 20%) */
    public static final double DTO_DIA_ESPECTADOR = 0.8;
    
    /** La fraccion (double) del precio base a pagar
     *  por descuento de tarjeta de cliente (del 20%) */
    public static final double DTO_CLIENTE = 0.8;
    
    /** La fraccion (double) del precio base a pagar
     *  por recargo de dia festivo (del 20%). */
    // NOTA: un espectador NO "senior" paga un PRECIO_BASE * 1.2   
    // euros por una entrada de cine en un dia festivo , i.e. el 
    // 120% de su precio base
    public static final double RECARGO_FESTIVO = 1.2;
    
    /** Fraccion (double) del precio base a pagar
     *  por recargo de vispera de festivo (del 10%). */
    public static final double RECARGO_VISPERA = 1.1;
    
    // (b) Como atributos privados, las siguientes variables de instancia:
    private String titulo, cine;
    private Instante inicioSesion;

    // (c) Como metodos publicos, los siguientes:
    
    /** PRECONDICION: 0 <= h < 24 AND 0 <= m < 60
     *  Crea una Entrada para la pelicula de titulo t 
     *  que se proyecta en el cine c a las h horas y
     *  m minutos. 
     */
    public Entrada(String t, String c, int h, int m) {
        titulo = t;
        cine = c;
        inicioSesion = new Instante(h,m);
    }

    /** Devuelve el titulo de la pelicula de una Entrada. */
    public String getTitulo() { return titulo; }
 
    /** Devuelve el cine de una Entrada. */
    public String getCine() { return cine; }

    /** Devuelve el Instante de inicio de sesion de una Entrada. */
    public Instante getInicioSesion() { return inicioSesion; }

    /** Actualiza a nuevo el titulo de la pelicula de una Entrada. */
    public void setTitulo(String nuevo) { titulo = nuevo; }

    /** Actualiza a nuevo el cine de una Entrada. */
    public void setCine(String nuevo) { cine = nuevo; }

    /** Actualiza a nuevo el Instante de inicio de sesion de una Entrada. */
    public void setInicioSesion(Instante nuevo) { inicioSesion = nuevo; }
    
    /** Devuelve un String que representa una Entrada de cine,  
     *  i.e. sus componentes en el formato que ilustra el siguiente ejemplo:
     *  "Anochece en La India", proyectada en Cines Babel, a las 22:30
     *  Precio base: 7.60 euros
     */
    public String toString() {
        return "\""  + titulo + "\", proyectada en " + cine + ", a las " 
               + inicioSesion + "\nPrecio base: " + PRECIO_BASE + " euros";
    }

    /** Comprueba si una entrada (this) es igual a otra, i.e. si ambas son
     *  de tipo Entrada y si, uno por uno, sus atributos son iguales. */
    public boolean equals(Object otra) {
        return 
        otra instanceof Entrada &&
        this.titulo.equals(((Entrada) otra).titulo) &&
        this.cine.equals(((Entrada) otra).cine) &&
        this.inicioSesion.equals(((Entrada) otra).inicioSesion);
    }   
    
    /** Devuelve, redondeado a centimos de euro, el precio final de una entrada
     *  para un espectador de edad e, teniendo en cuenta tanto si esCliente 
     *  como si el dia es diaEspectador, festivo o vispera.
     */
    public double precioFinal(int edad, boolean diaEspectador, boolean festivo, 
                              boolean vispera, boolean esCliente) {
                                  
        double res = PRECIO_BASE;
        
        if (edad >= SENIOR) {
            res = DTO_SENIOR * res; 
            return PRECIO_BASE * DTO_SENIOR;}
        if(esCliente) {res = res * DTO_CLIENTE; return res;
        } else {
            if (diaEspectador) {
                res = PRECIO_BASE * DTO_DIA_ESPECTADOR;
                return res;
            } else {
                if (festivo) {
                    res = PRECIO_BASE * RECARGO_FESTIVO;
                    if (esCliente) {res = res * DTO_CLIENTE; return res;}
                    else {return res;}
                } else  {
                    if (vispera) {
                        res = RECARGO_VISPERA * PRECIO_BASE;
                        if (esCliente) {res = res * DTO_CLIENTE; return res;}
                        else {return res;}
                    } else {return PRECIO_BASE;}
                }
            }
        }
            
    }

}