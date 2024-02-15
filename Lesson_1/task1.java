/*
 * Задача 1
 * ====================
 * Реализуйте метод, принимающий в качестве аргумента целочисленный массив.
 * Если длина массива меньше некоторого заданного минимума,
 * метод возвращает -1, в качестве кода ошибки, иначе - длина массива.
 */

public class task1 {
    public static void main(String[] args) {
        System.out.printf("Размерность массива: %d\n", task_1(new int[] {5, -5, 6}));
    }
    
    static int task_1(int[] arr) {
        if (arr == null)
            return -2;
        if (arr.length == 0) {
            return -1;
        }
        return arr.length;
    }
}
