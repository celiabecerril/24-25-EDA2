package EjerciciosAlgoritmos;

public class CasiOrdenado {

    public static void ordenarCasiOrdenado(int[] arr, int k) {
        int n = arr.length;
        int[] resultado = new int[n];
        int[] heap = new int[k + 1];
        int heapSize = 0;

        
        for (int i = 0; i <= k && i < n; i++) {
            insertarEnHeap(heap, heapSize++, arr[i]);
        }

        int index = 0;
        for (int i = k + 1; i < n; i++) {
            resultado[index++] = extraerMinimo(heap, heapSize--);
            insertarEnHeap(heap, heapSize++, arr[i]);
        }

       
        while (heapSize > 0) {
            resultado[index++] = extraerMinimo(heap, heapSize--);
        }

        
        for (int i = 0; i < n; i++) {
            arr[i] = resultado[i];
        }
    }

    private static void insertarEnHeap(int[] heap, int heapSize, int valor) {
        heap[heapSize] = valor;
        int i = heapSize;
        while (i > 0 && heap[i] < heap[(i - 1) / 2]) {
            int temp = heap[i];
            heap[i] = heap[(i - 1) / 2];
            heap[(i - 1) / 2] = temp;
            i = (i - 1) / 2;
        }
    }

    private static int extraerMinimo(int[] heap, int heapSize) {
        int min = heap[0];
        heap[0] = heap[heapSize - 1];
        int i = 0;
        while (i * 2 + 1 < heapSize - 1) {
            int hijoIzquierdo = i * 2 + 1;
            int hijoDerecho = i * 2 + 2;
            int menorHijo = hijoIzquierdo;
            if (hijoDerecho < heapSize - 1 && heap[hijoDerecho] < heap[hijoIzquierdo]) {
                menorHijo = hijoDerecho;
            }
            if (heap[i] <= heap[menorHijo]) {
                break;
            }
            int temp = heap[i];
            heap[i] = heap[menorHijo];
            heap[menorHijo] = temp;
            i = menorHijo;
        }
        return min;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 3, 5, 4};
        int k = 2;
        ordenarCasiOrdenado(arr, k);
        System.out.print("Array ordenado: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}