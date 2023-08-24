import java.util.Scanner;

public class boj_11054 {
    
    public static int N;
    public static int[] A, DP_up, DP_down;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        N = Integer.parseInt(sc.nextLine());
        A = new int[N];
        DP_up = new int[N];
        DP_down = new int[N];
        
        String[] inpt = sc.nextLine().split(" ");
        for(int i=0; i<N; i++) A[i] = Integer.parseInt(inpt[i]);
        
        DP_up[0] = 1;
        for(int i=1; i<N; i++){
            DP_up[i] = 1;
            
            for(int j=0; j<i; j++)
                if(A[j] < A[i]) DP_up[i] = Math.max(DP_up[i], DP_up[j] + 1);
        }
        
        DP_down[N-1] = 1;
        for(int i=N-2; i>=0; i--){
            DP_down[i] = 1;
            
            for(int j=N-1; j>=1; j--)
                if(A[i] > A[j]) DP_down[i] = Math.max(DP_down[i], DP_down[j] + 1);
        }
        
        int DP_max = -1;
        for(int i=0; i<N; i++) DP_max = Math.max(DP_max, DP_up[i] + DP_down[i] - 1);
        
        System.out.println(DP_max);
    }
}