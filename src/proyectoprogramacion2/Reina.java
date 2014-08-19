package proyectoprogramacion2;

import proyectoprogramacion2.Piezas;

/**
 *
 * @author EdwinCruz
 */
public class Reina extends Piezas{
    private int fila;
    private int columna;
    @Override
    public String mover(int fila, int columna, int turno) {
        return getComverMover(turno);
    }
    
    private String getComverMover(int turno){
        if(turno==1)
            return "DB";
        return "DN";
    }

    @Override
    public String comer(int fila, int columna, int turno) {
        return getComverMover(turno);
    }

    @Override
    public void seleccionar(int fila, int columna) {
        this.fila=fila;
        this.columna=columna; 
    }
    
    
}
