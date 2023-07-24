//Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float),
//и возвращает введенное значение.
//Ввод текста вместо числа не должно приводить к падению приложения,
//вместо этого, необходимо повторно запросить у пользователя ввод данных.
package HW2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        input("Введите дробное число");
    }


    public static void input(String str) {
        System.out.println(str);
        Scanner scanner = new Scanner(System.in);
        try {
            float num = scanner.nextFloat();
        } catch (InputMismatchException e) {
            System.out.println("Введено не дробное число");
            input("Введите еще раз");
        }
    }
}
