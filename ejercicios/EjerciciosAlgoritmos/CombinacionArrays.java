package EjerciciosAlgoritmos;

public class CombinacionArrays {

    public static int[] combinarArrays(int[][] arrays) {
        int totalElementos = 0;
        for (int i = 0; i < arrays.length; i++) {
            totalElementos += arrays[i].length;
        }

        int[] resultado = new int[totalElementos];
        int[] indices = new int[arrays.length];
        int indiceResultado = 0;

        while (indiceResultado < totalElementos) {
            int minValor = Integer.MAX_VALUE;
            int minIndice = -1;

            for (int i = 0; i < arrays.length; i++) {
                if (indices[i] < arrays[i].length && arrays[i][indices[i]] < minValor) {
                    minValor = arrays[i][indices[i]];
                    minIndice = i;
                }
            }

            resultado[indiceResultado++] = minValor;
            indices[minIndice]++;
        }

        return resultado;
    }

    public static void main(String[] args) {
        int[][] arrays = {
            {1, 4, 7},
            {2, 5, 8},
            {3, 6, 9}
        };

        int[] resultado = combinarArrays(arrays);
        System.out.print("Array combinado: ");
        for (int num : resultado) {
            System.out.print(num + " ");
        }
    }
}
