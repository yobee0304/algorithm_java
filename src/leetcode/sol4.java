package leetcode;

public class sol4 {
    public static void main(String[] argss) {
        int[] nums1 = {1,2};    int[] nums2 = {3,4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double median = 0;
        int oneLength = nums1.length;
        int twoLength = nums2.length;
        int totalLength = oneLength + twoLength;
        boolean isOdd = totalLength % 2 > 0 ? true : false;

        int top = -1;
        int oneIndex = 0;
        int twoIndex = 0;
        for(int i=0; i <= totalLength/2; i++) {
            if(oneIndex >= nums1.length)
                top = nums2[twoIndex++];
            else if(twoIndex >= nums2.length) 
                top = nums1[oneIndex++];
            else {
                if(nums1[oneIndex] < nums2[twoIndex]) {
                    top = nums1[oneIndex++];
                } else {
                    top = nums2[twoIndex++];
                }
            }

            if(!isOdd && i >= totalLength/2 - 1)
                median += top;
            else if(isOdd && i == totalLength/2)
                median += top;
        }

        return isOdd ? median : median/2;
    }
}
