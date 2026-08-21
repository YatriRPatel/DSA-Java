class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = 0;
        for (int pile:piles){
            high = Math.max(high,pile);
        }
        int answer = high;
        while(low<=high){
            int mid = low+(high - low)/2;
            if(canEat(piles,h,mid)){
                answer= mid;
                high = mid - 1;

            }else{
                low = mid + 1;
            }
        }
        return answer;

        
    }
    private boolean canEat(int [] piles,int h , int k){
        long hours = 0;
        for(int pile:piles){
            hours+=(pile+k-1)/k;
        }
        return hours<=h;
    }
}