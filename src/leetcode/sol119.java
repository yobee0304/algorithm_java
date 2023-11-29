package leetcode;

import java.util.ArrayList;
import java.util.List;

public class sol119 {
    
    public List<Integer> getRow(int rowIndex) {
        List<Integer> preRow = new ArrayList<>();
        List<Integer> nowRow = new ArrayList<>();

        for(int i=0; i<=rowIndex; i++) {
            nowRow.clear();

            for(int j=0; j<=i; j++) {
                if(j == 0 || j == i)
                    nowRow.add(1);
                else
                    nowRow.add(preRow.get(j-1) + preRow.get(j));
            }

            preRow.clear();
            preRow.addAll(nowRow);
        }

        return nowRow;
    }
}
