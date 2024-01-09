import java.util.*;
class RecursiveMultiply{
    public int multiply(int n, int m){
         //edge case
       if(n==0 || m ==0)
          return 0;
       return multiply(n, m-1) +n;
    }
public static void main(String[] args){
    Scanner s = new Scanner(System.in);
    RecursiveMultiply obj = new RecursiveMultiply();
    System.out.println("No to be multiplied: ");
    int n = s.nextInt();
    System.out.println("How many times? ");
    int m = s.nextInt();
    int result = obj.multiply(n,m);
    System.out.println(result);
}
}