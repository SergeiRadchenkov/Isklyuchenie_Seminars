/*
 * Задача 4
 * ====================
 * Переработать реализацию задачи 3 с использованием кодов ошибок
 */

 import java.util.Random;

public class task4 {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            int errorCode = processArray(generateArray());
            switch (errorCode) {
                case -1 -> System.out.println("Некорректный размер массива.");
                case -2 -> System.out.println("Некорректное значение элементов массива.");
                default -> {
                    System.out.printf("Сумма элементов массива: %d\n", errorCode);
                }
            }
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

    static int processArray(int[][] array) {
        if (array.length != array[0].length) {
            return -1;
        }
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j] != 0 && array[i][j] !=1) {
                    return -2;
                } else {
                    sum += array[i][j];
                }
            }
        }
        return sum;
    }
}
