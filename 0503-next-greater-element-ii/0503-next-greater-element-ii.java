class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int [] result = new int [n];

        Arrays.fill(result,-1);

        Stack<Integer> stack = new Stack<>();

        for (int i = 0;i<2*n;i++){
            int currentNum = nums[i % n];

            while (!stack.isEmpty() && nums[stack.peek()] < currentNum) {
                int indexToUpdate = stack.pop();
                result[indexToUpdate] = currentNum;
            }

            if(i<n){
                stack.push(i);
            }
        }
        return result;
        
    }
}