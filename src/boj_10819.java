import java.util.Scanner;

public class boj_10819 {
    
    private static int N, Max;
    private static String[] num;
    private static boolean[] visited;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        N = Integer.parseInt(sc.nextLine());
        num = sc.nextLine().split(" ");
        Max = -1;
        
        visited = new boolean[N];
        for(int i=0; i<N; i++) visited[i] = false;
        
        dfs("", 0);
        
        System.out.println(Max);
    }
    
    public static void dfs(String path, int now){
        if(now == N){
            int cnt = 0;
            String[] rslt = path.substring(0, path.length()-1).split(" ");
            
            for(int i=0; i<N-1; i++)
                cnt += Math.abs(Integer.parseInt(rslt[i]) - Integer.parseInt(rslt[i+1]));
            
            Max = Math.max(Max, cnt);
            return;
        }
        
        for(int i=0; i<N; i++){
            if(visited[i]) continue;
            
            visited[i] = true;
            dfs(path + num[i] + " ", now+1);
            visited[i] = false;
        }
    }
}