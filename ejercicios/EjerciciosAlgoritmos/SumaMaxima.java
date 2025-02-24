package EjerciciosAlgoritmos;

public class SumaMaxima {

    public static int[] encontrarSubarregloSumaMaxima(int[] arr) {
        int maxSumaActual = arr[0];
        int maxSumaGlobal = arr[0];
        int inicio = 0, fin = 0, tempInicio = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > maxSumaActual + arr[i]) {
                maxSumaActual = arr[i];
                tempInicio = i;
            } else {
                maxSumaActual += arr[i];
            }

            if (maxSumaActual > maxSumaGlobal) {
                maxSumaGlobal = maxSumaActual;
                inicio = tempInicio;
                fin = i;
            }
        }

        int[] subarregloMaximo = new int[fin - inicio + 1];
        for (int i = inicio; i <= fin; i++) {
            subarregloMaximo[i - inicio] = arr[i];
        }

        return subarregloMaximo;
    }

    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] resultado = encontrarSubarregloSumaMaxima(arr);

        System.out.print("Salida con suma máxima: ");
        for (int num : resultado) {
            System.out.print(num + " ");
        }
    }
}