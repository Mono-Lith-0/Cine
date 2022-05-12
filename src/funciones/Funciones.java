/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package funciones;

import cine.Sala;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Lila
 */
public interface Funciones {
    
    /**
     * Pide confirmación al usuario sobre si desea confirmar la acción
     * @return true si responde S y false si responde N
     */
    public static boolean confirmar() {
        Scanner scan = new Scanner(System.in);
        String input = "";
        
        do
            if (!input.equals("S") && !input.equals("N") && !input.equals("")) {
                System.out.println("Entrada no válida, por favor responda con \"S\" o \"N\":");
                input = scan.nextLine();
            } else {
                System.out.println("¿Desea realizar esta acción? (\"S\" para sí, \"N\" para no):");
                input = scan.nextLine();
            }
        while (!input.equals("S") && !input.equals("N"));
        
        return input.equals("S");
    }
    
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
    
    public static Map candidatas(Map master, int personas) {
        Map dummy = master;
        
        for (var fila : dummy.entrySet()) {
            
        }
        
        return dummy;
    }
}
