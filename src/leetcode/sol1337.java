package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class sol1337 {
    public static void main(String[] args) {
        int[][] mat = {{1,0,0,0},{1,1,1,1},{1,0,0,0},{1,0,0,0}};
        int k=2;

        int[] weakestRows = kWeakestRows(mat, k);
        for(int i=0; i<k; i++)
            System.out.print(weakestRows[i] + " ");
        System.out.println();
    }

    public static int[] kWeakestRows(int[][] mat, int k) {
        int[] weakestRows = new int [k];
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> sumList = new ArrayList<>();

        for(int i=0; i<mat.length; i++) {
            int sum = 0;

            for(int j=0; j<mat[i].length; j++)
                sum += mat[i][j];

            List<Integer> indexList;
            if(map.containsKey(sum)) indexList = map.get(sum);
            else indexList = new ArrayList<>();

            indexList.add(i);
            map.put(sum, indexList);

            if(!sumList.contains(sum)) sumList.add(sum);
        }

        Collections.sort(sumList);

        int i=0;
        for(int sum : sumList) {
            List<Integer> indexList = map.get(sum);

            for(int index : indexList) {
                weakestRows[i++] = index;
                if(i >= k) break;
            }

            if(i >= k) break;
        }

        return weakestRows;
    }
}
