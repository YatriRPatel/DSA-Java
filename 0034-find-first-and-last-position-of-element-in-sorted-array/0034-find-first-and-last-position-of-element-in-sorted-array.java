class Solution {
    public int[] searchRange(int[] nums, int target) {
        int [] res = new int[2];
        res[0] = findbound(nums,target,true);
        res[1] = findbound(nums,target,false);
        return res;
        
    }
    private int findbound(int [] nums,int target ,boolean isFirst){
        int start = 0;
        int end = nums.length-1;
        int bound = -1;
        while(start <= end){
            int mid = start + (end-start)/2;
            if(nums[mid]==target){
                bound = mid;
                if(isFirst){
                    end = mid-1;
                }else{
                    start = mid+1;
                }
            }else if(nums[mid]<target){
                start = mid+1;
            }else{
                end = mid - 1;
            }
        }
        return bound;
    }
}