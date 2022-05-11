/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cine;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;

/**
 * Clase principal
 * @author Lila Lorenzo Martí
 * @version 1.0
 */
public class Cine {
    
    /**
     * Actualiza la sala con la información del fichero de la sala indicada
     * @param n_ruta número de la sala a cargar
     * @return llama al constructor de Sala e introduce los datos del fichero
     * @throws IOException 
     */
    public static Sala cargarSala(int n_ruta) throws IOException {
        String nombre = "sala_" + n_ruta + ".txt";
        File sala = new File(nombre);
        Scanner scan = new Scanner(sala);
        Scanner lector = new Scanner(System.in);
        Sala newsala;
        
        int filas = (int) Files.lines(sala.toPath()).count();
        int butacas = 0;
        int largo;
        String linea = "";
        String butaca;
        
        do
            if (sala.exists()) {
                linea = scan.nextLine();
                largo = linea.length();

                butacas = linea.replace(" ","").length();
                butacas = largo - butacas;
            } else {
                System.out.println("La sala seleccionada no existe, introduzca una sala válida");
                n_ruta = Integer.valueOf(lector.nextLine());
                nombre = "sala_" + n_ruta + ".txt";
                sala = new File(nombre);
            }
        while (butacas == 0);
        
        newsala = new Sala(n_ruta, filas, butacas);
        
        for(int i = 0; i < filas; i++) {
            if (i  > 0) {
                linea = scan.nextLine();
            }
            for(int j = 0; j < butacas; j++) {
                butaca = linea.substring(j * 2, j * 2 + 1);
                if (butaca.equals("1")) {
                    newsala.ocuparButaca(i, j);
                }
            }
        }
        
        return newsala;
    }

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        //Sala sala = new Sala(1, 5, 7);
        Sala sala;
        
        //sala.liberarSala();
        
        //sala.guardarSala();
        
        sala = cargarSala(2);
        
        //sala.setN_sala(3);
        
        //sala.guardarSala();
        
        System.out.println(sala.displayButaca());
    }
    
}
