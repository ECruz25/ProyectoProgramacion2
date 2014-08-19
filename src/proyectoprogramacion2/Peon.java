
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
