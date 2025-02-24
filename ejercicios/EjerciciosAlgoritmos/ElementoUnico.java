package EjerciciosAlgoritmos;

public class ElementoUnico {

    public static int encontrarElementoUnico(int[] arr) {
        int unico = 0;
        for (int num : arr) {
            unico ^= num; 
        }
        return unico;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 3, 2};
        int resultado = encontrarElementoUnico(arr);
        System.out.println("El elemento único es: " + resultado);
    }
}