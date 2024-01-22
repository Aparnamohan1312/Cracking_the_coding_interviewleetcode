import java.util.*;

public class OceanView {
    public List<Integer> calc(int[] arr){
        List<Integer> result = new ArrayList<>();
        if(arr.length==0)
            return result;
       if (arr.length == 1) {
                result.add(0);
                return result;
            }
     
        for(int i=1;i<arr.length;i++){
            if(arr[i-1]>arr[i]){
                result.add(i-1);
            }
        }
         result.add(arr.length-1);
        boolean allSame = true;
        for(int i=1;i<arr.length;i++){
            if(arr[i]!=arr[0]){
              allSame = false;
              break;
            }
        }
        if(allSame && !result.contains(arr.length-1))
            result.add(arr.length-1);
    
    return result;
    }
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println("Buildings: ");
        int buildings = s.nextInt();
        int[] arr = new int[buildings];
        for(int i=0;i<buildings;i++)
            arr[i] = s.nextInt();
        OceanView obj = new OceanView();
        List<Integer> answer = obj.calc(arr);
        System.out.println(answer);
    }
    
}
//839
