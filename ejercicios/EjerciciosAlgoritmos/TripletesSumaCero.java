package EjerciciosAlgoritmos;

public class TripletesSumaCero {

    public static void encontrarTripletes(int[] arr) {
        int n = arr.length;
        boolean encontrado = false;

    
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        for (int i = 0; i < n - 2; i++) {
       
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }

            int izquierda = i + 1;
            int derecha = n - 1;

            while (izquierda < derecha) {
                int suma = arr[i] + arr[izquierda] + arr[derecha];

                if (suma == 0) {
                    System.out.println("Triplete encontrado: (" + arr[i] + ", " + arr[izquierda] + ", " + arr[derecha] + ")");
                    encontrado = true;

                   
                    while (izquierda < derecha && arr[izquierda] == arr[izquierda + 1]) {
                        izquierda++;
                    }
                    while (izquierda < derecha && arr[derecha] == arr[derecha - 1]) {
                        derecha--;
                    }

                    izquierda++;
                    derecha--;
                } else if (suma < 0) {
                    izquierda++;
                } else {
                    derecha--;
                }
            }
        }

        if (!encontrado) {
            System.out.println("No se encontraron tripletes que sumen a cero.");
        }
    }

    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        encontrarTripletes(arr);
    }
} 