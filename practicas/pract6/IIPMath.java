package pract6;

/**
 * La clase IIPMath implementa algunas operaciones matematicas:
 * IIPMath.sqrt(double) e IIPMath.log(double).
 *
 * @author (IIP-PRG-DSIC-ETSINF)
 * @version (Curso 2017-18)
 */
public class IIPMath {
    
    // A COMPLETAR
    public final static double LOG_2 = 0.6931471805599453;
    
        
    /**
     * Devuelve la raiz cuadrada de x >= 0, con error epsilon > 0. 
     * A COMPLETAR COMENTARIO
     */
    public static double sqrt(double x, double epsilon) {
        if (x==0){ return 0;}
        if (x<0) { return Double.NaN; }
        // A COMPLETAR. Defino la variable tActual y le doy valor. Defino la variable tAnterior. Defino la diferencia y lr doy un valor mas grande que epsilon.
        // Mientras diferencia sea mayor o igual que epsilon, Guardo en tAnterior el tActual para recalcular tActual.
        // Recalculo la diferencia.
        // Devuelve tActual.
        double tActual = (1 + x)/2;
        double tAnterior;
        double diferencia = epsilon + 1;
        
        while(diferencia>=epsilon){
            tAnterior = tActual;
            tActual = (tAnterior + (x/tAnterior))/2;
            //Si no te acuerdas de cual es mayor Math.abs...
            diferencia = Math.abs(tAnterior - tActual);
            
        }
        return tActual;
    }            

    ///**
     //* Devuelve la raiz cuadrada de x >= 0 con error 1e-15. 
     //* A COMPLETAR COMENTARIO
     //*/
    public static double sqrt(double x) {    
        // A COMPLETAR
        return sqrt(x, 1e-15);      
   
        
    }  
                    
    /* ******************************************************** */
    /* ******************************************************** */
    /* ******************************************************** */
                
    /**
    * Devuelve log(z), 1/2 <= z < 1, con error epsilon > 0.
    * A COMPLETAR COMENTARIO
    */
    public static double logBase(double z, double epsilon) {
           // Defino la variable "y" y le doy valor.
           // Defino el termino uK y le doy valor.
           // Defino la variable suma y le doy valor.
           // Defino la variable k(contador int).
           // Mientras que uK sea mayor o igual a epsilon.
           //   recalcular uk.
           //   acumularlo en suma.
           //   incremento k
           // Devuelvo -2 * suma.
           
           double y = (1-z)/(1+z);
           int k = 1;
           double uK = y;
           double suma = uK;
           double x;
           
           while(uK > epsilon){
               uK= (y * y) * ((2.0*k-1)/(2.0*k+1)) * uK;
               suma += uK;
               k++;
            }
            return suma * (-2);
            
        }
        
    public static double log(double x){
        return logBase(x, 1e-15);
    
    
       }
            
    /**
    // * Devuelve log(x), x > 0, con error epsilon > 0.
    // * A COMPLETAR COMENTARIO
    //*/
    public static double log(double x, double epsilon) {
        // A COMPLETAR 
        double z=x;
        int m = 0;
        if (x<1 && 0.5<=x){return logBase(x,epsilon);}
            else{
        if (x>=1) { 
            
            
            while (z>1){
                z = z / 2;
                m++;
            }
            System.out.println("Nº de interacciones: " + m);
            
        }
        if (x<0.5){
            
            
            while (0.5<z){
                z = z * 2;
                m++;
            }
            m = -m;
            System.out.println("Nº de interacciones: " + m);
           
        }
        return logBase(z,epsilon) + m*LOG_2;
        
        
      }
      
    }
}
    /**
    // * Devuelve log(x), x > 0, con error 1e-15.
    // * A COMPLETAR COMENTARIO
     //*/
    //public static double log(double x) {    
        // A COMPLETAR
        
        
            
        //}
        //;
    //}
