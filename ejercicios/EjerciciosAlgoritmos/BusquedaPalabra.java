package EjerciciosAlgoritmos;

public class BusquedaPalabra {

    public static int[] encontrarIndices(char[] caracteres, String palabra) {
        int[] indices = new int[palabra.length()];
        int index = 0;

        for (int i = 0; i < palabra.length(); i++) {
            char letra = palabra.charAt(i);
            boolean encontrado = false;

            for (int j = 0; j < caracteres.length; j++) {
                if (caracteres[j] == letra) {
                    indices[index++] = j;
                    encontrado = true;
                    break;
                }
            }

            if (!encontrado) {
                return new int[]{}; 
            }
        }

        return indices;
    }

    public static void main(String[] args) {
        char[] caracteres = {'a', 'c', 'd', 'i', 'm', 'r', 't', 'u'};
        String palabra = "dia";
        int[] resultado = encontrarIndices(caracteres, palabra);

        if (resultado.length == 0) {
            System.out.println("No se encontraron índices que conformen la palabra.");
        } else {
            System.out.print("Índices: [");
            for (int i = 0; i < resultado.length; i++) {
                System.out.print(resultado[i]);
                if (i < resultado.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }
    }
}
