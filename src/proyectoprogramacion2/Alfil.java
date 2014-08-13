package proyectoprogramacion2;

/**
 *
 * @author EdwinCruz
 */
public abstract class Alfil extends Piezas{
    int defaultPosB=31;
    int defaultPosN=38;
    @Override
    public String moverB(int posMover, int posActual){
        if(posMover!=posActual){
            if(posMover==1){
                
            }
        }
        return "AB";
    }
    
    @Override
    public String comerB(int posMover, int posActual){
        System.out.println("");
        return "AB";
    }
    
    @Override
    public String moverN(int posMover, int posActual){
        System.out.println("");
        return "AN";
    }

    @Override
    public String comerN(int posMover, int posActual){
        System.out.println("");
        return "AN";
    }
    
    public void String(int posIMover, int posActual){
        
    }
    
}
