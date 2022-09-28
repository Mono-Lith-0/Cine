/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cine;

import funciones.*;
import java.io.File;
import java.util.Map;
import java.io.IOException;
import java.util.Scanner;

/**
 * Clase principal
 * @author Lila Lorenzo Martí
 * @version 1.0
 */
public class Cine {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        
        int count_salas = new File("./Salas").list().length;
        int opcion;
        Scanner scan = new Scanner(System.in);
           
        System.out.println("ConsoleCinema\n");
        
        // Este println es temporar para testear count_salas
        System.out.println("El número de salas es " + count_salas);
        
        do {
            
            System.out.println(Menu.displayMenu());
            opcion = Integer.valueOf(scan.nextLine());
            
            switch (opcion) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 0:
                    System.out.println("El programa ha sido cerrado");
                    break;
                default:
                   System.out.println("La orden introducida no está disponible, por favor seleccione otra:");
            }
        } while (opcion != 0);
    }
    
}
