import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Les2 {

    public static void main(String[] args) {
        //Задание 1
        int array1[] = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println("Исходный массив: " + Arrays.toString(array1));
        for (int i = 0; i < array1.length; i++)
            array1[i] = array1[i]^1;
        System.out.println("Массив с заменой 1 на 0 и 0 на 1: " + Arrays.toString(array1));

        //Задание 2
        int array2[] = new int[8];
        for (int i = 0; i < array2.length; i++)
            array2[i] = i * 3;
        System.out.println("\nМассив заполненный циклом 0 3 6 9 12 15 18 21: " + Arrays.toString(array2));

        //Задание 3
        int array3[] = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < array3.length; i++)
            if (array3[i] < 6)
                array3[i] = array3[i] * 2;
        System.out.println("\nМассив 1 5 3 2 11 4 5 2 4 8 9 1, в котором числа меньше 6 умножены на два: " + Arrays.toString(array3));

        fillDiagonal1(7); //Задание 4
        printMinAndMax(4, 1, 2, 3, 4, 10, 7, 8, 9, 0, 6, 3, -23, 3, 4, 4); //Задание 5
        checkBalance(4, 1, -3, 2, 0); //Задание 6
        //Задание 7 не делал
    }

    //Задание 4
    public static void fillDiagonal1(int size) {
        int arr[][] = new int[size][size];
        for (int i = 0, j = 0; i < arr.length; i++, j++)
            if (i == j) {
                arr[i][j] = 1;
                arr[size - 1 - i][j] = 1;
            }
        System.out.println(new StringBuilder("\nКвадратный двумерный массив размером ").append(size).append(" c 1 по диагонали:"));
        for (int i = 0; i < arr.length; i++)
            System.out.println(Arrays.toString(arr[i]));
    }

    //Задание 5
    public static void printMinAndMax(int... arr) {
        int min = arr[0], max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min)
                min = arr[i];
            if (arr[i] > max)
                max = arr[i];
        }
        System.out.println(new StringBuilder("\nВ массиве ").append(Arrays.toString(arr)).append(" минимальный элемент: ").append(min)
                .append(", максимальный элемент:").append(max));
    }

    //Задание 6
    public static void checkBalance(int... arr) {
        int balanceIndex = -1;
        for (int i = 0; i < arr.length; i++) {
            int sumLeft = 0, sumRight = 0;
            for (int j = 0; j < i; j++)
                sumLeft = sumLeft + arr[j];
            for (int j = i; j < arr.length; j++)
                sumRight = sumRight + arr[j];
            if (sumLeft == sumRight) {
                balanceIndex = i;
                break;
            }
        }
        System.out.println(new StringBuilder("\nВ массиве ").append(Arrays.toString(arr)).append(balanceIndex == -1 ? " нет места" : " есть место")
                .append(" баланса. "));
        if (balanceIndex != -1)
            System.out.println(Arrays.toString(Arrays.copyOfRange(arr, 0, balanceIndex)) + " || "
                    + Arrays.toString(Arrays.copyOfRange(arr, balanceIndex, arr.length)));
    }
}
