package EjerciciosAlgoritmos;

public class SumaObjetivo {

    public static int[] encontrarIndices(int[] numeros, int objetivo) {
        
        int[] indices = new int[numeros.length];
        for (int i = 0; i < numeros.length; i++) {
            indices[i] = -1; 
        }

        for (int i = 0; i < numeros.length; i++) {
            int complemento = objetivo - numeros[i];
            
            for (int j = 0; j < i; j++) {
                if (indices[j] != -1 && numeros[j] == complemento) {
                    return new int[]{j, i};
                }
            }
           
            indices[i] = numeros[i];
        }

       
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] numeros = {3, 2, 9, 8};
        int objetivo = 10;
        int[] resultado = encontrarIndices(numeros, objetivo);

        if (resultado.length == 0) {
            System.out.println("No se encontraron índices que sumen el objetivo.");
        } else {
            System.out.println("Índices: [" + resultado[0] + ", " + resultado[1] + "] (" + numeros[resultado[0]] + " + " + numeros[resultado[1]] + " = " + objetivo + ")");
        }
    }
}