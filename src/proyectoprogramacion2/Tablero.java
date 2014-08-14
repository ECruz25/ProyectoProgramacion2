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
          
        
        
       
////        Reina n=new Reina() {};
//        
//        System.out.println(n.moverB(38, 39));
        
    }
    private static boolean search(int fila,int columna){
        if(tablero[fila-1][columna-1].equals("|__|")){
            return true;
        }
        return false;
    }
    
    
    public static void INICIAR_ARREGLO(){
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                tablero[i][j]="|__|";
            }
        }
    }
    
    
    public static void IMPRIMIR_ARREGLO(){
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                System.out.print(tablero[i][j]);
            }
            System.out.println("");
        }
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
