import java.util.Scanner;

public class boj_1748 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        Long ans = (long) 0;
        int N = sc.nextInt();
        int tmpN = N; int cnt = 0;
        
        while (tmpN > 0){
            cnt++;
            tmpN /= 10;
        }
        
        int start = 1; int end = 10;
        for(int i=1; i<=cnt; i++){
            if(i == cnt) end = N + 1;
            
            ans += i * (end - start);
            
            start *= 10;
            end *= 10;
        }
        
        System.out.println(ans);
    }
}