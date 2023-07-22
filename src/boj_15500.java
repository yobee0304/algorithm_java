import java.util.Scanner;
import java.util.Stack;

public class boj_15500{
    
    private static int cnt = 0;
    private static StringBuffer sb = new StringBuffer();
    
    private static Stack<Integer> T1 = new Stack<>();
    private static Stack<Integer> T2 = new Stack<>();
    
    private static void move(String fromN, String toN){
        sb.append(fromN)
          .append(" ")
          .append(toN)
          .append("\n");
    }
    
    private static void move(String fromN, int max){
        String toN;
        Stack<Integer> fromT, toT;
        
        if("1".equals(fromN)){
            toN = "2";
            fromT = T1;
            toT = T2;
        }
        else{
            toN = "1";
            fromT = T2;
            toT = T1;
        }
        
        while(true){
            int top = fromT.pop();
            cnt++;
            
            if(top == max){
                move(fromN, "3");
                break;
            }
            
            toT.push(top);
            move(fromN, toN);
        }
    }
    
    public static void main(String[] agrs){
        Scanner sc = new Scanner(System.in);
        
        int N = Integer.parseInt(sc.nextLine());
        String[] inpt = sc.nextLine().split(" ");
        
        for(int i=0; i < N; i++){
            T1.push(Integer.parseInt(inpt[i]));
        }
        
        for(int max = N; max >= 1; max--){
            if(T1.contains(max)){
                move("1", max);
            }
            else if(T2.contains(max)){
                move("2", max);
            }
        }
        
        System.out.println(cnt);
        System.out.print(sb);
    }
}