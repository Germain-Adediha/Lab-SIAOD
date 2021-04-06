import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;
public class interpolationSearch {
    public static int InterpolationSearch(int[] integers, int elementToSearch) {

        int startIndex = 0;
        int lastIndex = (integers.length - 1);

        while ((startIndex <= lastIndex) && (elementToSearch >= integers[startIndex]) &&
                (elementToSearch <= integers[lastIndex])) {
            int pos = startIndex + (((lastIndex-startIndex) / (integers[lastIndex]-integers[startIndex]))* (elementToSearch - integers[startIndex]));

            if (integers[pos] == elementToSearch)
                return pos;

            if (integers[pos] < elementToSearch)
                startIndex = pos + 1;

            else
                lastIndex = pos - 1;
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n;
        System.out.println("Введите размер массива:");
        n = in.nextInt();

        int[] array1 = new int[n];

        Random random = new Random();

        for (int i = 0; i < n; i++){
                array1[i] = random.nextInt(100);
            }
    
         System.out.println(Arrays.toString(array1));
        Arrays.sort(array1);
        System.out.println(Arrays.toString(array1));
        System.out.println("Введите элемент для поиска: ");
        int a = in.nextInt();
        long debut = System.nanoTime();
        int index=InterpolationSearch(array1,a);
        long fin = System.nanoTime();
        if (index==-1){
            System.out.println("Element not found in the massive");
        }
        else{
        System.out.println("Element index is: " + index);
        System.out.println("Time with interpolation searching in nanos: " + (fin - debut));

        long debut1 = System.nanoTime();
        Arrays.binarySearch(array1,a);
        long fin1 = System.nanoTime();

        //System.out.println("Element index is: " +  Arrays.binarySearch(array1,a));
        System.out.println("Time with java standart searching  in nanos: " + (fin1 - debut1));

        }

      /*  long k = Math.round(Math.random()*n);
        System.out.println("K:"+k);
        String intArrayString = Arrays.toString(array1);
        System.out.println(intArrayString);
        long before = System.nanoTime();
        interpolationSearch(array1,array1[(int)k]);
        long after = System.nanoTime();
        System.out.println("Element index is: " +  interpolationSearch(array1,array1[(int)k]));
        System.out.println("Time interpolationSearch in nanos: " + (after - before));
*/

/*
        before = System.nanoTime();
        Arrays.binarySearch(array1,array1[(int)k]);
        after = System.nanoTime();
        System.out.println("Element index is: " +  Arrays.binarySearch(array1,array1[(int)k]));
        System.out.println("Time sandartSearch in nanos: " + (after - before));
*/
    }
    }

