import java.util.Scanner;

public class boj_14503 {

    static int[][] direction = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int clean_field = 0;

    public static void clean(int[][] map, int N, int M, int y, int x, int d){

        if(map[y][x] == 0){
            map[y][x] = 2;
            clean_field += 1;
        }

        boolean isClean = false;
        for(int i=1; i<=4; i++){
            int next_d = (d-i) < 0 ? d-i+4 : d-i; // 반시계
            int next_y = y + direction[next_d][0];
            int next_x = x + direction[next_d][1];

            if(map[next_y][next_x] == 0){
                isClean = true;
                clean(map, N, M, next_y, next_x, next_d);
                break;
            }
        }

        if(!isClean){
            int back_d = (d+2) % 4; // 후진
            int back_y = y + direction[back_d][0];
            int back_x = x + direction[back_d][1];

            if(map[back_y][back_x] == 1)
                return;

            clean(map, N, M, back_y, back_x, d);
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        try{
            // START INPUT
            int N, M, r, c, d;
            String[] inpt = sc.nextLine().split(" ");
            N = Integer.parseInt(inpt[0]);
            M = Integer.parseInt(inpt[1]);
            
            inpt = sc.nextLine().split(" ");
            r = Integer.parseInt(inpt[0]);
            c = Integer.parseInt(inpt[1]);
            d = Integer.parseInt(inpt[2]);

            int[][] map = new int[N][M];
            for(int i=0; i<N; i++){
                inpt = sc.nextLine().split(" ");
                for(int j=0; j<M; j++){
                    map[i][j] = Integer.parseInt(inpt[j]);
                }
            }
            // END INPUT

            clean(map, N, M, r, c, d);

            System.out.println(clean_field);
        } catch(Exception e){
            e.printStackTrace();
        } finally{
            sc.close();
        }
    }
}