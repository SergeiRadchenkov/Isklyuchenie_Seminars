import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
Задача 2
=====================
Запишите в файл следующие строки:
Анна=4
Елена=5
Марина=6
Владимир=?
Константин=?
Иван=4

Реализуйте метод, который считывает данные из файла и сохраняет в двумерный массив (либо HashMap, если
студенты с ним знакомы). В отдельном методе нужно будет пройти по структуре данных, если сохранено
значение ?, заменить его на соответствующее число. Если на каком-то месте встречается символ, отличный от
числа или ?, бросить подходящее исключение.
*/

public class task2 {
    public static void main(String[] args) {
        prepareFile();
    }

    private static Random random = new Random();

    private static void prepareFile(){
        try (FileWriter fileWriter = new FileWriter("names.txt")) {
            fileWriter.write("Анна=4\n");
            fileWriter.write("Елена=5\n");
            fileWriter.write("Марина=6\n");
            fileWriter.write("Владимир=?\n");
            fileWriter.write("Константин=?\n");
            fileWriter.write("Иван=4\n");
            fileWriter.flush();
            //fileWriter.close();
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
