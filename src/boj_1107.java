import java.util.Scanner;

public class boj_1107 {
    
    private static boolean[] remocon;
    private static int N, M, min;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        remocon = new boolean[10];
        for(int i=0; i<10; i++) remocon[i] = true;
        
        N = sc.nextInt();
        M = sc.nextInt();
        for(int i=0; i<M; i++){
            int btn = sc.nextInt();
            remocon[btn] = false;
        }
        
        min = Math.abs(N - 100);
        int digit = checkDigit(N);
        
        for(int d = digit-1; d <= digit+1; d++){
            if(d == 0) continue;
            
            dfs("", 0, d);
        }
        
        System.out.println(min);
    }
    
    public static void dfs(String channel, int now, int digit) {
        if(now == digit) {
            min = Math.min(min, digit + Math.abs(N - Integer.parseInt(channel)));
            return;
        }
        
        for(int i=0; i<10; i++){
            if(remocon[i]) dfs(channel + Integer.toString(i), now+1, digit);
        }
    }
    
    public static int checkDigit(int N) {
        int ans = 0;
        
        if(N == 0) return 1;
        
        while(N > 0){
            ans++;
            N /= 10;
        }
        
        return ans;
    }
}