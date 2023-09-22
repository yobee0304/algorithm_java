package leetcode;

public class ssol392 {
    public static void main(String[] args) {
        System.out.println("1> " + isSubsequence("abc", "ahbgdc"));
        System.out.println("2> " + isSubsequence("axc", "ahbgdc"));
    }

    public static boolean isSubsequence(String s, String t) {
        if(s.length() == 0)
            return true;

        int index = 0;
        for(int i=0; i<t.length(); i++) {
            if(t.charAt(i) == s.charAt(index))
                index++;

            if(index == s.length())
                return true;
        }

        return false;
    }   
}