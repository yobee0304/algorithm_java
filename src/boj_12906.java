import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj_12906 {
    
    public static boolean chkFnsh(String[] hanoi, int i){
        boolean rslt = true;
        String[] answer = {"A", "B", "C"};
        
        if(hanoi[i].contains(answer[(i+1)%3]) || hanoi[i].contains(answer[(i+2)%3])){
            rslt = false;
        }
        
        return rslt;
    }
    
    public static boolean chkEnd(String[] hanoi){
        boolean rslt = true;
        String[] answer = {"A", "B", "C"};
        
        for(int i=0; i<3; i++){
            if(hanoi[i].contains(answer[(i+1)%3]) || hanoi[i].contains(answer[(i+2)%3])){
                rslt = false;
                break;
            }
        }
        
        return rslt;
    }
    
    public static void main(String[] agrs){
        Scanner sc = new Scanner(System.in);
        
        int ans = 0;
        boolean isEnd = false;
        Queue<String> bfs = new LinkedList<>();
        String hanoi = "";
        
        for(int i=0; i<3; i++){
            String inpt = sc.nextLine();
            String tower = "";
            
            if(Integer.parseInt(inpt.substring(0, 1)) > 0){
                tower = inpt.substring(2);
            }
            hanoi += tower + "/";
        }
        
        hanoi = hanoi.substring(0, hanoi.length()-1);
        bfs.add(hanoi);
        
        while(bfs.size() > 0){
            boolean isTrue = false;
            int qSize = bfs.size();
            
            for(int i=0; i<qSize; i++){
                String[] hanoi_tower = {"", "", ""};
                String hanoi_tmp = bfs.poll();
                String[] hanoi_tower_tmp = hanoi_tmp.split("/");
                
                for(int j=0; j<hanoi_tower_tmp.length; j++){
                    hanoi_tower[j] = hanoi_tower_tmp[j];
                }
                
                if(chkEnd(hanoi_tower)){
                    isEnd = true;
                    break;
                }
                
                for(int j=0; j<3; j++){
                    if(hanoi_tower[j].length() == 0 || chkFnsh(hanoi_tower, j))
                        continue;
                    
                    String top = hanoi_tower[j].substring(hanoi_tower[j].length() - 1);
                    
                    String[] hanoi_tower_1 = new String[3];
                    String[] hanoi_tower_2 = new String[3];
                    
                    for(int k=0; k<3; k++){
                        hanoi_tower_1[k] = hanoi_tower[k];
                        hanoi_tower_2[k] = hanoi_tower[k];
                    }
                    
                    hanoi_tower_1[j] = hanoi_tower_1[j].substring(0, hanoi_tower_1[j].length() - 1);
                    hanoi_tower_1[(j+1)%3] = hanoi_tower_1[(j+1)%3] + top;
                    hanoi_tower_2[j] = hanoi_tower_2[j].substring(0, hanoi_tower_2[j].length() - 1);
                    hanoi_tower_2[(j+2)%3] = hanoi_tower_2[(j+2)%3] + top;
                
                    String hanoi_tower_1_tmp = String.join("/", hanoi_tower_1);
                    String hanoi_tower_2_tmp = String.join("/", hanoi_tower_2);

                    if(chkFnsh(hanoi_tower_1, (j+1)%3)){
                        bfs.clear();
                        bfs.add(hanoi_tower_1_tmp);
                        isTrue = true;
                        break;
                    }else if(chkFnsh(hanoi_tower_2, (j+2)%3)){
                        bfs.clear();
                        bfs.add(hanoi_tower_2_tmp);
                        isTrue = true;
                        break;
                    }else{
                        bfs.add(hanoi_tower_1_tmp);
                        bfs.add(hanoi_tower_2_tmp);
                    }
                }
                
                if(isTrue)
                    break;
            }
            
            if(isEnd)
                break;
            
            ans++;
        }
        
        System.out.println(ans);
    }
}