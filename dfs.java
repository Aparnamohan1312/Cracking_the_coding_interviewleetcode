import java.util.*;
public class dfs {
    public static void main(String[] args){
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        //Adjacency
        map.put(0,new ArrayList<>(Arrays.asList(1,2)));
        map.put(1,new ArrayList<>(Arrays.asList(3,4)));
        map.put(2,new ArrayList<>(Arrays.asList(5,6)));
        ArrayList<Integer> dfs = new ArrayList<>();
        dfs(map,0,dfs);
        System.out.println("DFS" + dfs);
    }
        public static void dfs (HashMap<Integer, ArrayList<Integer>> map, int start, ArrayList<Integer> dfs){
        Stack<Integer> stack = new Stack<>();
        int[] visited = new int[10];
        visited[0] = 1;
        stack.add(0);
        while(!stack.isEmpty()){
              int current = stack.pop();
              System.out.println(current);
              dfs.add(current);
              ArrayList<Integer> neighbors = map.get(current);
              if(neighbors!=null){
              for(int i:neighbors){
                if(visited[i]!=1){
                visited[i] = 1;
                stack.add(i);
              }
            }
        }} 
}
}
