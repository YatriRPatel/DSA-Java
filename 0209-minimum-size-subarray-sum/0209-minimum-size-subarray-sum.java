class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0,left = 0,n = nums.length;
        int minLength = Integer.MAX_VALUE;

        for(int right = 0;right < n;right ++){
            sum += nums[right];

            while(sum >= target){
                minLength= Math.min(minLength ,right - left + 1);
                sum -= nums[left];
                left ++;
            }

        }
        return minLength == Integer.MAX_VALUE ?0:minLength;

        
    }
}