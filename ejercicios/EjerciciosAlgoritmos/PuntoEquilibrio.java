package EjerciciosAlgoritmos;

public class PuntoEquilibrio {

    public static int encontrarPuntoEquilibrio(int[] arr) {
        int sumaTotal = 0;
        for (int num : arr) {
            sumaTotal += num;
        }

        int sumaIzquierda = 0;
        for (int i = 0; i < arr.length; i++) {
            sumaTotal -= arr[i]; 
            if (sumaIzquierda == sumaTotal) {
                return i;
            }

            sumaIzquierda += arr[i];
        }

        return -1; 
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 6};
        int resultado = encontrarPuntoEquilibrio(arr);
        if (resultado != -1) {
            System.out.println("El punto de equilibrio está en el índice: " + resultado + " (" + arr[0] + "+" + arr[1] + "+" + arr[2] + " = " + arr[4] + ")");
        } else {
            System.out.println("No se encontró un punto de equilibrio.");
        }
    }
}