class Solution {
    public int minLength(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0;i<s.length();i++){
            char currChar = s.charAt(i);

            if(currChar == 'B' && !stack.isEmpty() && stack.peek() == 'A'){
                stack.pop();
            }else if(currChar == 'D' && !stack.isEmpty() && stack.peek() == 'C'){
                stack.pop();
            }else{
                stack.push(currChar);
            }
        }
        return stack.size();
        
    }
}