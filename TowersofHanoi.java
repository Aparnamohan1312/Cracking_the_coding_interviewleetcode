import java.util.*;

public class TowersofHanoi{
    public static void move(int n, int towers, char source, char dest){
        if(n==1){
            System.out.println("Moved " + source + "to " + dest);
            return;
        }
        char aux = findAux(source,dest,towers);
        move(n-1,towers,source,aux);
        System.out.println("Move disk "+n+"from " + source+ "to " + dest);
        move(n-1,towers,aux,dest);

    }
    public static char findAux (char source, char dest, int towers){
        for(char rod = 'A';rod<='Z'; rod++){
            if(rod!=source && rod!=dest && rod<=towers)
            return rod;
        }
        return 'A';
    }
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println("No of disks:");
        int n = s.nextInt();
        System.out.println("No of towers:");
        int towers = s.nextInt();
        System.out.println("Source");
        char source = s.next().charAt(0);
        System.out.println("Dest");
        char dest = s.next().charAt(0);
        move(n, towers, source,dest);
    }
}
