package proyectoprogramacion2;

import java.util.Scanner;

/**
 * @author EdwinCruz
 */
public class Tablero {
    //static Piezas
        static String tablero[][]=new String[8][8];
        static Scanner lea=new Scanner(System.in);
        static Piezas x = new Peon();
        static int fils, cols, turns;
    public static void main(String[] args) {
            iniciarElTablero();
            imprimirArreglo();
            setTurno1();
            do {            
                System.out.print("Ingrese la Fila: ");
                fils=lea.nextInt();
                System.out.print("Ingrese la Columna: ");
                cols=lea.nextInt();
                seleccionarFicha(fils, cols, getTurno());
                
                
                imprimirArreglo();
        } while (fils!=-1&&cols!=-1);
            
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
        if(tablero[fila][columna].equals("|┼|"))
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
    
    
    public static void mover(int fila, int columna, int turno){
        boolean obj = validarDisponibilidad(fila, columna);
        if(obj==true){
           if(x.mover(fila, columna, turno)!=null)
            tablero[fila][columna]=x.mover(fila, columna, turno);
           else
                System.out.println("movimiento invalido");
            
        }
    }
    
    public static void seleccionarFicha(int fila, int columna, int turno){
        boolean obj = search(fila, columna);
        if(obj==false){
            tablero[fila][columna]="|┼|";
            System.out.println("Que fila? ");
            int fil = lea.nextInt();
            System.out.println("Que columna? ");
            int col = lea.nextInt();
            mover(fil, col, turno);
            validarTurno(fila, columna, turno);
        }
    }
    
    public static boolean validarTurno(int fila, int columna, int turno){
        if(turno%2==0&&tablero[fila][columna].charAt(1)=='N')
            return false;
        return true;
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
