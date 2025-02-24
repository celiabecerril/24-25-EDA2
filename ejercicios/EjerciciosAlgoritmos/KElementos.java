package EjerciciosAlgoritmos;

public class KElementos {

    public static int[] encontrarKElementosMasCercanos(int[] arr, int k, double target) {
        int n = arr.length;
        int[] resultado = new int[k];
        double[] distancias = new double[n];

        for (int i = 0; i < n; i++) {
            distancias[i] = Math.abs(arr[i] - target);
        }

        for (int i = 0; i < k; i++) {
            int minIndice = -1;
            double minDistancia = Double.MAX_VALUE;

            for (int j = 0; j < n; j++) {
                if (distancias[j] < minDistancia) {
                    minDistancia = distancias[j];
                    minIndice = j;
                }
            }

            resultado[i] = arr[minIndice];
            distancias[minIndice] = Double.MAX_VALUE;
        }

        return resultado;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        int k = 2;
        double target = 3.7;
        int[] resultado = encontrarKElementosMasCercanos(arr, k, target);

        System.out.print("Los " + k + " elementos más cercanos a " + target + " son: ");
        for (int num : resultado) {
            System.out.print(num + " ");
        }
    }
}