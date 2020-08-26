package pract2;

/**
 * Clase-programa para probar todas las figuras definidas.
 * También se puede hacer una ejecución parecida utilizando
 * el <B>workbench</B> del BlueJ.
 * @author IIP 
 * @version Práctica 2 - Curso 2017/18
 */
public class ProgramaPrueba {

    public static void main(String[] args) {        
        // Inicializar el lugar de dibujo, dándole
        // un nombre y dimensiones:
        Pizarra miPizarra = new Pizarra("UNA VENTANA AL MUNDO", 500, 300);
                
        // Inicializar un círculo amarillo:
        Circulo c = new Circulo(50, "amarillo", 100, 100);        
        // ponerlo en el espacio de dibujo:
        miPizarra.add(c);
        // mostrar por pantalla el perímetro del círculo:
        System.out.println("El perímetro del círculo es " + c.perimetro() /* COMPLETAR */);
        
        // Inicializar un rectángulo largo y rojo:
        Rectangulo r = new Rectangulo(100, 10, "rojo", 50, 155);
        // ponerlo en el espacio de dibujo:
        miPizarra.add(r);  
        
        // Inicializar un triángulo isósceles negro:
        TrIsosceles t = new TrIsosceles(30, 60, "negro", 210, 60);
        // ponerlo en el espacio de dibujo:
        miPizarra.add(t);          
    }
    
} // de ProgramaPrueba

