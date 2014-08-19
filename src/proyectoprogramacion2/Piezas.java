package proyectoprogramacion2;
/**
 * @author EdwinCruz
 */
public abstract class Piezas {
    
    public abstract String mover(int fila, int columna, int turno);
    public abstract String comer(int fila, int columna, int turno);
    public abstract void seleccionar(int fila, int columna);
    
}
