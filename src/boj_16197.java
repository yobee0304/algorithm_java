import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class boj_16197 {
    public static int N, M;
    public static String[][] board;
    public static List<String> visit;
    public static int[][] DIR = {{0,1}, {1,0}, {0,-1}, {-1,0}};
    
    static class Node{
        public Coin coin1;
        public Coin coin2;
        
        Node(Coin coin1, Coin coin2){
            this.coin1 = new Coin(coin1.y, coin1.x);
            this.coin2 = new Coin(coin2.y, coin2.x);
        }
        
        public String getCoinPos() {
            return Integer.toString(coin1.y) + "|" + Integer.toString(coin1.x) + "|" + Integer.toString(coin2.y) + "|" + Integer.toString(coin2.x);
        }
    }
    
    static class Coin{
        public int y, x;
        
        Coin(int y, int x){
            this.y = y;
            this.x = x;
        }
        
        public boolean move(int dirY, int dirX){
            if(y+dirY >= 0 && y+dirY < N && x+dirX >= 0 && x+dirX < M){
                if(!"#".equals(board[y+dirY][x+dirX])){
                    this.y += dirY;
                    this.x += dirX;
                }
                return false;
            }
            
            return true;
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String[] inpt = sc.nextLine().split(" ");
        N = Integer.parseInt(inpt[0]);
        M = Integer.parseInt(inpt[1]);
        board = new String[N][M];
        visit = new ArrayList<>();
        
        Coin coin1 = new Coin(-1, -1);
        Coin coin2 = new Coin(-1, -1);
        
        for(int i=0; i<N; i++) {
            board[i] = sc.nextLine().split("");
            
            for(int j=0; j<M; j++){
                if("o".equals(board[i][j])){
                    if(coin1.y < 0 || coin1.x < 0){
                        coin1.y = i;
                        coin1.x = j;
                    }else{
                        coin2.y = i;
                        coin2.x = j;
                    }
                    board[i][j] = ".";
                }
            }
        }
        
        Queue<Node> BFS = new LinkedList<>();
        Node first = new Node(coin1, coin2);
        BFS.add(first);
        visit.add(first.getCoinPos());
        
        int cnt = 0;
        while(BFS.size() > 0){
            cnt++;
            int bfsSize = BFS.size();
            
            for(int i=0; i<bfsSize; i++){
                Node node = BFS.poll();
                
                for(int j=0; j<4; j++){
                    Node newNode = new Node(node.coin1, node.coin2);
                    boolean isOutOne = newNode.coin1.move(DIR[j][0], DIR[j][1]);
                    boolean isOutTwo = newNode.coin2.move(DIR[j][0], DIR[j][1]);
                    
                    if((isOutOne && !isOutTwo) || (!isOutOne && isOutTwo)){
                        System.out.println(cnt);
                        return;
                    }
                    
                    if(!isOutOne && !isOutTwo && !visit.contains(newNode.getCoinPos())){
                        BFS.offer(newNode);
                        visit.add(newNode.getCoinPos());
                    }
                }
            }
            
            if(cnt >= 10) break;
        }
        
        System.out.println("-1");
    }
    
    public static boolean isOut(Coin coin) {
        if(coin.y >= 0 && coin.y < N && coin.x >= 0 && coin.x < M) return false;
        return true;
    }
}