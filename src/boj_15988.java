import java.util.Scanner;

public class boj_15988 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int T = Integer.parseInt(sc.nextLine());
        int max = -1;
        int[] n = new int[T];
        for(int i=0; i<T; i++){
            n[i] = Integer.parseInt(sc.nextLine());
            max = Math.max(max, n[i]);
        }
        
        Long dp[] = new Long[max+1];
        
        dp[0] = (long) 1;
        for(int i=1; i<=max; i++) {
            if(i == 1) dp[i] = (long) 1;
            else if(i == 2) dp[i] = (long) 2;
            else dp[i] = (dp[i-1] + dp[i-2] + dp[i-3]) % 1000000009;
        }
        
        for(int i=0; i<T; i++) System.out.println(dp[n[i]]);
    }
}