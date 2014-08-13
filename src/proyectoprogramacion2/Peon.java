
package proyectoprogramacion2;

import proyectoprogramacion2.Piezas;

/**
 *
 * @author Edwin Cruz
 */
public class Peon extends Piezas{
    
    @Override
    public String moverB(int fila, int columna){
        return null;
    }
    
    @Override
    public String comerB(int posMover, int posActual){
//        if(){
//            
//        }
        System.out.println("");
        return "PB";
    }
    
    @Override
    public String moverN(int posMover, int posActual){
        System.out.println("");
        return "PN";
    }

    @Override
    public String comerN(int posMover, int posActual){
        System.out.println("");
        return "PN";
    }
    
    @Override
    public String InicializarN(){
        return "|PN|";
    }
    @Override
    public String InicializarB(){
        return "|PB|";
    }
    
}
