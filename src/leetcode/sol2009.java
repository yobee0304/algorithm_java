package leetcode;

import java.util.Arrays;

public class sol2009 {

    public static void main(String[] args) {
        int[] nums = {1,2,3,5,6};
        System.out.println(minOperations(nums));
    }

    public static int minOperations(int[] nums) {
        int numLen = nums.length;
        int minOp = numLen;
        nums = Arrays.stream(nums).distinct().toArray();
        Arrays.sort(nums);

        for(int i=0; i<nums.length; i++) {
            if(minOp < i) break;

            int start = nums[i];
            int end = start + numLen - 1;
            int sum = 0;

            for(int j=i+1; j<nums.length; j++) {
                if(nums[j] > end) {
                    sum = nums.length - j;
                    break;
                }
            }

            minOp = Math.min(minOp, i + sum + (numLen - nums.length));
        }

        return minOp;
    }
}
