package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class sol229 {
    
    public static void main(String[] args) {
        int[] num1 = {3, 2, 3};
        List<Integer> major1 = majorityElement(num1);

        System.out.print("1> ");
        for(int n : major1) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    public static List<Integer> majorityElement(int[] nums) {
        List<Integer> rslt = new ArrayList<>();
        Map<Integer, Integer> hashMap = new HashMap<>();
        int max = nums.length / 3;

        for(int i=0; i<nums.length; i++) {
            if(!hashMap.containsKey(nums[i]))
                hashMap.put(nums[i], 1);
            else
                hashMap.put(nums[i], hashMap.get(nums[i]) + 1);
        }

        for(int key : hashMap.keySet()) {
            if(hashMap.get(key) > max)
                rslt.add(key);
        }

        return rslt;
    }
}
