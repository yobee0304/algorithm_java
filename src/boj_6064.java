import java.util.Scanner;

public class boj_6064 {
    
    public static int lcm(int a, int b){
        return (a * b) / gcd(a, b);
    }
    
    public static int gcd(int a, int b){
        
        if(b == 0) return a;
        
        return gcd(b, a%b);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int T, M, N, x, y;
        T = Integer.parseInt(sc.nextLine());
        int[] rslt = new int[T];
        
        for(int i=0; i<T; i++){
            String[] inpt = sc.nextLine().split(" ");
            M = Integer.parseInt(inpt[0]);
            N = Integer.parseInt(inpt[1]);
            x = Integer.parseInt(inpt[2]);
            y = Integer.parseInt(inpt[3]);
            
            int lcm = lcm(M, N);
            int nextX = x % (M+1);
            int nextY = x;
            
            while(true){
                nextY = nextY % N == 0 ? N : nextY % N;

                if(nextX > lcm){
                    rslt[i] = -1;
                    break;
                }
                
                if(nextY == y){
                    rslt[i] = nextX;
                    break;
                }
                
                nextX += M;
                nextY += M;
            }
        }
        
        for(int i=0; i<T; i++) System.out.println(rslt[i]);
    }
}