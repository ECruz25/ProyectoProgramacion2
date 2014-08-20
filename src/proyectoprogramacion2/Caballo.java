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
public class Caballo extends Piezas{
    private int fila;
    private int columna;
    @Override
    public String mover(int fila, int columna, int turno) {
         return getComerMover(fila, columna, turno);
    }

    @Override
    public String comer(int fila, int columna, int turno) {
        return getComerMover(fila, columna, turno);
    }

    private String getComerMover(int fila, int columna, int turno){
        if(this.columna+2==columna){
            if(this.fila+1==fila||this.fila-1==fila)
                return getCaballo(turno);
        }else if(this.columna-2==columna){
            if(this.fila+1==fila||this.fila-1==fila)
                return getCaballo(turno);
        }else if(this.fila+2==fila){
            if(this.columna+1==columna || this.columna-1==columna)
                return getCaballo(turno);
        }else if(this.fila-2==fila){
            if(this.columna+1==columna || this.columna-1==columna)
                return getCaballo(turno);
        }
        return null;
    }
    
    private String getCaballo(int turno) {
        if(turno==1)
            return "|♘|";
        return "|♞|";
    }
   @Override
    public void seleccionar(int fila, int columna) {
        this.fila=fila;
        this.columna=columna;
    }
    
}

    
