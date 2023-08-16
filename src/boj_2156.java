import java.util.Scanner;

public class boj_2156 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = Integer.parseInt(sc.nextLine());
        int[] wine = new int[n+1];
        wine[0] = 0;
        for(int i=1; i<=n; i++) wine[i] = Integer.parseInt(sc.nextLine());
        
        int[] dp = new int[n+1];
        dp[0] = wine[0];
        dp[1] = wine[1];
        if(n > 1) dp[2] = wine[1] + wine[2];
        
        for(int i=3; i<=n; i++)
            dp[i] = Math.max(Math.max(dp[i-2] + wine[i], dp[i-3] + wine[i-1] + wine[i]), dp[i-1]);
        
        System.out.println(dp[n]);
    }
}