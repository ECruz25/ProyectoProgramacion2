
package proyectoprogramacion2;

/**
 *
 * @author Edwin Cruz
 */
public final class Peon extends Piezas{
    private int fila;
    private int columna;

    @Override
    public String mover(int fila, int columna, int turno) {
        if(this.columna==columna){
            if((this.fila>=1&&this.fila<=6)&&(this.fila+1==fila||this.fila-1==fila))
                return getPeon(turno);
            else if((this.fila==6&&fila==4)||(this.fila==1&&fila==3))
                return getPeon(turno);
            
        }
        return null;
    }
    
    private String getPeon(int turno){
        if(turno==1)
            return "|PB|";
        return "|PN|";
    }

    @Override
    public String comer(int fila, int columna, int turno) {
        if(columna-1==this.columna||columna+1==this.columna){
            if(turno == 1){
                if(this.fila>fila){
                    return "|PB|";
                }
            }
            else{
                if(this.fila<fila){
                    return "|PN|";
                }
            }
        }
        return null;
    }

    @Override
    public void seleccionar(int fila, int columna) {
        this.fila=fila;
        this.columna=columna;
    }
    
    
}
