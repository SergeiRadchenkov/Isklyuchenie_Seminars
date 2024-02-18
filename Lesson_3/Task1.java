/*
Задача 1:
====================
1. Создайте класс исключения, который будет выбрасываться при делении на 0. Исклбчение должно отображать понятное для пользователя сообщение об ошибке.
2. Создайте класс имключений, которое будет возникать при обращении к пустому элементу в массиве ссылочного типа. Исключение должно отображать понятное для пользователя сообщение об ошибке.
3. Создайте класс исключения, которое будет возникать при попытке открыть несуществующий файл. Исключение должно отображать понятное для пользователя сообщение об ошибке.
4*. Продемонстрировать работу каждого исключения.
 */

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Task1 {
    public static void main(String[] args) {
        try {
            test1();
        } catch (DivisionByZeroException e) {
            System.out.println(e.getMessage());
        }

        try {
            test2(new Integer[]{1, 3, null, 5}, 3);
            test2(new String[]{"AA", "BB", null, "DD"}, 2);
        } catch (NullElementArrayException e) {
            System.out.println(e.getMessage());
            System.out.println("Индекс элемента: " + e.getIndex());
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            test3("D:/AA/AA/AA.ttt");
        } catch (MyFileNotFountException e){
            System.out.printf("%s\nНаименование файла: %s\n", e.getMessage(), e.getFileName());
        }
    }

    static void test1() {
        try {
            int a = 10 / 0;
        } catch (ArithmeticException e) {
            throw new DivisionByZeroException("Ошибка деления числа на 0");
        }
    }

    static <T> void test2(T[] array, int index) {
        if (array[index] == null)
            throw new NullElementArrayException("Элемент массива не проинициализирован", index);
        System.out.printf("Значение элемента массива: %s\n", array[index]);
    }

    static void test3(String fileName) throws MyFileNotFountException {
        try (FileReader fileReader = new FileReader(fileName)) {
        } catch (FileNotFoundException e) {
            throw new MyFileNotFountException("Файл не найден.", fileName);
        } catch (Exception e) {
            
        }
    }
}
