package EjerciciosAlgoritmos;

public class ContadorDeInversiones {

    public static int contarInversiones(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return contarInversiones(arr, 0, arr.length - 1);
    }

    private static int contarInversiones(int[] arr, int izquierda, int derecha) {
        if (izquierda >= derecha) {
            return 0;
        }
        int medio = izquierda + (derecha - izquierda) / 2;
        int inversiones = contarInversiones(arr, izquierda, medio) + contarInversiones(arr, medio + 1, derecha);
        inversiones += merge(arr, izquierda, medio, derecha);
        return inversiones;
    }

    private static int merge(int[] arr, int izquierda, int medio, int derecha) {
        int[] temp = new int[derecha - izquierda + 1];
        int i = izquierda, j = medio + 1, k = 0, inversiones = 0;

        while (i <= medio && j <= derecha) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                inversiones += (medio - i + 1); // Todos los elementos restantes en la mitad izquierda son inversiones
            }
        }

        while (i <= medio) {
            temp[k++] = arr[i++];
        }

        while (j <= derecha) {
            temp[k++] = arr[j++];
        }

        System.arraycopy(temp, 0, arr, izquierda, temp.length);
        return inversiones;
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 3, 5};
        int resultado = contarInversiones(arr);
        System.out.println("Número de inversiones: " + resultado);
    }
}