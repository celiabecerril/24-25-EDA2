package EjerciciosAlgoritmos;

import java.util.Arrays;

public class Permutaciones {

    public static void permutar(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        boolean[] usado = new boolean[chars.length];
        permutar(new StringBuilder(), chars, usado);
    }

    private static void permutar(StringBuilder prefijo, char[] chars, boolean[] usado) {
        if (prefijo.length() == chars.length) {
            System.out.println(prefijo.toString());
        } else {
            for (int i = 0; i < chars.length; i++) {
                if (usado[i] || (i > 0 && chars[i] == chars[i - 1] && !usado[i - 1])) {
                    continue;
                }
                usado[i] = true;
                prefijo.append(chars[i]);
                permutar(prefijo, chars, usado);
                usado[i] = false;
                prefijo.deleteCharAt(prefijo.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        String entrada = "aabc";
        System.out.println("Permutaciones de " + entrada + ":");
        permutar(entrada);
    }
}