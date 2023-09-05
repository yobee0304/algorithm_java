import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class boj_17471 {
    static int N, min;
    static Node[] map;
    
    static class Node{
        public int people;
        public List<Integer> neighbor;
        
        Node(int people){
            this.people = people;
            neighbor = new ArrayList<>();
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(sc.nextLine());
        map = new Node[N+1];
        
        String[] inpt = sc.nextLine().split(" ");
        for(int i=1; i<=N; i++){
            String[] inpt2 = sc.nextLine().split(" ");
            
            map[i] = new Node(Integer.parseInt(inpt[i-1]));
            for(int j=1; j<inpt2.length; j++) map[i].neighbor.add(Integer.parseInt(inpt2[j]));
        }
        
        min = -1;
        divide(new ArrayList<>(), new ArrayList<>(), 1);
        
        System.out.println(min);
    }
    
    public static List<Integer> copyList(List<Integer> origin){
        List<Integer> newList = new ArrayList<>();
        for(int num : origin) newList.add(num);
        
        return newList;
    }
    
    public static void divide(List<Integer> A, List<Integer> B, int cnt){
        if(cnt > N){
            if(A.size() == 0 || B.size() == 0) return;
            
            List<Integer> groupA = new ArrayList<>();
            List<Integer> groupB = new ArrayList<>();
            groupA.add(A.get(0));
            groupB.add(B.get(0));
            
            checkGroup(A.get(0), A, groupA);
            checkGroup(B.get(0), B, groupB);
            
            if(groupA.size() == A.size() && groupB.size() == B.size()){
                min = min >= 0 ? Math.min(min, Math.abs(sumGroup(A) - sumGroup(B)))
                    : Math.abs(sumGroup(A) - sumGroup(B));
            }
            
            return;
        }
        
        List<Integer> newA = copyList(A);
        List<Integer> newB = copyList(B);
        newA.add(cnt);
        newB.add(cnt);
        
        divide(newA, B, cnt+1);
        divide(A, newB, cnt+1);
    }
    
    public static void checkGroup(int node, List<Integer> nodes, List<Integer> visited){
        for(int nextNode : map[node].neighbor){
            if(nodes.contains(nextNode) && !visited.contains(nextNode)){
                visited.add(nextNode);
                checkGroup(nextNode, nodes, visited);
            }
        }
    }
    
    public static int sumGroup(List<Integer> nodes){
        int sum = 0;
        for(int node : nodes)sum += map[node].people;
        
        return sum;
    }
}