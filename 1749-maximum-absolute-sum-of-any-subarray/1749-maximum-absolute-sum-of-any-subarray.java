class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int maxCur = 0,minCur = 0,maxRes=0,minRes =0;

        for(int num:nums){
            maxCur = Math.max(num,maxCur+num);
            maxRes = Math.max(maxCur,maxRes);

            minCur = Math.min(num,minCur+num);
            minRes = Math.min(minRes,minCur);
        }
        return Math.max(maxRes , Math.abs(minRes));
        
    }
}