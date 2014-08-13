package proyectoprogramacion2;

import proyectoprogramacion2.Piezas;

/**
 *
 * @author EdwinCruz
 */
public abstract class Reina extends Piezas{
    int defaultPosB=51;
    int defaultPosN=58;
    @Override
    public String moverB(int posMover, int posActual){
        if(posActual!=posMover){
            
        }
        return "♕";
    }
    
    @Override
    public String comerB(int posMover, int posActual){
        System.out.println("");
        return "♕";
    }
    
    @Override
    public String moverN(int posMover, int posActual){
        System.out.println("");
        return "♛";
    }

    @Override
    public String comerN(int posMover, int posActual){
        System.out.println("");
        return "♛";
    }
}
