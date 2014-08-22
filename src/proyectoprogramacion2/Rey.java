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
public class Rey extends Piezas{
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
    private String getComverMover(int fil, int col, int turno){
       if(((this.fila+1==fil||this.fila-1==fil)&&(this.columna+1==col||this.columna==col||this.columna-1==col))||(this.fila==fil&&(this.columna-1==col||this.columna+1==col))){
            if(Math.abs(fil-this.fila)==Math.abs(col-this.columna)){
                return getRey(turno);
            }else if(this.fila==fil){
                if(this.columna>col||this.columna<col)
                    return getRey(turno);
            }else if(this.columna==col){
                if(this.fila>fil||this.fila<fil)
                    return getRey(turno);
            }
       }
        return null;
    }
    private String getRey(int turno){
        if(turno==1)
            return "|RB|";
        return "|RN|";
    }

    @Override
    public void seleccionar(int fila, int columna) {
        this.fila=fila;
        this.columna=columna; 
    }
    
}
