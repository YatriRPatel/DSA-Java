import java.util.Arrays;
class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        if(hour <= dist.length-1) return -1;

        int low = 0,high = 10_000_000,ans = 1;
        while(low<= high){
            int mid = low+(high-low)/2;
            double time=0;
            for (int i = 0;i<dist.length;i++){
                double t = (double)dist[i]/mid;
                time+=(i<dist.length-1)?Math.ceil(t):t;

            }
            if(time<=hour){
                ans=mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
            
        }
        return ans;
    }
}