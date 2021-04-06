import java.util.*;
public class FibonacciSearch{
    private int i;
    private int p;
    private int q;
    private boolean stop=false;
    public FibonacciSearch(){

    }
    private void init (int[] sequince){
        stop = false;
        int k=0;
        int n = sequince.length;
        for(;getFibonacciNumber(k+1)<n+1;){
            k+=1;
        }
        int m=(int)(getFibonacciNumber(k+1)-(n+1));
        i=(int)(getFibonacciNumber(k)-m);
        p=(int)getFibonacciNumber(k-1);
        q=(int)getFibonacciNumber(k-2);
        

    }

    public long getFibonacciNumber(int k){
        long firstNumber=0;
        long secondNumber=1;
        for(int i=0;i<k;i++){
            long temp= secondNumber;
            secondNumber+=firstNumber;
            firstNumber=temp;
        }
        return firstNumber;
    }
    private void upIndex(){
        if(p==1)
        stop=true;
        i=i-q;
        p=p-q;
        q=q-p;
    }
    private void downIndex(){
        if(q==0)
        stop =true;
        i=i-q;
        int temp=q;
        q=q-p;
        p=temp;
        }
public int search( int [] sequince, int element){
    init(sequince);
    int n =sequince.length;
    int resultIndex=-1;
    for(;!stop;){
        if (i<0){
            upIndex();
        }else if (i>=n){
            downIndex();
        }else if (sequince[i]==element){
            resultIndex=i;
            break;
        }else if(element< sequince[i]){
            downIndex();
        }else if(element>sequince[i]){
            upIndex();
        }
    }
    return resultIndex;
}

public static void main(String[] args) {
    int  num; 
FibonacciSearch fs=new FibonacciSearch();
        Scanner input = new Scanner(System.in);
        System.out.println("Введите размер массива:");
        num = input.nextInt();

        int[] array1 = new int[num];

        Random random = new Random();

        for (int i = 0; i < num; i++){
                array1[i] = random.nextInt(100);
            }
            System.out.println( Arrays.toString(array1));
            Arrays.sort(array1);
        System.out.println( Arrays.toString(array1));

     //   int [] sequince= new int []{-2,0,3,5,7,9,11,15,18,21};
        //System.out.println(Arrays.toString(sequince));
        System.out.print("Искомый элемент : ");
       int element =  input.nextInt();
       long before = System.nanoTime();
       int index= fs.search(array1,element);
       long after = System.nanoTime();
       System.out.println(" Index of the element is "+ index);
       System.out.println("Time  in nanos with Fibonacci search: " + (after - before));
          // int num = input.nextInt();
          input.close();
           
}
    }
