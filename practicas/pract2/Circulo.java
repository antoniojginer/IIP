package pract2;

/** 
 * Clase Circulo: define un círculo de un determinado radio, color y
 * posición de su centro, con la funcionalidad que aparece a continuación.
 * @author IIP 
 * @version Práctica 2 - Curso 2017/18
 */ 
public class Circulo  {
    private double radio; 
    private String color;
    private int centroX, centroY;   
    
    /** Crea un Circulo de radio 50, negro y centro en (100,100). */
    public Circulo() {
        radio = 50; 
        color = "negro"; 
        centroX = 100;  
        centroY = 100; 
    }
    
    /** Crea un Circulo de radio r, color c y centro en (cx,cy). 
     *  @param r double que representa el radio. 
     *  @param col String que representa el color.
     *  @param cx int que representa la abscisa del centro.
     *  @param cy int que representa la ordenada del centro.
     */
    public Circulo(double r, String col, int cx, int cy) {
        radio = r;  
        color = col; 
        centroX = cx; 
        centroY = cy;         
    }

    /** Devuelve el radio del Circulo. 
     *  @return double, el radio. 
     */
    public double getRadio() { return radio; }    

    /** Devuelve el color del Circulo.
     *  @return String, el color.  
     */
    public String getColor() { return color; }  

    /** Devuelve la abscisa del centro del Circulo. 
     *  @return int, la abscisa.   
     */
    public int getCentroX() { return centroX; }  

    /** Devuelve la ordenada del centro del Circulo. 
     *  @return int, la ordenada.   
     */
    public int getCentroY() { return centroY; }
 
    /** Actualiza el radio del Circulo a nuevoRadio. 
     *  @param nuevoRadio double que representa el nuevo radio.
     */
    public void setRadio(double nuevoRadio) { radio = nuevoRadio; }   

    /** Actualiza el color del Circulo a nuevoColor. 
     *  @param nuevoColor String que representa el nuevo color.
     */
    public void setColor(String nuevoColor) { color = nuevoColor; }   
 
    /** Actualiza el centro del Circulo a la posición (cx,cy). 
     *  @param cx int que representa la nueva abscisa del centro.
     *  @param cx int que representa la nueva ordenada del centro.
     */
    public void setCentro(int cx, int cy) { centroX = cx; centroY = cy; }
    
    /** Devuelve el área del Circulo.
     *  @return double, el área.  
     */
    public double area() { return Math.PI * radio * radio; }
    
    /** Devuelve el perímetro del Circulo.
     *  @return double, el perímetro.  
     */
    public double perimetro() { return 2 * Math.PI * radio; }
    
    /** Devuelve un String con los datos del Circulo. 
     *  @return String, los datos. 
     */
    public String toString() { 
        String res = "Círculo de radio " + radio;
        res += ", color " + color;
        res += " y centro (" + centroX + "," + centroY + ")";
        return res; 
    }

} // de Circulo
