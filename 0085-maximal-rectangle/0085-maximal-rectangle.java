class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }

        int cols = matrix[0].length;
        int[] heights = new int[cols];
        int maxArea = 0;

        for(char[] row : matrix){
            for(int i = 0;i < cols; i++){
                heights[i] = (row[i] == '0') ? 0: heights[i]+1;
            }
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }
        return maxArea;
        
    }
    private int largestRectangleArea(int[] heights){
        int maxArea = 0;
        Deque <Integer> stack = new ArrayDeque<>();

        for(int i = 0; i <= heights.length;i++){
            int currentHeight = (i == heights.length) ? 0 : heights[i];

            while(!stack.isEmpty() && currentHeight < heights[stack.peek()]){
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea,height*width);
            }
            stack.push(i);
        }
        return maxArea;
    }
}