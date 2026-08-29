class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if((long)m*k>bloomDay.length) return -1;
        int low = 0,high = 0;
        for(int day : bloomDay) high = Math.max(high,day);

        while(low<high){
            int mid=low+(high - low)/2;
            if(canMake(bloomDay,m,k,mid)){
                high = mid;
            }else{
                low = mid+1;
            }
        }
        return low;
        
    }
    private boolean canMake(int[]bloomDay,int m , int k , int day){
        int bouquets=0,flowers = 0;
        for(int b:bloomDay){
            if(b<=day){
                flowers++;
                if(flowers==k){
                    bouquets++;
                    flowers = 0;
                }
            }else{
                flowers = 0;
            }
        }
        return bouquets>=m;
    }
}