import java.util.Scanner;

public class boj_10974 {
    
    static int N;
    static boolean[] visited;
    static StringBuffer sb = new StringBuffer();
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        
        visited = new boolean[N+1];
        for(int i=0; i<= N; i++) visited[i] = false;
        
        dfs("", 0);
        
        System.out.println(sb.toString());
    }
    
    public static void dfs(String path, int now) {
        if(now == N) {
            sb.append(path.substring(0, path.length()-1) + "\n");
            return;
        }
        
        for(int i=1; i<=N; i++) {
            if(visited[i]) continue;
            
            visited[i] = true;
            dfs(path + Integer.toString(i) + " ", now+1);
            visited[i] = false;
        }
    }
}