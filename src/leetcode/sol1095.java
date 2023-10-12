package leetcode;

public class sol1095 {

    static class MountainArray {
        private int[] arr;

        public MountainArray(int[] arr) {
            this.arr = new int[arr.length];
            for(int i=0; i<arr.length; i++) this.arr[i] = arr[i];
        }

        public int get(int index) {
            return this.arr[index];
        }

        public int length() {
            return this.arr.length;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,3,1};
        MountainArray mountainArr = new MountainArray(arr);
        
        System.out.println("ans : " + findInMountainArray(3, mountainArr));
    }

    public static int findInMountainArray(int target, MountainArray mountainArr) {
        int len = mountainArr.length();
        int peakIndex = findPeakIndex(mountainArr, len);

        int left = searchLeft(mountainArr, 0, peakIndex, target);
        if(left >= 0) return left;

        int right = searchRight(mountainArr, peakIndex+1, len-1, target);
        if(right >= 0) return right;

        return -1;
    }

    private static int findPeakIndex(MountainArray mountainArr, int len) {
        int left = 0;
        int right = len-1;
        int mid = -1;

        while(left < right) {
            mid = (left + right) / 2;

            if(mountainArr.get(mid) < mountainArr.get(mid + 1))
                left = mid + 1;
            else
                right = mid;
        }

        return left;
    }

    private static int searchLeft(MountainArray mountainArr, int left, int right, int target) {
        int mid = -1;

        while(left < right) {
            mid = (left + right) / 2;

            if(mountainArr.get(mid) < target)
                left = mid + 1;
            else
                right = mid;
        }

        return mountainArr.get(left) == target ? left : -1;
    }

    private static int searchRight(MountainArray mountainArr, int left, int right, int target) {
        int mid = -1;

        while(left < right) {
            mid = (left + right) / 2;

            if(mountainArr.get(mid) > target)
                left = mid + 1;
            else
                right = mid;
        }

        return mountainArr.get(left) == target ? left : -1;
    }
}
