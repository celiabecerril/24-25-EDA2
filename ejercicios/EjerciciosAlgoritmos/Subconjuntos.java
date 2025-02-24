package EjerciciosAlgoritmos;

public class Subconjuntos {

    public static void encontrarSubconjuntos(int[] nums) {
        int n = nums.length;
        int totalSubconjuntos = (int) Math.pow(2, n);

        for (int i = 0; i < totalSubconjuntos; i++) {
            System.out.print("[");
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    System.out.print(nums[j] + " ");
                }
            }
            System.out.println("]");
        }
    }

    public static void encontrarSubconjuntosDeTamanoK(int[] nums, int k) {
        int[] subset = new int[k];
        generarSubconjuntosDeTamanoK(nums, subset, 0, 0, k);
    }

    private static void generarSubconjuntosDeTamanoK(int[] nums, int[] subset, int index, int start, int k) {
        if (index == k) {
            System.out.print("[");
            for (int i = 0; i < k; i++) {
                System.out.print(subset[i] + " ");
            }
            System.out.println("]");
            return;
        }

        for (int i = start; i < nums.length; i++) {
            subset[index] = nums[i];
            generarSubconjuntosDeTamanoK(nums, subset, index + 1, i + 1, k);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println("Todos los subconjuntos:");
        encontrarSubconjuntos(nums);

        int k = 2;
        System.out.println("Subconjuntos de tamaño " + k + ":");
        encontrarSubconjuntosDeTamanoK(nums, k);
    }
}