/*
Задача 2:
====================
Создайте класс Счетчик, у которого есть метод add(), увеличивающий
значение внутренней int переменной на 1. Сделайте так, чтобы с объектом
такого типа можно было работать в блоке try-with-resources. Подумайте, что
должно происходить при закрытии этого ресурса? Напишите метод для
проверки, закрыт ли ресурс. При попытке вызвать add() у закрытого
ресурса, должен выброситься IOException.
 */

public class Task2 {
    public static void main(String[] args) {
        try (Counter counter = new Counter(1000)) {
            counter.add();
            counter.add();
            System.out.printf("Текущее значение счетчика: %d\n", counter.getCounter());
        } catch (CloseCounterException e) {
            System.out.println(e.getMessage());
        }
    }
}
