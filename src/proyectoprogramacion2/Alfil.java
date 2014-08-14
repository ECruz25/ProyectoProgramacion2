package proyectoprogramacion2;

/**
 *
 * @author EdwinCruz
 */

public class Alfil extends Piezas{
    private int fila, columna;
    @Override
    public String mover(int fil, int col, int turno) {
        if(Math.abs(fil-this.fila)==Math.abs(col-this.columna)){
            return "Al";
        }
        return null;
    }

    @Override
    public String comer(int fila, int columna, int turno) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void seleccionar(int fila, int columna) {
        this.fila=fila;
        this.columna=columna;
    }
    
   
    
    
}
