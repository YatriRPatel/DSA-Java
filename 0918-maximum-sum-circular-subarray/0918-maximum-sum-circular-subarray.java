class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum =0,currMin =0 ,currMax = 0;
        int maxSum = nums[0];
        int minSum = nums[0];

        for (int num:nums){
            currMax = Math.max(currMax+num,num);
            maxSum = Math.max(maxSum,currMax);

            currMin = Math.min(currMin + num,num);
            minSum = Math.min(minSum ,currMin);

            totalSum+=num;

        }   
        if(maxSum<0){
            return maxSum;
        }
        return Math.max(maxSum,totalSum-minSum);     
    }
}