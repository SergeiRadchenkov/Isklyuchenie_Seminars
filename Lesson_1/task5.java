/*
 * Задача 5
 * ====================
 * Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, и возвращающий новый массив, каждый элемент которого равен сумме элементов двух входящих массивов в той же ячейке.
 * Если длины массивов не равны, необходимо как-то оповестить пользователя.
 */

import java.util.Random;

public class task5 {

    static Random random = new Random();

    static int[] generateArray() {
        int[] array = new int[random.nextInt(4, 6)];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(-9, 10);
        }
        if (random.nextInt(3) == 0) {
            array = null;
        }
        if (array != null) {
            for (int i = 0; i < array.length; i++) {
                System.out.printf("%d ", array[i]);
            }
            System.out.println();
        }
        return array;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            try {
                int[] array = getSumArray(generateArray(), generateArray());
                for (int e : array) {
                    System.out.printf("%d\t", e);
                }
                System.out.println();
            }
            catch (NullPointerException e) {
                System.out.println(e.getMessage());
            }
            catch (task5CustomArraySizeException e) {
                System.out.println(e.getMessage());
                System.out.println("Размерность первого массива: " + e.getLenth1());
                System.out.println("Размерность второго массива: " + e.getLenth2());
            }
        }
    }

    static int[] getSumArray(int[] array1, int[] array2) throws NullPointerException, task5CustomArraySizeException {
        if (array1 == null || array2 == null) {
            throw new NullPointerException("Оба массива должны существовать");
        }
        if (array1.length != array2.length) {
            throw new task5CustomArraySizeException("Количество элементов массива должно быть одинаково",
            array1.length, array2.length);
        }
        int[] res = new int[array1.length];
        for (int i = 0; i < array1.length; i++) {
            res[i] = array1[i] + array2[i];
        }
        return res;
    }
}
