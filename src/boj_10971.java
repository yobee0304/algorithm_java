import java.util.Arrays;
import java.util.Scanner;

public class boj_10971{
    
    static int N, min;
    static int[][] map;
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(sc.nextLine());
        map = new int[N][N];
        
        for(int i=0; i<N; i++){
            String[] inpt = sc.nextLine().split(" ");
            
            for(int j=0; j<N; j++) map[i][j] = Integer.parseInt(inpt[j]);
        }
        
        min = -1;
        for(int i=0; i<N; i++){
            boolean[] v = new boolean[N];
            Arrays.fill(v, false);
            
            v[i] = true;
            dfs(i, i, 1, 0, v);
        }
        
        System.out.println(min);
    }
    
    public static void dfs(int start, int now, int cnt, int sum, boolean[] v){
        if(cnt == N) {
            if(map[now][start] > 0)
                min = min > 0 ? Math.min(min, sum + map[now][start]) : sum + map[now][start];
            
            return;
        }
        
        for(int i=0; i<N; i++){
            if(map[now][i] > 0 && !v[i]){
                boolean[] new_v = copyV(v);
                new_v[i] = true;
                dfs(start, i, cnt+1, sum + map[now][i], new_v);
            }
        }
    }
    
    public static boolean[] copyV(boolean[] origin_v){
        boolean[] new_v = new boolean[N];
        for(int i=0; i<N; i++) new_v[i] = origin_v[i];
        
        return new_v;
    }
}