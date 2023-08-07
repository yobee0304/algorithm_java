import java.util.Scanner;

public class boj_2529 {
    
    private static int N;
    private static String[] signs;
    private static String first, last;
    private static boolean[] visited;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        N = Integer.parseInt(sc.nextLine());
        signs = sc.nextLine().split(" ");
        int[] full = new int[signs.length + 1];
        
        first = ""; last = "";
        visited = new boolean[10];
        for(int i=0; i<10; i++) visited[i] = false;
        
        for(int i=0; i<10; i++){
            visited[i] = true;
            full[0] = i;
            dfs(full, 0, N);
            visited[i] = false;
        }
        
        System.out.println(last);
        System.out.println(first);
    }
    
    public static void dfs(int[] full, int now, int end) {
        if(now == end) {
            String ans = "";
            for(int i=0; i<full.length; i++) ans += full[i];
            
            if("".equals(first)) first = ans;
            last = ans;
            
            return;
        }
        
        for(int i=0; i<10; i++){
            if(visited[i]) continue;
            
            if(compare(full[now], signs[now], i)){
                visited[i] = true;
                int[] newArr = copy(full);
                newArr[now+1] = i;
                dfs(newArr, now+1, end);
                visited[i] = false;
            }
        }
    }
    
    public static int[] copy(int[] origin){
        int[] newArr = new int[origin.length];
        for(int i=0; i<origin.length; i++) newArr[i] = origin[i];
        
        return newArr;
    }
    
    public static boolean compare(int a, String comp, int b){
        if(">".equals(comp))
            return a > b;
        else if("<".equals(comp))
            return a < b;
        return false;
    }
}