import java.util.Random;

public class ShellSort {
    

        public static void main(String[] args) {
    
            int[][] array2d = new int[50][50];
            Random rand = new Random();
    
            for (int i = 0; i < 50; i++)
                for (int j = 0; j < 50; j++)
                    array2d[i][j] = rand.nextInt(1012);
            for(int[] m : toMatrix(sort(toArray(array2d)))) {
                for(int i : m){
                    System.out.print(i + "\t");
                }
                System.out.println();
            }
    
            System.out.println();
    
            long time = System.currentTimeMillis();
            sort(toArray(array2d));
            System.out.println(System.currentTimeMillis() - time);
        }
    
        public static int[] toArray(int[][] arr){
            int[] flat = new int[50 * 50];
    
            int ctr = 0;
            for (int row = 0; row < 50; row++) {
                for (int col = 0; col < 50; col++) {
                    flat[ctr++] = arr[row][col];
                }
            }
            return flat;
        }
    
        public static int[][] toMatrix(int[] arr){
            int [][] numbers = new int [50][50];
    
            int m = 0;
            for(int i = 0 ; i < 50 ; i++)
                for(int j = 0 ; j < 50; j++)
                    numbers[i][j] = arr[m++];
    
            return numbers;
        }
    
        public static int[] sort(int[] array) {
            int temp;
            int h = 0;//величина интервала
    
            //вычисляем исходное значение интервала
            while(h <= array.length/3)
                h = 3*h + 1;
    
            for(int k = h; k > 0; k = (k-1)/3)
                for(int i = k; i < array.length; i++)
                {
                    temp = array[i];
                    int j;
                    for(j = i; j >= k; j -= k)
                    {
                        if(temp < array[j - k])
                            array[j] = array[j - k];
                        else
                            break;
                    }
                    array[j] = temp;
                }
    
            return array;
        }
    
    }
     

