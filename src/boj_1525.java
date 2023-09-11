import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class boj_1525 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String cube = "";
        for(int i=0; i<3; i++){
            String[] inpt = sc.nextLine().split(" ");
            cube += String.join("", inpt);
        }
        
        Set<String> visited = new HashSet<>();
        Queue<String> BFS = new LinkedList<>();
        int[][] DIR = {{0,1},{1,0},{0,-1},{-1,0}};
        
        visited.add(cube);
        BFS.offer(cube);
        
        int minCnt = 0;
        while(BFS.size() > 0){
            int bfsSize = BFS.size();
            
            for(int i=0; i<bfsSize; i++){
                String newCube = BFS.poll();
                int empty = newCube.indexOf('0');
                
                if("123456780".equals(newCube)){
                    System.out.println(minCnt);
                    return;
                }
                
                for(int j=0; j<4; j++){
                    int ny = (empty / 3) + DIR[j][0];
                    int nx = (empty % 3) + DIR[j][1];
                    
                    if(ny >= 0 && ny < 3 && nx >= 0 && nx < 3) {
                        char move = newCube.charAt(ny * 3 + nx);
                        
                        String next = newCube.replace(move, '9');
                        next = next.replace('0', move);
                        next = next.replace('9', '0');
                        
                        if(!visited.contains(next)) {
                            visited.add(next);
                            BFS.offer(next);
                        }
                    }
                }
            }
            
            minCnt++;
        }
        
        System.out.println("-1");
    }
}