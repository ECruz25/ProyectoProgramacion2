package proyectoprogramacion2;

/**
 *
 * @author EdwinCruz
 */

public class Alfil extends Piezas{
    private int fila;
    private int columna;
    @Override
    public String mover(int fila, int columna, int turno) {
        return null;
    }

    @Override
    public String comer(int fila, int columna, int turno) {
        return getComerOMover(fila,columna,turno);
    }
    
    private String getComerOMover(int fil, int col, int turno){
        if(Math.abs(fil-this.fila)==Math.abs(col-this.columna)){
            if(turno==1)
                return "|♗|";
            else
                return "|♝|";
        }
        return null;
    }

    @Override
    public void seleccionar(int fila, int columna) {
        this.fila=fila;
        this.columna=columna;
    }
    
   
    
    
}
