import java.util.Scanner;

public class boj_11729 {

    private static StringBuffer sb = new StringBuffer();
    private static int cnt = 0;

    private static void move(String start, String end){
        cnt++;
        sb.append(start + " " + end + "\n");
    }

    private static void hanoi(int N, String start, String end, String mid){
        if(N == 1){
            move(start, end);
            return;
        }
        else{
            hanoi(N-1, start, mid, end);    // start -> mid : N-1개 이동
            move(start, end);               // start -> end : 가장 큰 원반 이동
            hanoi(N-1, mid, end, start);    // mid -> end   : mid에 옮겨놨던 나머지 원반 이동
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        try{
            int K = Integer.parseInt(sc.nextLine());

            hanoi(K, "1", "3", "2");
            
            System.out.println(cnt);
            System.out.print(sb); // StringBuffer를 통해 System.out.println 호출 최소화 (성능 이슈)
        } catch(Exception e){
            e.printStackTrace();
        } finally{
            sc.close();
        }
    }
}
