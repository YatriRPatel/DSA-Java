class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = 0;

        for(int w:weights) {
            left = Math.max(left,w);
            right += w;
        }

        int ans = right;

        while(left<=right){
            int mid = left+(right-left)/2;
            if(canShip(weights,days,mid)){
                ans = mid;
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return ans;
        
    }

    private boolean canShip(int []weights,int days,int capacity){
        int currDays = 1;
        int currLoad = 0;

        for(int w : weights){
            if(currLoad+w>capacity){
                currDays ++;
                currLoad = w;
            }else{
                currLoad+=w;
            }
        }
        return currDays<=days;
    }
}