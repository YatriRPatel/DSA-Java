class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int score = 0;

        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) == '('){
                stack.push(score);
                score = 0;
            }else{
                score = stack.pop() + Math.max(score*2,1);
            }
        }
        return score;
        
    }
}