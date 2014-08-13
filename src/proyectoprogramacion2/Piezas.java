package proyectoprogramacion2;
/**
 * @author EdwinCruz
 */
public abstract class Piezas {
    protected String Jugador1;
    
    public abstract String moverB(int posMover, int posActual);
    public abstract String comerB(int posMover, int posActual);
    public abstract String comerN(int posMover, int posActual);
    public abstract String moverN(int posMover, int posActual);
    public abstract String InicializarN();
    public abstract String InicializarB();
}
