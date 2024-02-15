/*
 * Задача 2
 * ====================
 * Реализуйте метод, принимающий в качестве аргумента челочисленный массив и некоторое значение.
 * Метод ищет в массиве заданное значение и возвращает его индекс. При метом, например:
 * 1. если длина массива меньше некоторого заданного минимума, метод возвращает -1, в качестве кода ошибки.
 * 2. если искомый элемент не найден, метод вернёт -2 в качестве кода ошибки.
 * 3. если вместо массива пришёл null, метод вернёт -3.
 * 4. придумайте свои варианты исключительных ситуаций и верните соответствующие коды ошибок.
 * Напишите метод, в котором реализуйте взаимодействие с пользователем.
 * То есть, этот метод запросит искомое число у пользователя, вызовет первый,
 * обработает возвращённое значение и покажет читаемый результат пользователю.
 * Например, если вернуть -2, пользователю выведется сообщение: "Искомый элемент не найден".
 */

import java.util.Random;
import java.util.Scanner;

public class task2 {
    public static void main(String[] args) {
        task_2();
    }

    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    static void task_2() {
        while (true) {
            System.out.print("Укажите значение для поиска: ");
            int searchElement = Integer.parseInt(scanner.nextLine());
            int[] array = new int[random.nextInt(1, 6)];
            if (random.nextInt(3) == 0)
                array = null;
            if (array != null) {
                for (int i = 0; i < array.length; i++) {
                    array[i] = random.nextInt(10);
                    System.out.printf("%d\t", array[i]);
                }
                System.out.println();
            }
            int codeResult = processArray(array, searchElement);
            switch (codeResult) {
                case -1 -> System.out.println("Размерность массива менее трёх символов");
                case -2 -> System.out.println("Элемент не найден");
                case -3 -> System.out.println("Массива некорректно проинициализирован");
                default -> {
                    System.out.println("Массив успешно обработан, завершение работы приложения.");
                    System.out.printf("Элемент найден по индексу: %d\n", codeResult);
                    return;
                }
            }
        }
    }

    static int processArray(int[] array, int searchElement) {
        if (array == null) {
            return -3;
        }
        if (array.length < 3) {
            return -1;
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] == searchElement)
                return i;
        }
        return -2;
    }
}
