/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package funciones;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author Lila
 */
public interface Menu {
    
    public static String displayMenu(){
        String texto = "";

        texto += "1 -Crear nueva sala\n";
        texto += "2 -Cargar sala existente\n";
        texto += "3 -Mostrar el mapa de butacas\n";
        texto += "4 -Buscar butacas libres\n";
        texto += "5 -Asignar butacas\n";
        texto += "6 -Vaciar sala\n";
        texto += "7 -Abrir ayuda\n";
        texto += "0 -Cerrar programa";
        
        return texto;
    }
    
    public static int checkEntero(String entrada) {
        Scanner scan = new Scanner(System.in);
        
        while (!entrada.matches("^[0-9]+$")) {
            System.out.println("El término introducido no es un número entero");
            System.out.println("por favor introduzca un término válido:");
            entrada = scan.nextLine();
        }
        
        return Integer.valueOf(entrada);
    }
    
    public static void nuevaSala() {
        Scanner scan = new Scanner(System.in);
        int n_sala;
        int n_filas;
        int n_butacas;
        
        System.out.println("Indique el número de la nueva sala");
    }
}
