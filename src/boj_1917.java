import java.util.Scanner;

public class boj_1917 {
    
    public static StringBuffer sb;
    public static String[][] map;
    public static boolean[][] visit;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sb = new StringBuffer();
        map = new String[6][6];
        visit = new boolean[6][6];
        
        for(int i=0; i<3; i++) {
            for(int j=0; j<6; j++) map[j] = sc.nextLine().split(" ");
            
            for(int j=0; j<6; j++)
                for(int k=0; k<6; k++)
                    visit[j][k] = false;
            
            int cnt = 0;
            for(int j=0; j<6; j++){
                for(int k=0; k<6; k++){
                    if(checkCube(j, k)){
                        visit[j][k] = true;
                        cnt += 2;
                    }
                }
            }
            
            if(cnt == 6) sb.append("yes");
            else sb.append("no");
            sb.append("\n");
        }
        
        System.out.println(sb.toString());
    }
    
    public static boolean checkCube(int y, int x) {
        if(!"1".equals(map[y][x]) || visit[y][x]) return false;
        
        if(chkToY(y-1, x, -1)) return true;
        if(chkToY(y+1, x, 1)) return true;
        if(chkToX(y, x-1, -1)) return true;
        if(chkToX(y, x+1, 1)) return true;
        return false;
    }
    
    public static boolean chkRange(int y, int x) {
        if(y >= 0 && y < 6 && x >= 0 && x < 6) return true;
        return false;
    }
    
    public static boolean chkToY(int y, int x, int mv){
        int originY = y;    int originX = x;
        // right
        while(chkRange(y, x) && "1".equals(map[y][x])){
            if(chkRange(y+mv, x) && "1".equals(map[y+mv][x]) && !visit[y+mv][x]){
                visit[y+mv][x] = true;
                return true;
            }
            x += 1;
        }
        
        y = originY;    x = originX;
        // left
        while(chkRange(y, x) && "1".equals(map[y][x])){
            if(chkRange(y+mv, x) && "1".equals(map[y+mv][x]) && !visit[y+mv][x]){
                visit[y+mv][x] = true;
                return true;
            }
            x -= 1;
        }
        
        return false;
    }
    
    public static boolean chkToX(int y, int x, int mv){
        int originY = y;    int originX = x;
        // down
        while(chkRange(y, x) && "1".equals(map[y][x])){
            if(chkRange(y, x+mv) && "1".equals(map[y][x+mv]) && !visit[y][x+mv]){
                visit[y][x+mv] = true;
                return true;
            }
            y += 1;
        }
        
        y = originY;    x = originX;
        // up
        while(chkRange(y, x) && "1".equals(map[y][x])){
            if(chkRange(y, x+mv) && "1".equals(map[y][x+mv]) && !visit[y][x+mv]){
                visit[y][x+mv] = true;
                return true;
            }
            y -= 1;
        }
        
        return false;
    }
}