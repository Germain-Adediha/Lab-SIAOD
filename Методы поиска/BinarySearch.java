import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;
public class BinarySearch {
 
    public static void main(String args[]) {
        int counter, num, item, array[], first, last;
 
        //Создаем объект Scanner для считывания чисел, введенных пользователем


        Scanner input = new Scanner(System.in);
        //int n;
        System.out.println("Введите размер массива:");
        num = input.nextInt();

        int[] array1 = new int[num];

        Random random = new Random();

        for (int i = 0; i < num; i++){
                array1[i] = random.nextInt(100);
            }
            System.out.println( Arrays.toString(array1));

/*
       // Scanner input = new Scanner(System.in);
        System.out.println("Введите количество элементов массива: ");
        num = input.nextInt();
       
        // Создаем массив введенного пользователем размера
        array = new int[num];
 
        System.out.println("Введите " + num + " чисел");
 
        //Заполняем массив, вводя элементы в консоль
        for (counter = 0; counter < num; counter++)
            array[counter] = input.nextInt();
 
            System.out.println( Arrays.toString(array));
        // сортируем элементы массива, так как для бинарного поиска
        // элементы массива должны быть отсортированными               */
        Arrays.sort(array1);
        System.out.println( Arrays.toString(array1));
        System.out.println("Введите элемент для бинарного поиска: ");
        item = input.nextInt();
        first = 0;
        last = num - 1;
 
        // метод принимает начальный и последний индекс, а также число для поиска
        long before = System.nanoTime();
        binarySearch(array1, first, last, item);
        long after = System.nanoTime();

        System.out.println("Time  in nanos: " + (after - before));
        
    }
 
    // бинарный поиск
    public static void binarySearch(int[] array, int first, int last, int item) {
        int position;
        int comparisonCount = 1;    // для подсчета количества сравнений
 
        // для начала найдем индекс среднего элемента массива
        position = (first + last) / 2;
 
        while ((array[position] != item) && (first <= last)) {
            comparisonCount++;
            if (array[position] > item) {  // если число заданного для поиска
                last = position - 1; // уменьшаем позицию на 1.
            } else {
                first = position + 1;    // иначе увеличиваем на 1
            }
            position = (first + last) / 2;
        }
        if (first <= last) {
            System.out.println(item + " - " + position + "ый в массиве");
            System.out.println("Метод бинарного поиска нашел число после " + comparisonCount +
                    " сравнений");
        } else {
            System.out.println("Элемент не найден в массиве. Метод бинарного поиска закончил работу после "
                    + comparisonCount + " сравнений");
        }
    }
 
}