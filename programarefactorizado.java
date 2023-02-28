import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce el número para la criba de Erastótenes:");
        int dato = teclado.nextInt();
        int[] vector = generarPrimos(dato);
        System.out.println("\nVector de primos hasta:" + dato);
        imprimirVector(vector);
    }

    // Generar números primos de 1 a max
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

    public static void imprimirVector(int[] vector) {
        for (int i = 0; i < vector.length; i++) {
            if (i % 10 == 0)
                System.out.println();
            System.out.print(vector[i] + "\t");
        }
    }
}


/*
El programa ha sido arreglado para que funcione igual, pero con un código más fácil de leer. Los cambios mas importantes son:

Se ha eliminado una parte del codigo que no era necesaria.
Se ha creado una función para imprimir el resultado para que sea más facil de entender
Se ha utilizado un método para crear una lista de números primos en lugar de crear un vector grande y complicado.
Se ha cambiado un bucle para que se pare cuando se llegue a la raíz cuadrada del número que se está buscando
Se ha utilizado otro bucle para recorrer todos los números en la lista y comprobar si son primos.
