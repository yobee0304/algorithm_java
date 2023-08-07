import java.util.Scanner;

public class boj_15649 {
    
    public static String[] num;
    public static int N, M;
    public static StringBuffer sb = new StringBuffer();
    
    public static void dfs(String path, int now){
        if (now == M){
            sb.append(path.substring(0, path.length() - 1) + "\n");
            return;
        }
        
        for(int i=0; i<N; i++){
            if(!path.contains(num[i])) dfs(path + num[i] + " ", now+1);
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] inpt = sc.nextLine().split(" ");
        
        N = Integer.parseInt(inpt[0]);
        M = Integer.parseInt(inpt[1]);
        
        num = new String[N];
        for(int i=0; i<N; i++) num[i] = Integer.toString(i + 1);
        
        dfs("", 0);
        
        System.out.println(sb.toString());
    }
}