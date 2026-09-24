class Solution {
    public int rob(int[] nums) {
        int [] dp = new int [nums.length]; 
        Arrays.fill(dp,-1);
        return robFrom(nums , nums.length-1 ,dp);
    }
    private int robFrom(int[] nums, int i, int[] dp){
            if(i<0) return 0;

            if(dp[i] != -1){
                return dp[i];
            }

            int robCurr = nums[i] + robFrom(nums , i-2 , dp);
            int skipCurr = robFrom(nums , i-1 , dp);

            dp[i] = Math.max(robCurr , skipCurr);
            return dp[i];
        }
}