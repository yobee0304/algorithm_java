import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class boj_10973 {
    
    private static String[] num;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = Integer.parseInt(sc.nextLine());
        num = sc.nextLine().split(" ");
        
        boolean isNext = false;
        
        for(int i=N-2; i>=0; i--) {
            int left = Integer.parseInt(num[i]);
            int right = Integer.parseInt(num[i+1]);
            
            if(left > right) {
                rebase(i, N-1);
                isNext = true;
                break;
            }
        }
        
        if(isNext) System.out.println(String.join(" ", num));
        else System.out.println("-1");
    }
    
    public static void rebase(int start, int end) {
        List<Integer> number = new ArrayList<>();
        for(int i=start; i<=end; i++) 
            number.add(Integer.parseInt(num[i]));
        
        number.sort(Collections.reverseOrder());
        
        int idx = start+1;
        String now = num[start];
        for(int i=0; i<number.size(); i++) {
            if(i > 0 && now.equals(Integer.toString(number.get(i-1)))){
                num[start] = Integer.toString(number.get(i));
            }else{
                num[idx++] = Integer.toString(number.get(i));
            }
        }
    }
}