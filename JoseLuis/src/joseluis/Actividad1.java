package joseluis;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Actividad1 {

    public static void main(String[] args) throws IOException {
        FileInputStream entradaDatos;
        BufferedReader lecturaDatos = null;
        BufferedWriter escrituraDatos = null;
        FileWriter escrituraMiArchivo;
        String numeroLinea;
        String [] columnas;
        String nombre, mensaje;
        int nota1, nota2, nota3, media;
        /*Declaro todas la variables que voy a usar. FileInputStream lo utilizo para leer el fichero
          BufferedReader y BufferWriter los uso para leer y escribir en el archivo. */
        
        try {
            entradaDatos = new FileInputStream("alumnosNotas.txt");
            lecturaDatos = new BufferedReader(new InputStreamReader(entradaDatos));
            escrituraMiArchivo = new FileWriter("notaMedia.txt", true);
            escrituraDatos = new BufferedWriter(escrituraMiArchivo);
            
            while ((numeroLinea = lecturaDatos.readLine()) != null){
                    columnas = numeroLinea.split(":");
                    nombre = columnas [0];
                    nota1 = Integer.parseInt(columnas[1]);
                    nota2 = Integer.parseInt(columnas[2]);
                    nota3 = Integer.parseInt(columnas[3]);
                    
                    media = (nota1 + nota2 + nota3) / 3;
                    
                    mensaje = "Nombre: " + nombre + ", Promedio: "+ media+"\n";
                    escrituraDatos.write(mensaje);
                /*Este bucle no va a parar hasta que que encuentre la variable numeroLinea vacia, la variable columnas
                  la utilizamos para separar las notas.*/
            }
            
        } catch(IOException e){
            System.out.println(e);
        }
        lecturaDatos.close();
        escrituraDatos.close();
    }
    
}
