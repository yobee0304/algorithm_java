import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class boj_15661 {
    
    private static int N, min;
    private static int[][] S;
    
    static class Team {
        public List<Integer> member;
        public int score;
        
        Team() {
            member = new ArrayList<>();
            score = 0;
        }
        
        public void addMember(int newMem) {
            for(int origin : member) score += S[origin][newMem] + S[newMem][origin];
            this.member.add(newMem);
        }
        
        public Team copy() {
            Team team = new Team();
            
            for(int origin : this.member) team.member.add(origin);
            team.score = this.score;
            
            return team;
        }
    }
    
    public static void dfs(Team link, Team start, int n) {
        if(n == N) {
            int finalScore = Math.abs(link.score - start.score);
            min = min < 0 ? finalScore : Math.min(min, finalScore);
            return;
        }
        
        Team link_copy = link.copy();
        Team start_copy = start.copy();
        
        // 링크팁 추가
        link_copy.addMember(n);
        dfs(link_copy, start, n+1);
        // 스타트팀 추가
        start_copy.addMember(n);
        dfs(link, start_copy, n+1);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        N = Integer.parseInt(sc.nextLine());
        S = new int[N][N];
        
        for(int i = 0; i < N; i++){
            String[] inpt = sc.nextLine().split(" ");
            
            for(int j=0; j<N; j++){
                S[i][j] = Integer.parseInt(inpt[j]);
            }
        }
        
        min = -1;
        
        dfs(new Team(), new Team(), 0);
        
        System.out.println(min);
    }
}