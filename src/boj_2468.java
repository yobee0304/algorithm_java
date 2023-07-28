import java.util.HashSet;
import java.util.Scanner;

public class boj_2468 {
    
    public static int N;
    public static int[][] Map;
    public static boolean[][] visited;
    public static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    public static void initVisited() {
        for(int i=0; i<N; i++)
            for(int j=0; j<N; j++)
                visited[i][j] = false;
    }
    
    public static void dfs(int y, int x, int rain) {
        visited[y][x] = true;
        
        for(int n=0; n<4; n++) {
            int newY = y + dir[n][0];
            int newX = x + dir[n][1];
            
            if(newY >= 0 && newY < N && newX >= 0 && newX < N)
                if(!visited[newY][newX] && Map[newY][newX] > rain)
                    dfs(newY, newX, rain);
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        HashSet<Integer> rain = new HashSet<>();
        int areaMax= 1;
        
        N = Integer.parseInt(sc.nextLine());
        Map = new int[N][N];
        visited = new boolean[N][N];
        
        for(int i=0; i<N; i++){
            String[] inpt = sc.nextLine().split(" ");
            
            for(int j=0; j<N; j++){
                Map[i][j] = Integer.parseInt(inpt[j]);
                rain.add(Map[i][j]);
            }
        }
        
        for(int rainCnt : rain) {
            int areaNow = 0;
            initVisited();
            
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(!visited[i][j] && Map[i][j] > rainCnt) {
                        dfs(i, j, rainCnt);
                        areaNow++;
                    }
                }
            }
            
            areaMax = Math.max(areaNow, areaMax);
        }
        
        System.out.println(areaMax);
    }
}