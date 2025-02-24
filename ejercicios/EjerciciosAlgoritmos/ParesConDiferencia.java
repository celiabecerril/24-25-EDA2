package EjerciciosAlgoritmos;

public class ParesConDiferencia {

    public static void encontrarParesConDiferencia(int[] arr, int[] ks) {
        int n = arr.length;

        for (int k : ks) {
            boolean encontrado = false;
            System.out.println("Buscando pares con diferencia " + k + ":");

            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (Math.abs(arr[i] - arr[j]) == k) {
                        System.out.println("Par encontrado: (" + arr[i] + ", " + arr[j] + ")");
                        encontrado = true;
                    }
                }
            }

            if (!encontrado) {
                System.out.println("No se encontraron pares con diferencia " + k);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 7, 5, 9, 2, 12, 3};
        int[] ks = {2, 4};
        encontrarParesConDiferencia(arr, ks);
    }
}