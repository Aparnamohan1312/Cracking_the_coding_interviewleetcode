import java.util.*;
class MeetingRoomsII{
    public int rooms(List<List<Integer>> list){
        int result = 1;
        if(list == null)
            return 0;
        Collections.sort(list,(a,b)-> Integer.compare(a.get(1),b.get(1)));
        int endTime = list.get(0).get(1);
        for(int i=1;i<list.size();i++){
                int startTime = list.get(i).get(0);
                if(startTime<=endTime)
                    result++;
        }
        return result;
    }
    public static void main(String[] args){
        MeetingRoomsII obj = new MeetingRoomsII();
        Scanner s = new Scanner(System.in);
        List<List<Integer>> list = new ArrayList<>();
        System.out.println("No of meets: ");
        int n = s.nextInt();
        for(int i=0;i<n;i++){
            int x = 0;
            List<Integer> l = new ArrayList<>();
            while(x<2){
            int num = s.nextInt();
            l.add(num);
            x++;
            }
            list.add(l);
        }
        int result = obj.rooms(list);
        System.out.println(result);
    }
}
//4.53-5.40
//start time 0, end time lesser than start time, no negative numbers
//list size
//[[2,3],[0,10],[10,30]]
//2 when 0,10 2,3 occurs 10,30 no overlap so 2 rooms