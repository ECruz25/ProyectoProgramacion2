package proyectoprogramacion2;

import java.util.Scanner;

/**
 * @author EdwinCruz
 */
public class Tablero {
    //static Piezas
    static String tablero[][]=new String[8][8];
    static Scanner lea=new Scanner(System.in);
    static int fils, cols, turns;
    static Piezas alf=new Alfil();
    static Piezas cab=new Caballo();
    static Piezas peo=new Peon();
    static Piezas dam=new Reina();
    static Piezas rey=new Rey();
    static Piezas tor=new Torre();
    static boolean movimientoI;
    public static void main(String[] args) {
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
                    imprimirArreglo();
                }catch(Exception e){
                    System.out.println("las cordenadas ingresadas son incorrectas!");
                }
        } while (true);
            
    }
    private static void setTurno1(){
        turns=1;
    }
    private static void setTurno2(){
        turns=2;
    }
    private static int getTurno(){
        return turns;
    }
    
    //Valida si la posicion a donde se quiere mover esta disponible
    //Si en esa posicion esta: |┼| es porque no hay nada y puede mover.
    private static boolean validarDisponibilidad(int fila,int columna){
        if(tablero[fila][columna].equals("|__|"))
            return true;
        return false;
    }
    
    public static void iniciarElTablero(){
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
    
    
    public static void imprimirArreglo(){
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
    
    
    public static void mover(int fila, int columna, int turno, char tipoFicha){
        boolean obj = validarDisponibilidad(fila, columna);
        if(obj==true){
            switch (tipoFicha) {
                case 'A':
                    alf.seleccionar(fils, cols);
                    if(alf.mover(fila, columna, turno)!=null){
                        tablero[fila][columna]=alf.mover(fila, columna, turno);
                        movimientoI=false;
                    }else
                        movimientoI=true;
                    break;
                case 'C':
                    cab.seleccionar(fils, cols);
                    if(cab.mover(fila, columna, turno)!=null){
                        tablero[fila][columna]=cab.mover(fila, columna, turno);
                        System.out.println("movio el caballo");
                        movimientoI=false;
                    }else
                        
                        movimientoI=true;
                    break;
                case 'P':
                    peo.seleccionar(fils, cols);
                    if(peo.mover(fila, columna, turno)!=null){
                        tablero[fila][columna]=peo.mover(fila, columna, turno);
                        movimientoI=false;
                    }else
                        movimientoI=true;
                    break;
                case 'D':
                    dam.seleccionar(fils, cols);
                    if(dam.mover(fila, columna, turno)!=null){
                        tablero[fila][columna]=dam.mover(fila, columna, turno);
                        movimientoI=false;
                    }else
                        movimientoI=true;
                    break;
                case 'R':
                    rey.seleccionar(fils, cols);
                    if(rey.mover(fila, columna, turno)!=null){
                        tablero[fila][columna]=rey.mover(fila, columna, turno);
                        movimientoI=false;
                    }else
                        movimientoI=true;
                    break;
                case 'T':
                    tor.seleccionar(fils, cols);
                    if(tor.mover(fila, columna, turno)!=null){
                        tablero[fila][columna]=tor.mover(fila, columna, turno);
                        movimientoI=false;
                    }else
                        movimientoI=true;
                    break;
        }
        }
    }
    
    public static void seleccionarFicha(int fila, int columna, int turno){
        boolean obj = validarDisponibilidad(fila, columna);
        char colorFicha=tablero[fila][columna].charAt(2);
        char tipoFicha=tablero[fila][columna].charAt(1);
        if((colorFicha=='N'&&turno==2)||(colorFicha=='B'&&turno==1)){
            if(obj==false){
                do {
                    System.out.print("Ingrese la Fila a la que lo desea mover: ");
                    int fil = lea.nextInt();
                    System.out.print("Ingrese la Columna a la que lo desea mover:");
                    int col = lea.nextInt();
                    mover(fil, col, turno,tipoFicha);
                    if(movimientoI==false)
                        tablero[fila][columna]="|__|";
                    else{
                        System.out.println("Jugador "+getTurno()+" por favor ingrese las cordenadas Correctas");
                        System.out.println("");
                    }    
                } while (movimientoI==true);
                if(getTurno()==1)
                    setTurno2();
                else
                    setTurno1();
            }
        }else
            System.out.println("Es el turno del otro jugador!");
    }
    
    //Busquedad diagonal! utilizada para saber si se puede mover el alfil
    //si, efrente de el no exsiste ningun objeto!
    //o esa es la intencion xD 
    //revisar los for!!
    private static String busquedadD(int fil1, int fil2, int col1, int col2){
        if((fil1-fil2)<0&&(col1-col2)>0){
            for (int i = ++fil1; i < fil2; i++) {
                if(tablero[i][--col1]!="|__|")
                   return tablero[i][col1];
            }
        }else if((fil1-fil2)>0&&(col1-col2)>0){
            for (int i = ++fil1; i < fil2; i++) {
                if(tablero[i][++col1]!="|__|")
                   return tablero[i][col1];
            }
        }else if((fil1-fil2)>0&&(col1-col2)<0){
            for (int i = --fil1; i<=fil2; i--) {
                if(tablero[i][++col1]!="|__|")
                   return tablero[i][col1];
            }
        }
        else if((fil1-fil2)<0&&(col1-col2)<0){
            for (int i = ++fil1; i>=fil2; i++) {
                if(tablero[i][++col1]!="|__|")
                   return tablero[i][col1];
            }
        }
        return null;
    }

}
