package leetcode;

public class sol343 {
    
    public static void main(String[] args) {
        System.out.println("1> " + integerBreak(2));
        System.out.println("2> " + integerBreak(10));
        System.out.println("3> " + integerBreak(58));
    }

    public static int integerBreak(int n) {
        int maxInt = 0;

        if(n == 2) return 1;

        for(int i=2; i<n; i++) {
            int ans = n / i;
            int rem = n % i;
            int rslt = 1;

            for(int j=0; j<rem; j++) rslt *= (ans + 1);
            for(int j=0; j<i-rem; j++) rslt *= ans;

            if(rslt >= maxInt) maxInt = rslt;
            else break;
        }

        return maxInt;
    }
}
