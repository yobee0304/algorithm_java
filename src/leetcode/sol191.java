package leetcode;

public class sol191 {

    public static class Solution {
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {
            // [sol 1]
            int cnt = 0;
            while(n != 0) {
                cnt += n & 1;
                n = n >>> 1;
            }

            return cnt;

            // [sol 2]
            // return Integer.bitCount(n);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("Example 1 > " + solution.hammingWeight(00000000000000000000000000001011));
        System.out.println("Example 2 > " + solution.hammingWeight(00000000000000000000000010000000));
        System.out.println("Example 3 > " + solution.hammingWeight(-3));
    }
}