import java.util.Arrays;
import java.util.Scanner;

/**
 * Clase que contiene un programa para generar todos los números primos desde 1 hasta un número máximo especificado por el usuario.
 */
public class Main {

    /**
     * Método principal que se encarga de solicitar el número máximo y de imprimir el resultado generado por el método generarPrimos().
     * @param args Argumentos de línea de comando.
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce el número para la criba de Erastótenes:");
        int dato = teclado.nextInt();
        int[] vector = generarPrimos(dato);
        System.out.println("\nVector de primos hasta:" + dato);
        imprimirVector(vector);
    }

    /**
     * Método que genera un vector con los números primos desde 1 hasta un número máximo especificado.
     * @param max Numero máximo hasta el cual se generarán los números primos.
     * @return Un vector con los números primos desde 1 hasta max.
     */
    public static int[] generarPrimos(int max) {
        boolean[] esPrimo = new boolean[max + 1];
        Arrays.fill(esPrimo, true);
        esPrimo[0] = esPrimo[1] = false;

        for (int i = 2; i <= Math.sqrt(max); i++) {
            if (esPrimo[i]) {
                for (int j = i * i; j <= max; j += i) {
                    esPrimo[j] = false;
                }
            }
        }

        int cuenta = 0;
        for (int i = 0; i < esPrimo.length; i++) {
            if (esPrimo[i]) {
                cuenta++;
            }
        }

        int[] primos = new int[cuenta];
        for (int i = 0, j = 0; i < esPrimo.length; i++) {
            if (esPrimo[i]) {
                primos[j++] = i;
            }
        }

        return primos;
    }

    /**
     * Método que imprime un vector en la consola, mostrando 10 elementos por línea.
     * @param vector Vector que se desea imprimir.
     */
    public static void imprimirVector(int[] vector) {
        for (int i = 0; i < vector.length; i++) {
            if (i % 10 == 0)
                System.out.println();
            System.out.print(vector[i] + "\t");
        }
    }
}
