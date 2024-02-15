/*
 Задача 1
 ====================
 1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4x4.
 При подачи массива другого размера необходимо бросить исключение MyArraySizeEx.
 2. Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать.
 Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа должно быть брошено исключение MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.)
 3. В метод main() вызвать полученный метод, обработать возможные исключения MyArraySizeException и MyArrayDataException и вывести результат расчёта.
 */

import java.util.Random;

public class task1 {
    public static void main(String[] args) throws task1MyArraySizeException {
        for (int i = 0; i < 10; i++){
            System.out.printf("\n*** Итерация #%d ***\n", i);
            processArray();
        }
    }

    private static void processArray() {
        try {
            System.out.printf("Сумма элементов массива: %d\n", processArrayInternal(generateArray()));
        }
        catch (task1MyArrayDataException e){
            System.out.printf("%s по индексу [%d][%d]\n", e.getMessage(), e.getX(), e.getY());
        }
        catch (task1MyArraySizeException e){
            System.out.printf("%s, требовалось [4x4], получили [%dx%d]\n", e.getMessage(), e.getX(), e.getY());
        }
        catch (RuntimeException e){

        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private static Random random = new Random();

    private static String[][] generateArray() {
        int add = random.nextInt(2);
        String[][] array = new String[4 + add][4 + add];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                array[i][j] = Integer.toString(random.nextInt(-99, 100));
            }
        }
        if (random.nextInt(3) == 0) {
            array[random.nextInt(array.length)][random.nextInt(array[0].length)] = "abc";
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.printf("%s\t", array[i][j]);
            }
            System.out.println();
        }
        return array;
    }

    /**
     * @param array
     * @return
     * @throws task1MyArraySizeException Некорректная размерность массива
     * @throws task1MyArrayDataException Некорректный формат данных
     */
    private static int processArrayInternal(String[][] array) throws task1MyArraySizeException, task1MyArrayDataException {
        if (array == null) {
            throw new NullPointerException ("Массив должен существовать");
        }
        if (array.length != 4 || array[0].length != 4) {
            throw new task1MyArraySizeException("Некорректная размерность массива", array.length, array[0].length);
        }
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                sum += parseElement(array[i][j], i, j);
            }
        }
        return sum;
    }

    /**
     * @param s Значение элемента
     * @param x Индекс элемента
     * @param y Индекс элемента
     * @return Результат преобразования значения элемента
     * @throws task1MyArrayDataException Некорректный формат данных
     */
    private static int parseElement(String s, int x, int y) throws task1MyArrayDataException {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new task1MyArrayDataException("Некорректный формат данных", x, y);
        }
    }
}
