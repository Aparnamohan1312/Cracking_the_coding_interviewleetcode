import java.util.*;
import java.lang.*;

public class hackerrank_OptimalServers {
    public static int minimumTotalcost(List<Integer> price) {
   int n = price.get(0), with = 0, without = 0, minCost = 0;
   List<Integer> minPrices = new ArrayList<>();
   price.remove(0);
   if(n==1)
    return price.get(0)/2;
   System.out.println(price);
   for(int i=n-1;i>=0;i--){
     with = 0;
     if(i!=0)
          without += Math.abs(price.get(i)-price.get(i-1)); 
   // Floor ith server and compute absolute diffs between all server and sum
   // [22, 18, 57]
    for(int j = n-1; j>0 ; --j) {
       if(j==i)
       with += Math.abs(price.get(j)/2-price.get(j-1)); 
       else if((j-1) == i)
       with += Math.abs(price.get(j)-price.get(j-1)/2); 
       else
       with += Math.abs(price.get(j)-price.get(j-1)); 
       
      }
    System.out.println("With" + with);
      minPrices.add(with);
    }
   
    minCost = minPrices.get(0);
    for(int i =1; i< minPrices.size(); ++i) {
        minCost = Math.min(minCost, minPrices.get(i));
    }
    System.out.println("Without" + without);
    int result = Math.min(minCost, without);
    System.out.println("Min cost: "+result);
    return result;
}
    public static void main(String[] args) {
        List<Integer> price = new ArrayList<>();
        price.add(3);
        price.add(22);
        price.add(18);
        price.add(57);
        minimumTotalcost(price);
        //System.out.println("Minimum Total Cost: " + result);
    }

}
