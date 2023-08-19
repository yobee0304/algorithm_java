import java.util.Scanner;

public class boj_15990 {
    static Long mod = (long) 1000000009;
    
    static class Node {
        public Long st1;
        public Long st2;
        public Long st3;
        
        public Node(Long st1, Long st2, Long st3){
            this.st1 = st1;
            this.st2 = st2;
            this.st3 = st3;
        }
        
        public Long sum() {
            return (st1 + st2 + st3) % mod;
        }
    }
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int T = Integer.parseInt(sc.nextLine());
        int n[] = new int[T];
        int max = -1;
        for(int i=0; i<T; i++){
            n[i] = Integer.parseInt(sc.nextLine());
            max = Math.max(max, n[i]);
        }
        
        Node dp[] = new Node[1000001];
        dp[1] = new Node((long) 1, (long) 0, (long) 0);
        dp[2] = new Node((long) 0, (long) 1, (long) 0);
        dp[3] = new Node((long) 1, (long) 1, (long) 1);
        
        for(int i=4; i<=max; i++)
            dp[i] = new Node((dp[i-1].st2 + dp[i-1].st3) % mod, (dp[i-2].st1 + dp[i-2].st3) % mod, (dp[i-3].st1 + dp[i-3].st2) % mod);
    
        for(int i=0; i<T; i++) System.out.println(dp[n[i]].sum());
    }
}