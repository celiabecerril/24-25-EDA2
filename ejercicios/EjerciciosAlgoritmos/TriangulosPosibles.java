package EjerciciosAlgoritmos;

public class TriangulosPosibles {

    public static boolean esTriangulo(int a, int b, int c) {
        return (a + b > c) && (a + c > b) && (b + c > a);
    }

    public static void encontrarTriangulos(int[] arr) {
        int n = arr.length;
        boolean encontrado = false;

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (esTriangulo(arr[i], arr[j], arr[k])) {
                        System.out.println("Triángulo posible: (" + arr[i] + ", " + arr[j] + ", " + arr[k] + ")");
                        encontrado = true;
                    }
                }
            }
        }

        if (!encontrado) {
            System.out.println("No se encontraron triángulos posibles.");
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 6, 7};
        encontrarTriangulos(arr);
    }
}