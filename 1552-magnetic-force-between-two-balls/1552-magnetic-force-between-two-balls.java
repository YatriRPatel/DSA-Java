class Solution {
    public int maxDistance(int[] position, int m) {
        java.util.Arrays.sort(position);
        int l = 1,r = position[position.length-1]-position[0];
        int ans = 0;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(canPlace(position,m,mid)){
                ans = mid;
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        return ans;
    }
    private boolean canPlace(int[]pos,int m , int minDist){
        int count = 1;
        int lastPos = pos[0];

        for(int i = 1;i<pos.length;i++){
            if(pos[i] - lastPos>=minDist){
                count++;
                lastPos = pos[i];
                if(count>=m)return true;
            }
        }
        return false;
    }
}