import java.util.*;
class LongestSubstring_kchar{
  //  List<String> stringlist;
    public int func(String s, int k){
        if(s.equals(""))
            return 0;
        int max = 0;
        List<String> result = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            for(int j= i+1;j<=s.length();j++){
                String substr = s.substring(i,j);
                result.add(substr); 
            }
        }
        for(String sub:result){
        
            char[] ch = sub.toCharArray();
            int count =0, count0=0;
            for(int j=1;j<ch.length;j++){
                if(ch[j]!=ch[j-1])
                    count++;
                count0 += (k!=0)?0:1;
            }

            if(count<=k && ( k!=0|| count0==ch.length-1))
                max = Math.max(max,sub.length());
           
              }
           
                    return max;
    }
    public static void main(String[] args){
       Scanner sc = new Scanner(System.in);
       String s = sc.nextLine();
       int k = sc.nextInt();
       LongestSubstring_kchar obj = new LongestSubstring_kchar();
       int ans = obj.func(s,k);
       System.out.println(ans);
    }
}
//6.25-6.54
//6.55-7.08
//7.12-7.22
