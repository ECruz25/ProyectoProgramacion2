package proyectoprogramacion2;

import java.util.*;

public final class Estadisticas {
    
    static ArrayList <String> estadisticas =new ArrayList<>();
    public static void estadisticas(String m){
        estadisticas.add(m);
    }

    public static String getEstadisticas(int x) {
        if(x==10){
            estadisticas.get(x);
            return x + ". " + getEstadisticas(x++);
        }
        return "";
    }
    
    
}
