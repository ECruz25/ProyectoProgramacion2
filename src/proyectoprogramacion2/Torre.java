/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyectoprogramacion2;

/**
 *
 * @author Daniel Perez
 */
public class Torre extends Piezas {
    private int fila;
    private int columna;
    @Override
    public String mover(int fila, int columna, int turno) {
        return getComverMover(fila, columna, turno);
    }

    @Override
    public String comer(int fila, int columna, int turno) {
        return getComverMover(fila, columna, turno);
    }
    private String getComverMover(int fila, int columna, int turno){
       if(this.fila==fila){
            if(this.columna>columna||this.columna<columna)
                return getTorre(turno);
        }else if(this.columna==columna){
            if(this.fila>fila||this.fila<fila)
                return getTorre(turno);
        }
        return null;
    }
    private String getTorre(int turno){
        if(turno==1)
            return "TB";
        return "TN";
    }

    @Override
    public void seleccionar(int fila, int columna) {
        this.fila=fila;
        this.columna=columna;    
    }
    
}
