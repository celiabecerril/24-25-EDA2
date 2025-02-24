package EjerciciosAlgoritmos;

public class ElementoMayoritario {

    public static int encontrarElementoMayoritario(int[] arr) {
        int n = arr.length;
        int candidato = arr[n / 2];

        
        int primeraPosicion = encontrarPrimeraPosicion(arr, candidato);
        int ultimaPosicion = encontrarUltimaPosicion(arr, candidato);

        if (ultimaPosicion - primeraPosicion + 1 > n / 2) {
            return candidato;
        } else {
            return -1; 
        }
    }

    private static int encontrarPrimeraPosicion(int[] arr, int objetivo) {
        int inicio = 0, fin = arr.length - 1;
        while (inicio < fin) {
            int medio = inicio + (fin - inicio) / 2;
            if (arr[medio] < objetivo) {
                inicio = medio + 1;
            } else {
                fin = medio;
            }
        }
        return inicio;
    }

    private static int encontrarUltimaPosicion(int[] arr, int objetivo) {
        int inicio = 0, fin = arr.length - 1;
        while (inicio < fin) {
            int medio = inicio + (fin - inicio + 1) / 2;
            if (arr[medio] > objetivo) {
                fin = medio - 1;
            } else {
                inicio = medio;
            }
        }
        return inicio;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1, 2, 2, 3};
        int resultado = encontrarElementoMayoritario(arr);
        if (resultado != -1) {
            System.out.println("El elemento mayoritario es: " + resultado);
        } else {
            System.out.println("No hay elemento mayoritario.");
        }
    }
}