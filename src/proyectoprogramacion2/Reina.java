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
        return getComverMover(fila, columna, turno);
    }
    
    private String getComverMover(int fil, int col, int turno){
        if(Math.abs(fil-this.fila)==Math.abs(col-this.columna)){
            return getDama(turno);
        }else if(this.fila==fil){
            if(this.columna>col||this.columna<col)
                return getDama(turno);
        }else if(this.columna==col){
            if(this.fila>fil||this.fila<fil)
                return getDama(turno);
        }
        return null;
    }
    
    private String getDama(int turno){
        if(turno==1)
            return "|DB|";
        return "|DN|";
    }

    @Override
    public String comer(int fila, int columna, int turno) {
        return getComverMover(fila, columna, turno);
    }

    @Override
    public void seleccionar(int fila, int columna) {
        this.fila=fila;
        this.columna=columna; 
    }
    
    
}
