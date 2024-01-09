import java.util.*;
class Queens{
    static int N =4;
    public static boolean combinations(int[][] board,int col){
      if(col>=N)
        return true;
      for(int i=0;i<N;i++){
        if(toPlace(board,i,col)){
            board[i][col] = 1;
            if(combinations(board,col+1))
            return true;
            board[i][col] = 0;
        }
      }
      return false;
    }
    public static boolean toPlace(int[][]board, int row, int col){
        for(int i =0;i<col;i++){
            if(board[row][i] == 1)
                return false;

            }
            for(int i = row, j= col;i>=0 && j>=0;i--,j--){
                if(board[i][j] == 1)
                return false;
            }
            for(int i=row,j=col;j>=0 && i< N;i++,j--){
                if(board[i][j] == 1)
                return false;
            }
            return true;
    }
    public static void printBoard(int[][] board){
        for(int i=0;i<N;i++){
            for(int j =0;j<N;j++){
                if(board[i][j] == 1)
                    System.out.println("Q\t");
                else
                    System.out.println("\t");
            
                }
                            System.out.println("\n");


        }
    }
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        Queens obj = new Queens();
        int N = s.nextInt();
        int[][] board = new int[N][N];
        if(n==0)
           System.out.println("0");
        else if (n==1)
            System.out.println("1");
        boolean c = obj.combinations(board,0);
        obj.printBoard(board);
    }
}
//11.14