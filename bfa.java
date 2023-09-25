import java.util.*;
import java.lang.*;
class bfa{
    public static void main(String[] args) {
        Map<Integer,ArrayList<Integer>> map = new HashMap<Integer,ArrayList<Integer>>();
        int[] visited = new int[7];
        Arrays.fill(visited,0);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = 1; 
        ArrayList<Integer> bfs = new ArrayList<>();
          // Define the adjacency list
          map.put(0, new ArrayList<>(Arrays.asList(1, 2)));
          map.put(1, new ArrayList<>(Arrays.asList(3, 4)));
          map.put(2, new ArrayList<>(Arrays.asList(5, 6)));
          
        System.out.println(map);
        while(!queue.isEmpty()){
            int current = queue.poll();
            bfs.add(current); 
            List<Integer> neighbors = map.get(current);
            if(neighbors!=null){
             for(int i:neighbors){
            if(visited[i]!=1){
                visited[i] = 1;
                queue.add(i);
            }
        }
        }
        }
        System.out.println("BFS traversal: " + bfs);
    }
}