package leetcode;

import java.util.ArrayList;
import java.util.List;

public class sol2221 {
    
    public int triangularSum(int[] nums) {
        List<Integer> preTri = new ArrayList<>();
        List<Integer> nowTri = new ArrayList<>();

        for(int i=0; i<nums.length; i++)
            preTri.add(nums[i]);

        for(int i=0; i<nums.length-1; i++) {
            nowTri.clear();

            for(int j=0; j<preTri.size()-1; j++) {
                nowTri.add((preTri.get(j) + preTri.get(j+1)) % 10);
            }

            preTri.clear();
            preTri.addAll(nowTri);
        }

        return nowTri.size() > 0 ? nowTri.get(0) : preTri.get(0);
    }
}
