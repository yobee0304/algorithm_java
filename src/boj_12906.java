import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class boj_12906 {
    
    static class Node {
        public Stack<Character>[] towers;
        
        Node() {
            this.towers = new Stack[3];
            
            for(int i=0; i<3; i++) 
                towers[i] = new Stack<>();
        }
        
        public String getStatusCode() {
            String statusCode = "";

            for(Character c : towers[0]) statusCode += c;
            statusCode += '/';
            for(Character c : towers[1]) statusCode += c;
            statusCode += '/';
            for(Character c : towers[2]) statusCode += c;

            return statusCode;
        }
    }
    
    public static Node copyNode(Node origin){
        Node newNode = new Node();

        for(int i=0; i<3; i++){
            for(Character c : origin.towers[i]) newNode.towers[i].push(c);
        }

        return newNode;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int rslt = 0;
        Queue<Node> bfs = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();

        Node endNode = new Node();
        Node node = new Node();
        for(int i=0; i<3; i++){
            String inpt = sc.nextLine();
            String tower = "";

            if(!"0".equals(inpt.substring(0,1)))
                tower = inpt.split(" ")[1];

            for(int j=0; j<tower.length(); j++){
                node.towers[i].add(tower.charAt(j));

                if(tower.charAt(j) == 'A') endNode.towers[0].add(tower.charAt(j));
                else if(tower.charAt(j) == 'B') endNode.towers[1].add(tower.charAt(j));
                else if(tower.charAt(j) == 'C') endNode.towers[2].add(tower.charAt(j));
            }
        }

        String endStatus = endNode.getStatusCode();

        bfs.offer(node);
        visited.add(node.getStatusCode());

        while(bfs.size() > 0){
            int qSize = bfs.size();

            for(int i=0; i<qSize; i++){
                Node now = bfs.poll();

                if(now.getStatusCode().equals(endStatus)){
                    System.out.println(rslt);
                    return;
                }

                for(int from=0; from < 3; from++){
                    for(int j=1; j < 3; j++){
                        if(!now.towers[from].isEmpty()){
                            Node next = copyNode(now);
                            int to = (from + j) % 3;
                            next.towers[to].push(next.towers[from].pop());

                            String nextStatus = next.getStatusCode();
                            if(!visited.contains(nextStatus)){
                                visited.add(nextStatus);
                                bfs.offer(next);
                            }
                        }
                    }
                }
            }
            rslt++;
        }
    }
}