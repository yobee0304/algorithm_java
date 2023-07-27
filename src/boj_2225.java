import java.util.Scanner;

public class boj_2225 {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] inpt = sc.nextLine().split(" ");
        
        int N = Integer.parseInt(inpt[0]);
        int K = Integer.parseInt(inpt[1]);
        int[][] dp = new int[N+1][K+1];
        
        for(int n = 0; n <= N; n++) dp[n][0] = 0;
        for(int k = 1; k <= K; k++) dp[0][k] = 1;
        
        for(int k = 1; k <= K; k++)
            for(int n = 1; n <= N; n++)
                dp[n][k] = (dp[n-1][k] + dp[n][k-1]) % 1000000000;
        
        System.out.println(dp[N][K]);
    }
}