/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyectoprogramacion2;

import java.util.Scanner;

/**
 *
 * @author Daniel Perez
 */
public final class Menu extends Tablero{
    
    public static void main(String[] args) {
        Tablero obj=new Tablero();
        Scanner lea = new Scanner(System.in);
        int opc, salir=0;
        do {
            System.out.println("Menu Principal");
            System.out.println("1. Jugar Ajedrez");
            System.out.println("2. Estadisticas de Juegos");
            System.out.println("3. Salir");
            System.out.print("Ingrese una opcion: ");
            opc=lea.nextInt();
            switch (opc) {
                case 1:
                    obj.jugarAjedrez();
                    break;
                case 2:    
                    System.out.println("Estadisticas");
                    break;
                case 3:
                    System.out.print("Estas seguro de que quieres salir? 1.Si/2.No : ");
                    salir=lea.nextInt();
                default:
                    System.out.println("La opcion es invalida ");;
            }
            
        } while (salir!=1);
    }
}
