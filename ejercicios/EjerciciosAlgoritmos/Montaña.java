package EjerciciosAlgoritmos;

public class Montaña {

    public static boolean esMontaña(int[] arr) {
        if (arr.length < 3) {
            return false;
        }

        int i = 0;

        while (i + 1 < arr.length && arr[i] < arr[i + 1]) {
            i++;
        }

        if (i == 0 || i == arr.length - 1) {
            return false;
        }

        while (i + 1 < arr.length && arr[i] > arr[i + 1]) {
            i++;
        }

        return i == arr.length - 1;
    }

    public static int encontrarPico(int[] arr) {
        int inicio = 0, fin = arr.length - 1;

        while (inicio < fin) {
            int medio = inicio + (fin - inicio) / 2;

            if (arr[medio] < arr[medio + 1]) {
                inicio = medio + 1;
            } else {
                fin = medio;
            }
        }

        return inicio;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 3, 5, 4, 2 };

        boolean resultado = esMontaña(arr);
        System.out.println("El array es una montaña: " + resultado);

        if (resultado) {
            int pico = encontrarPico(arr);
            System.out.println("El punto más alto está en el índice: " + pico);
        }
    }
}