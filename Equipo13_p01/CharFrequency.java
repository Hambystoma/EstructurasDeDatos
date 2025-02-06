import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CharFrequency {
    public static void main(String[] args) {
        String archivo = "random_text_200k.txt";
        String cadena = "";

        // En esta parte se lee el archivo
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            cadena = br.readLine();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
            return;
        }

        if (cadena == null || cadena.isEmpty()) {
            System.out.println("El archivo está vacío.");
            return;
        }

        int n = cadena.length();
        int umbral = n / 3; // Los datos

        char[] caracteres = cadena.toCharArray();
        boolean[] contados = new boolean[256];

        long inicioTiempo = System.currentTimeMillis(); // Inicia
        for (int i = 0; i < n; i++) {
            char actual = caracteres[i];
            if (contados[actual]) continue;

            int contador = 0;
            for (int j = 0; j < n; j++) {
                if (caracteres[j] == actual) {
                    contador++;
                }
            }

            if (contador >= umbral) {
                long finTiempo = System.currentTimeMillis(); // Finaliza 
                System.out.println("El caracter '" + actual + "' aparece " + contador + " veces.");
                System.out.println("Tiempo de ejecución: " + (finTiempo - inicioTiempo) + " ms.");
                return;
            }

            contados[actual] = true;
        }

        long finTiempo = System.currentTimeMillis(); // Finaliza 
        System.out.println("No hay caracteres que aparezcan al menos " + umbral + " veces.");
        System.out.println("Tiempo de ejecución: " + (finTiempo - inicioTiempo) + " ms.");
    }
}
