package proyectoprogramacion2;


import java.util.Scanner;
import java.util.InputMismatchException;
/**
 * @author EdwinCruz
 */
public class Tablero {
    //static Piezas
    private final String tablero[][]=new String[8][8];
    private final Scanner lea=new Scanner(System.in);
    public  int fils, cols, turns;
    private final Piezas alf=new Alfil();
    private final Piezas cab=new Caballo();
    private final Piezas peo=new Peon();
    private final Piezas dam=new Reina();
    private final Piezas rey=new Rey();
    private final Piezas tor=new Torre();
    private boolean movimientoI=true;
   
    private void setTurno1(){
        turns=1;
    }
    private void setTurno2(){
        turns=2;
    }
    private  int getTurno(){
        return turns;
    }
    
    public void jugarAjedrez(){
        iniciarElTablero();
        imprimirArreglo();
        setTurno1();
            do {
                try{
                    System.out.println("Es el turno del jugador "+getTurno());
                    System.out.print("Ingrese la Fila: ");
                    fils=lea.nextInt();
                    System.out.print("Ingrese la Columna: ");
                    cols=lea.nextInt();
                    if (fils==-1&&cols==-1){
                        System.out.println("La partida ha sido habandonada por el jugador: "+getTurno());
                        break;
                    }
                    seleccionarFicha(fils, cols, getTurno());
                }catch(InputMismatchException e){
                    System.out.println("Ingresaste mal las conrdenadas, repite tu turno.");
                    lea.next();
                }catch(Exception e){
                    System.out.println("las cordenadas ingresadas son incorrectas!");
                    
                }
        } while (true);
    }
    //Valida si la posicion a donde se quiere mover esta disponible
    //Si en esa posicion esta: |__| es porque no hay nada y puede mover.
    private boolean validarDisponibilidad(int fila,int columna){
        if(tablero[fila][columna].equals("|__|"))
            return true;
        else
            return false;
    }
    
