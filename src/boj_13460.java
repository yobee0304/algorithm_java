import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class boj_13460 {
    private static int N, M;
    private static String[][] Map;
    private static Queue<Case> BFS;
    private static List<String> mapHistory;
    private static int[][] DIR = {{0,1}, {1,0}, {0,-1},{-1,0}};
    
    public static class Ball{
        public int x, y;
        
        Ball(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
    
    public static class Case{
        public String[][] map;
        public Ball red, blue, hole;
        public boolean isRedStop, isBlueStop;
        
        Case(String[][] originMap){
            map = new String[N][M];
            
            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {
                    map[i][j] = originMap[i][j];
                    
                    if("R".equals(map[i][j])) this.red = new Ball(i, j);
                    else if("B".equals(map[i][j])) this.blue = new Ball(i, j);
                    else if("O".equals(map[i][j])) this.hole = new Ball(i, j);
                }
            }
        }
        
        public String getBallPosition(){
            return Integer.toString(red.y) + Integer.toString(red.x) + "|" + Integer.toString(blue.y) + Integer.toString(blue.x);
        }
        
        public boolean holeInRed(){
            if(red.y == hole.y && red.x == hole.x) return true;
            return false;
        }
        
        public boolean holeInBlue(){
            if(blue.y == hole.y && blue.x == hole.x) return true;
            return false;
        }
        
        public void moveRed(int dir){
            if(!isRedStop){
                int redY = this.red.y;    int redX = this.red.x;
                int moveY = DIR[dir][0];    int moveX = DIR[dir][1];
                
                if(redY + moveY >= 0 && redY + moveY < N && redX + moveX >= 0 && redX + moveX < M
                      && (".".equals(map[redY + moveY][redX + moveX]) || "O".equals(map[redY + moveY][redX + moveX]))){
                    this.red.y += moveY;
                    this.red.x += moveX;
                    
                    if("O".equals(map[this.red.y][this.red.x])) isRedStop = true;
                } else{
                    isRedStop = true;
                    map[redY][redX] = "R";
                }
            }
        }
        
        public void moveBlue(int dir){
            if(!isBlueStop){
                int blueY = this.blue.y;    int blueX = this.blue.x;
                int moveY = DIR[dir][0];    int moveX = DIR[dir][1];
                
                if(blueY + moveY >= 0 && blueY + moveY < N && blueX + moveX >= 0 && blueX + moveX < M
                      && (".".equals(map[blueY + moveY][blueX + moveX]) || "O".equals(map[blueY + moveY][blueX + moveX]))){
                    this.blue.y += moveY;
                    this.blue.x += moveX;
                    
                    if("O".equals(map[this.blue.y][this.blue.x])) isBlueStop = true;
                } else{
                    isBlueStop = true;
                    map[blueY][blueX] = "B";
                }
            }
        }
        
        public void moveBall(int dir){
            map[this.red.y][this.red.x] = ".";
            map[this.blue.y][this.blue.x] = ".";
            
            isRedStop = false;
            isBlueStop = false;
            
            while(true) {
                if((dir == 0 && this.red.x > this.blue.x)
                  || (dir == 1 && this.red.y > this.blue.y)
                  || (dir == 2 && this.red.x < this.blue.x)
                  || (dir == 3 && this.red.y < this.blue.y)){
                    moveRed(dir);
                    moveBlue(dir);
                } else{
                    moveBlue(dir);
                    moveRed(dir);
                }
                
                if(isRedStop && isBlueStop) break;
            }
        }
    }
    
    public static void main(String[] args) {
        BFS = new LinkedList<>();
        mapHistory = new ArrayList<>();
        
        Scanner sc = new Scanner(System.in);
        String[] inpt = sc.nextLine().split(" ");
        
        N = Integer.parseInt(inpt[0]);
        M = Integer.parseInt(inpt[1]);
        Map = new String[N][M];
        
        for(int n=0; n<N; n++) Map[n] = sc.nextLine().split("");
        
        Case case1 = new Case(Map);
        mapHistory.add(case1.getBallPosition());
        BFS.offer(case1);
        
        int cnt = 0;
        
        while(BFS.size() > 0 && cnt < 10){
            cnt++;
            int bfsSize = BFS.size();
            
            for(int i=0; i<bfsSize; i++){
                Case origin = BFS.poll();
                
                for(int dir=0; dir<4; dir++){
                    Case newCase = new Case(origin.map);
                    newCase.moveBall(dir);
                    
                    String newBallPos = newCase.getBallPosition();
                    if(!mapHistory.contains(newBallPos)){
                        boolean isHoleInRed = newCase.holeInRed();
                        boolean isHoleInBlue = newCase.holeInBlue();
                        
                        if(isHoleInRed && !isHoleInBlue) {
                            System.out.println(cnt);
                            return;
                        }else if(!isHoleInRed && !isHoleInBlue){
                            mapHistory.add(newBallPos);
                            BFS.offer(newCase);
                        }
                    }
                }
            }
        }
        
        System.out.println("-1");
    }
}