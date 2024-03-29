/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package funciones;

import cine.Sala;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Lila
 */
public interface Funciones {
    
    /**
     * Pide confirmación al usuario sobre si desea confirmar la acción
     * @return true
     */
    public static boolean confirmar() {
        Scanner scan = new Scanner(System.in);
        String input = "";
        
        // comprueba que la entrada sea "S" o "N"
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
     * Crea una nueva sala, y le dará como número el número de salas creadas más uno,
     * el usuario rellenará por terminal los datos de esta
     * @return
     * @throws IOException 
     */
    public static Sala crearSala() throws IOException {
        Scanner scan = new Scanner(System.in);
        int n_sala;
        int n_filas;
        int n_butacas;
        
        System.out.println("Indique el número de la sala:");
        n_sala = Integer.parseInt(scan.nextLine());
        
        System.out.println("Indique el número de filas de la sala " + n_sala + ":");
        n_filas = Integer.parseInt(scan.nextLine());
        
        System.out.println("Indique el número de butacas por fila de la sala " + n_sala + ":");
        n_butacas = Integer.parseInt(scan.nextLine());
        
        Sala sala = new Sala(n_sala, n_filas, n_butacas);
        if (sala.guardarSala()) {
            System.out.println("Sala " + n_sala + " ha sido guardada correctamente con " +
                    n_filas + " filas y " + n_butacas + " butacas por fila");
        } else {
            System.out.println("Ha habido un error al guardar la sala " + n_sala +
                    ", inténtelo de nuevo");
        }
        
        return sala;
    }
    
    public static void displaySalas() {
        File[] salas = new File("./Salas").listFiles();
        String output = "Lista de salas guardadas:\n";
        
        Arrays.sort(salas);
        
        for (File file : salas) {
            output += " " + file.getPath().substring(13, 14);
        }
       
        System.out.println(output);
    }
    
    /**
     * Actualiza la sala con la información del fichero de la sala indicada
     * @param n_ruta número de la sala a cargar
     * @return Sala
     * @throws IOException 
     */
    public static Sala cargarSala(int n_ruta) throws IOException {
        /*
        nombre : ruta relativa del fichero de la sala
        sala: objeto tipo File sobre el que se trabajará
        scan: lector del fichero
        lector: lector de la consola
        newsala: nuevo objeto tipo Sala que será cargada
        filas: número de filas de la sala
        butacas: número de butacas de la sala
        largo: longitud de la línea del fichero
        linea: línea del fichero leída
        butaca: substring de la línea que hace referencia a una sola butaca
        */
        String nombre = "./Salas/sala_" + n_ruta + ".txt";
        File sala = new File(nombre);
        Scanner scan = new Scanner(sala);
        Scanner lector = new Scanner(System.in);
        Sala newsala;
            // cuenta cuántas líneas tiene el fichero
        int filas = (int) Files.lines(sala.toPath()).count();
        int butacas = 0;
        int largo;
        String linea = "";
        String butaca;
        
        // comprueba si la sala existe, y si no existe pedirá una nueva
        do
            // si existe se lee la primera fila y se cuéntan cuántas butacas hay
            if (sala.exists()) {
                linea = scan.nextLine();
                largo = linea.length();

                butacas = linea.replace(" ","").length();
                butacas = largo - butacas;
            } else {
                System.out.println("La sala seleccionada no existe, introduzca una sala válida");
                n_ruta = Integer.parseInt(lector.nextLine());
                nombre = "./Salas/sala_" + n_ruta + ".txt";
                sala = new File(nombre);
            }
        while (butacas == 0);
        
        // se crea la nueva sala a partir de los datos del fichero
        newsala = new Sala(n_ruta, filas, butacas);
        
        // se comprueba qué butacas están ocupadas
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
     * Comprueba si los números de un ArrayList son contiguos, y si los que sí
     * lo sean como mínimo deben ser "personas" seguidos
     * @param numero ArrayList de enteros a comprobar
     * @param personas Mínimo de contíguos necesarios
     * @return ArrayList\<Integer\>
     */
    public static ArrayList<Integer> contiguo(ArrayList<Integer> numero, int personas) {
        /*
        temporal: ArrayList utilizado para comprobar los datos válidos antes de
            su inserción en permanente y que puede ser borrado
        permanente: ArrayList con los datos definivos y que se va a devolver
        contador: contador de contíguos
        */
        ArrayList<Integer> temporal = new ArrayList<>();
        ArrayList<Integer> permanente = new ArrayList<>();
        int contador = 0;
        
        /*
        para cada iteración del bucle se comprueba si es un número contíguo y si
        lo es lo añade a temporal, y si no lo es se limpia temporal y se resetea
        contador, una vez tengamos suficientes coincidencias se añaden a
        permanente
        */
        for (int i = 0; i < numero.size(); i++) {
            if (i == 0) {
                if (numero.get(i) == numero.get(i + 1) - 1) {
                    temporal.add(numero.get(i));
                    contador++;
                } else {
                    temporal.clear();
                    contador = 0;
                }
            } else if (i > 0 && i < numero.size() - 1) {
                if (numero.get(i) == numero.get(i + 1) - 1 | numero.get(i) == numero.get(i - 1) + 1) {
                    temporal.add(numero.get(i));
                    contador++;
                } else {
                    temporal.clear();
                    contador = 0;
                }
            } else if (i == numero.size() - 1) {
                if (numero.get(i) == numero.get(i - 1) + 1) {
                    temporal.add(numero.get(i));
                    contador++;
                } else {
                    temporal.clear();
                    contador = 0;
                }
            }
            
            if (contador >= personas) {
                permanente.addAll(temporal);
                temporal.clear();
            }
        }
        return permanente;
    }
    
    /**
     * Comprueba qué butacas son candidatas para las personas introducidas
     * @param mapa Mapa de butacas libres de la sala
     * @param personas Número de personas que necesitan butaca
     * @return Map
     * @see #contiguo(java.util.ArrayList, int) 
     */
    public static Map candidatas(Map mapa, int personas) {
        // editable: versión editable de mapa y que se va a devolver
        Map<Integer, ArrayList<Integer>> editable = mapa;
        
        // si solo se buscan butacas para una persona no hace nada
        if (personas > 1) {
            // para cada entrada de editable se le aplica contiguo();
            for (int i = 0; i < editable.size(); i++) {
                if (editable.containsKey(i)) {
                    editable.put(i, contiguo(editable.get(i), personas));
                
                    if (editable.get(i).isEmpty()) {
                        editable.remove(i);
                    }
                }
            }
        }
        
        return editable;
    }
}
