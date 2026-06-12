/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        
        int n = mountainArr.length();

        int left = 0;
        int right = n - 1;

        // Find peak
        while (left < right) {

            int mid = left + (right - left) / 2;

            if (mountainArr.get(mid) < mountainArr.get(mid + 1))
                left = mid + 1;
            else
                right = mid;
        }

        int peak = left;

        int ans = searchAsc(mountainArr, target, 0, peak);

        if (ans != -1) {
            return ans;
        }

        return searchDesc(mountainArr, target, peak + 1, n - 1);
    }

    private int searchAsc(MountainArray arr, int target,
                          int left, int right) {

        while (left <= right) {

            int mid = left + (right - left) / 2;
            int val = arr.get(mid);

            if (val == target) return mid;

            if (val < target)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return -1;
    }

    private int searchDesc(MountainArray arr, int target,
                           int left, int right) {

        while (left <= right) {

            int mid = left + (right - left) / 2;
            int val = arr.get(mid);

            if (val == target) return mid;

            if (val > target)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return -1;
    }
}