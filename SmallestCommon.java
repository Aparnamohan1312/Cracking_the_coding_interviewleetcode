import java.util.*;
public class SmallestCommon{
    public int smallest(int row, int column,int[][] arr){
        int result = -1;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                map.put(arr[i][j],map.getOrDefault(arr[i][j],0)+1);
            }
        }
        int max = 0;
        int smallestKey = Integer.MAX_VALUE;  
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(entry.getValue()>max || (entry.getValue() == max && entry.getKey()<smallestKey)){
            max = entry.getValue();
            smallestKey =  entry.getKey();
            }
         }
         if(max>1){
            boolean foundInAllRows = true;
            for(int[] rows:arr){
                boolean found = false;
                for(int num:rows){
                    if(num==smallestKey){
                        found = true;
                        break;
         }
        }
        if(!found){
            foundInAllRows = false;
            break;
        }
    }
    if(foundInAllRows)
        result = smallestKey;
}
        return result;
    }
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        SmallestCommon obj = new SmallestCommon();
        System.out.println("Rows: ");
        int rows = s.nextInt();
        System.out.println("Column: ");
        int column = s.nextInt();
        int[][] arr = new int[rows][column];
        for(int i=0;i<rows;i++){
            for(int j=0;j<column;j++){
                arr[i][j] = s.nextInt();
            }
        }
        int ans = obj.smallest(rows,column,arr);
        System.out.println(ans);
         
    }
}
//11.28 - 11.48