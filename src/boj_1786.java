import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class boj_1786 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String T = sc.nextLine();
        String P = sc.nextLine();
        
        int[] pi = new int[P.length()];
        int j = 0;
        for(int i=1; i<P.length(); i++){
            while(j > 0 && P.charAt(i) != P.charAt(j)){
                j = pi[j - 1];
            }
            
            if(P.charAt(i) == P.charAt(j)){
                pi[i] = ++j;
            }
        }
        
        List<Integer> rslt = new ArrayList<>();
        j = 0;
        for(int i=0; i<T.length(); i++){
            while(j > 0 && T.charAt(i) != P.charAt(j)){
                j = pi[j - 1];
            }
            
            if(T.charAt(i) == P.charAt(j)){
                if((j+1) == P.length()){
                    rslt.add(i - P.length() + 2);
                    j = pi[j];
                } else {
                    j++;
                }
            }
        }
        
        System.out.println(rslt.size());
        for(int num : rslt) System.out.print(num + " ");
        System.out.println();
    }
}