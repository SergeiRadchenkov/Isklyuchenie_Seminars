/*
 * Задача 3
 * ====================
 * Реализуйте метод, принимающий в качестве аргумента целочисленный двумерный массив.
 * Необходимо посчитать и вернуть сумму элементов этого массива.
 * При этом накладываем на метод 2 ограничения: метод может работать только с квадратными массивами (количество строк = количеству столбцов), и в каждой ячейке может лежать только значение 0 или 1.
 * Если нарушается одно из условий, метод должен бросить RuntimeException с сообщением об ошибке.
 */

import java.util.Random;

public class task3 {

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            processArray(generateArray());
        }
    }

    static Random random = new Random();

    static int[][] generateArray() {
        int[][] array = new int[random.nextInt(4, 6)][5];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                array[i][j] = random.nextInt(2);
            }
        }
        if (random.nextInt(3) == 0) {
            array[random.nextInt(array.length)][random.nextInt(array[0].length)] = 2;
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.printf("%d ", array[i][j]);
            }
            System.out.println();
        }
        return array;
    }

    static void processArray(int[][] array) {
        if (array.length != array[0].length) {
            throw new RuntimeException(String.format("Некорректная размерность массива,\n получили %d x %d", array.length, array[0].length));
        }
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j] != 0 && array[i][j] !=1) {
                    throw new RuntimeException(String.format("Некорректное значение элемента массива по индексу [%d][%d]", i, j));
                } else {
                    sum += array[i][j];
                }
            }
        }
        System.out.printf("Сумма элементов массива: %d\n", sum);
    }
}
