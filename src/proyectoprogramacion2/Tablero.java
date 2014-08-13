package proyectoprogramacion2;
import proyectoprogramacion2.Piezas;

/**
 * @author EdwinCruz
 */
public class Tablero {
    //static Piezas
        static String tablero[][]=new String[8][8];
        static Piezas x=new Peon();
        static Peon z = new Peon();
    public static void main(String[] args) {
//        System.out.println("1  2  3  4  5  6  7  8    ");
//        System.out.println("TN CN AN KN QN AN CN TN  8");
//        System.out.println("PN PN PN PN PN PN PN PN  7");
//        System.out.println("__ __ __ __ __ __ __ __  6");
//        System.out.println("__ __ __ __ __ __ __ __  5");
//        System.out.println("__ __ __ __ __ __ __ __  4");
//        System.out.println("__ __ __ __ __ __ __ __  3");
//        System.out.println("PB PB PB PB PB PB PB PB  2");
//        System.out.println("TB CB AB KB QB AB CB TB  1");;
        
        INICIAR_ARREGLO();
        for (int i = 0; i < tablero[1].length; i++) {
            tablero[1][i]=x.InicializarN();
        }
        
        for (int i = 0; i < tablero[6].length; i++) {
            tablero[6][i]=x.InicializarB();
        }
        
        IMPRIMIR_ARREGLO();
        
        mover(3, 5);
        
        IMPRIMIR_ARREGLO();
        
        
        
        
       
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
            tablero[fila-1][columna-1]=x.InicializarN();
            
        }
    }

}