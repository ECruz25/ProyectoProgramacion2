package proyectoprogramacion2;

import java.util.Scanner;

/**
 * @author EdwinCruz
 */
public class Tablero {
    //static Piezas
        static String tablero[][]=new String[8][8];
        static Scanner lea=new Scanner(System.in);
    public static void main(String[] args) {
            iniciarElTablero();
             imprimirArreglo();
    }
    private static boolean search(int fila,int columna){
        if(tablero[fila-1][columna-1].equals("|_|")){
            return true;
        }
        return false;
    }
    
    
    public static void iniciarElTablero(){
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                tablero[i][j]="|┼|";
                //░
            }
        }
        for (int i = 0; i < tablero[1].length; i++) {
            tablero[1][i]="|♟|";        
        }
        for (int i = 0; i < tablero[6].length; i++) {
            tablero[6][i]="|♙|";
        }
        tablero[7][0]="|♖|";
        tablero[7][7]="|♖|";
        tablero[7][1]="|♘|";
        tablero[7][6]="|♘|";
        tablero[7][2]="|♗|";
        tablero[7][5]="|♗|";
        tablero[7][3]="|♕|";
        tablero[7][4]="|♔|";
        
        tablero[0][0]="|♜|";
        tablero[0][7]="|♜|";
        tablero[0][1]="|♞|";
        tablero[0][6]="|♞|";
        tablero[0][2]="|♝|";
        tablero[0][5]="|♝|";
        tablero[0][3]="|♛|";
        tablero[0][4]="|♚|";
    }
    
    
    public static void imprimirArreglo(){
        for (int i = 0; i < tablero.length; i++) {
            System.out.print(i+" ");
            for (int j = 0; j < tablero[i].length; j++) {
                System.out.print(tablero[i][j]);
            }
            System.out.println("");
        }
        System.out.println("   0   1   2  3   4  5   6  7");
        System.out.println("--------------------------------");
    }
    
    
    public static void mover(int fila, int columna){
        boolean obj = search(fila, columna);
        if(obj==true){
            //tablero[fila-1][columna-1]=x.InicializarN();
            
        }
    }
    
    public static void seleccionar(int fila, int columna){
        boolean obj = search(fila, columna);
        if(obj==false){
            tablero[fila-2][columna-1]="|__|";
            System.out.println("Que fila? ");
            fila = lea.nextInt();
            System.out.println("Que columna? ");
            columna = lea.nextInt();
            mover(fila, columna);
        }
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