    public void iniciarElTablero(){
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                tablero[i][j]="|__|";
                //░
            }
        }
        for (int i = 0; i < tablero[1].length; i++) {
            tablero[1][i]="|PN|";        
        }
        for (int i = 0; i < tablero[6].length; i++) {
            tablero[6][i]="|PB|";
        }
        tablero[7][0]="|TB|";
        tablero[7][7]="|TB|";
        tablero[7][1]="|CB|";
        tablero[7][6]="|CB|";
        tablero[7][2]="|AB|";
        tablero[7][5]="|AB|";
        tablero[7][3]="|DB|";
        tablero[7][4]="|RB|";
        
        tablero[0][0]="|TN|";
        tablero[0][7]="|TN|";
        tablero[0][1]="|CN|";
        tablero[0][6]="|CN|";
        tablero[0][2]="|AN|";
        tablero[0][5]="|AN|";
        tablero[0][3]="|DN|";
        tablero[0][4]="|RN|";
    }
    
    
    public void imprimirArreglo(){
        for (int i = 0; i < tablero.length; i++) {
            System.out.print(i+" ");
            for (int j = 0; j < tablero[i].length; j++) {
                System.out.print(tablero[i][j]);
            }
            System.out.println("");
        }
        for (int i = 0; i < tablero.length; i++) {
            System.out.print("   "+i);
        }
        System.out.println("");
        System.out.println("--------------------------------");
    }
    
    //Los parametro de fil y col corresponden a la fila y la columna donde se quiere mover la ficha
    //El parametro del colorFicha es la correspondiente al turno
    private boolean validarComer(int fil, int col, char colorFicha){
       char colorFichaAComer=tablero[fil][col].charAt(2);
       if(validarDisponibilidad(fil, col)==false){
            if(colorFicha!=colorFichaAComer)
                return true;
       }
       return false;
    }
    private void comer(int fila, int columna,int turno,char tipoFicha){
        boolean obj = validarDisponibilidad(fila, columna);
        if(obj==false){
            switch (tipoFicha) {
                case 'A':
                    alf.seleccionar(fils, cols);
                    if(busquedadD(fils, fila, cols, columna)==null){
                        if(alf.comer(fila, columna, turno)!=null){
                            tablero[fila][columna]=alf.comer(fila, columna, turno);
                            movimientoI=false;
                        }
                    }else{
                        movimientoI=true;
                    }break;
                case 'C':
                    cab.seleccionar(fils, cols);
                    if(cab.comer(fila, columna, turno)!=null){
                        tablero[fila][columna]=cab.comer(fila, columna, turno);
                        movimientoI=false;
                    }else{
                        movimientoI=true;
                    }break;
                case 'P':
                    peo.seleccionar(fils, cols);
                    if(peo.comer(fila, columna, turno)!=null){
                        tablero[fila][columna]=peo.comer(fila, columna, turno);
                        movimientoI=false;
                    }else{
                        movimientoI=true;
                    }break;
                case 'D':
                    dam.seleccionar(fils, cols);
                    if(busquedadD(fils, fila, cols, columna)==null){
                        if(dam.comer(fila, columna, turno)!=null){
                            tablero[fila][columna]=dam.comer(fila, columna, turno);
                            movimientoI=false;
                        }
                    }else{
                        movimientoI=true;
                    }break;
                case 'R':
                    rey.seleccionar(fils, cols);
                    if(rey.comer(fila, columna, turno)!=null){
                        tablero[fila][columna]=rey.comer(fila, columna, turno);
                        movimientoI=false;
                    }else{
                        movimientoI=true;
                    }break;
                case 'T':
                    tor.seleccionar(fils, cols);
                    if(busquedadVH(fils, cols, fila, columna)==null){
                        if(tor.comer(fila, columna, turno)!=null){
                            tablero[fila][columna]=tor.comer(fila, columna, turno);
                            movimientoI=false;
                        }
                    }else{
                        movimientoI=true;
                    }break;
        }
        }
    }
    private void mover(int fila, int columna, int turno, char tipoFicha){
        boolean obj = validarDisponibilidad(fila, columna);
        if(obj==true){
            switch (tipoFicha) {
                case 'A':
                    alf.seleccionar(fils, cols);
                    if(busquedadD(fils, fila, cols, columna)==null){
                        if(alf.mover(fila, columna, turno)!=null){
                            tablero[fila][columna]=alf.mover(fila, columna, turno);
                            movimientoI=false;
                        }
                    }else{
                        movimientoI=true;
                    }break;
                case 'C':
                    cab.seleccionar(fils, cols);
                    if(cab.mover(fila, columna, turno)!=null){
                        tablero[fila][columna]=cab.mover(fila, columna, turno);
                        movimientoI=false;
                    }else{
                        movimientoI=true;
                    }break;
                case 'P':
                    peo.seleccionar(fils, cols);
                    //if((fils!=6||fils!=1)&&(fils+1!=fila||fils-1!=fila)){
                      //  movimientoI=true;
                    //}else 
                    if(peo.mover(fila, columna, turno)!=null){
                        tablero[fila][columna]=peo.mover(fila, columna, turno);
                        movimientoI=false;
                    }else{
                        movimientoI=true;
                    }break;
                case 'D':
                    dam.seleccionar(fils, cols);
                    if(busquedadD(fils, fila, cols, columna)==null){
                        if(dam.mover(fila, columna, turno)!=null){
                            tablero[fila][columna]=dam.mover(fila, columna, turno);
                            movimientoI=false;
                        }
                    }else{
                        movimientoI=true;
                    }break;
                case 'R':
                    rey.seleccionar(fils, cols);
                    if(rey.mover(fila, columna, turno)!=null){
                        tablero[fila][columna]=rey.mover(fila, columna, turno);
                        movimientoI=false;
                    }else{
                        movimientoI=true;
                    }break;
                case 'T':
                    tor.seleccionar(fils, cols);
                    if(busquedadVH(fils, cols, fila, columna)==null){
                        if(tor.mover(fila, columna, turno)!=null){
                            tablero[fila][columna]=tor.mover(fila, columna, turno);
                            movimientoI=false;
                        }
                    }else{
                        movimientoI=true;
                    }break;
        }
        }
    }
    
    private void seleccionarFicha(int fila, int columna, int turno){
        boolean obj = validarDisponibilidad(fila, columna);
        boolean continuar;
        char colorFicha=tablero[fila][columna].charAt(2);
        char tipoFicha=tablero[fila][columna].charAt(1);
        if((colorFicha=='N'&&turno==2)||(colorFicha=='B'&&turno==1)){//color de la ficha que seleccione corresponda al turno
            if(obj==false){//valida que la posicion que se selecciono no este vacia!
                do {
                    continuar=true;
                    System.out.print("Ingrese la Fila a la que lo desea mover: ");
                    int fil = lea.nextInt();
                    System.out.print("Ingrese la Columna a la que lo desea mover:");
                    int col = lea.nextInt();
                    if(validarComer(fil, col, colorFicha)){
                        comer(fil, col, turno, tipoFicha);
                        continuar=false;
                    }
                    if(continuar){
                        if(validarDisponibilidad(fil, col))
                            mover(fil, col, turno,tipoFicha);
                        else{
                            movimientoI=true;
                        }
                    }
                    if(movimientoI==false){
                        tablero[fila][columna]="|__|";
                        imprimirArreglo();
                    }else{
                        imprimirArreglo();
                        System.out.println("El movimiento que ingreso es invalido");
                        System.out.println("Jugador "+getTurno()+" por favor ingrese las cordenadas Correctas");
                        System.out.println("");
                       // seleccionarFicha(fila, columna, turno);
                    }    
               } while (movimientoI==true);
               cambiarTurno();
            }
        }else{
            imprimirArreglo();
            System.out.println("Existe un error, revise sus coordenadas");
        }
    }
    
    private void cambiarTurno(){
        if(getTurno()==1)
                    setTurno2();
                else
                    setTurno1();
    }
    
    //Busquedad diagonal! utilizada para saber si se puede mover el alfil
    //si, efrente de el no exsiste ningun objeto!
    //o esa es la intencion xD 
    //revisar los for!!
    //Fil1 y Col1 son los parametros de la seleccion y fil2 y col2 es el destino de a donde se quiere mover
    private String busquedadD(int fil1, int fil2, int col1, int col2){
        //borre los iguales para ver si me permite comer
        if((fil1-fil2)<0&&(col1-col2)>0){//Cuadrante tres - +
            for (int i = ++fil1; i < fil2; i++) {
                if(!"|__|".equals(tablero[i][--col1]))
                   return tablero[i][col1];
            }
        }else if((fil1-fil2)>0&&(col1-col2)>0){//cuadrante cuatro + +
            for (int i = --fil1; i > fil2; i--) {
                if(!"|__|".equals(tablero[i][--col1]))
                   return tablero[i][col1];
            }
        }else if((fil1-fil2)>0&&(col1-col2)<0){//cuadrante uno + -
            for (int i = --fil1; i>fil2; i--) {
                if(!"|__|".equals(tablero[i][++col1]))
                   return tablero[i][col1];
            }
        }
        else if((fil1-fil2)<0&&(col1-col2)<0){//cuadrante dos - -
            for (int i = ++fil1; i<fil2; i++) {
                if(!"|__|".equals(tablero[i][++col1]))
                   return tablero[i][col1];
            }
        }
        return null;
    }
    
    private String busquedadVH(int fil1, int col1, int fil2, int col2){
        if(col1==col2&&fil1-fil2>0){
            for (int i = --fil1; i>fil2; i--) {
                if(!"|__|".equals(tablero[i][col1]))
                    return tablero[i][col1];
            }
        }else if(col1==col2&&fil1-fil2<0){
            for (int i = ++fil1; i<fil2; i++) {
                if(!"|__|".equals(tablero[i][col1]))
                    return tablero[i][col1];
            }
        }else if(fil1==fil2&&col1-col2<0){
            for (int i = ++col1; i <col2; i++) {
                if(!"|__|".equals(tablero[fil1][i]))
                    return tablero[fil1][i];
            }
        }else if(fil1==fil2&&col1-col2>0){
            for (int i = --col1; i >col2; i--) {
                if(!"|__|".equals(tablero[fil1][i]))
                    return tablero[fil1][i];
            }
        }
        return null;
    }

}
