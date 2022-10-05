/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cine;

import funciones.*;
import java.io.File;
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
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        
        Sala sala = new Sala();
        //int count_salas = new File("./Salas").list().length;
        int opcion;
        int selector;
        Scanner scan = new Scanner(System.in);
           
        System.out.println("ConsoleCinema\n");
        
        do {
            if (sala.getN_sala() > 0) {
                System.out.println("Sala " + sala.getN_sala() + " seleccionada.\n");
            } else {
                System.out.println("No hay ninguna sala seleccionada\n");
            }
            System.out.println(Menu.displayMenu());
            opcion = Integer.parseInt(scan.nextLine());
            
            switch (opcion) {
                case 1:
                    Funciones.crearSala();
                    break;
                case 2:
                    Funciones.displaySalas();
                    System.out.println("¿Qué sala desea cargar?:");
                    selector = Integer.parseInt(scan.nextLine());
                    sala = Funciones.cargarSala(selector);
                    selector = 0;
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
