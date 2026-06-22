class Solution {
    public int findTargetSumWays(int[] nums, int target) {
       
        return solve(0, 0, nums, target);
    }

    int solve(int i, int sum, int[] nums, int target) {

        if (i == nums.length) {

            if (sum == target) {

                return 1;
            }

            return 0;
        }

        int add = solve(i + 1, sum + nums[i], nums, target);

        int subtract = solve(i + 1, sum - nums[i], nums, target);

        return add + subtract; 
    }
}
