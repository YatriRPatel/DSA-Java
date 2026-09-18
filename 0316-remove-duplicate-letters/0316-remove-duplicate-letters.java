class Solution {
    public String removeDuplicateLetters(String s) {
        int [] lastIdx = new int [26];
        for (int i = 0; i < s.length(); i++){
            lastIdx[s.charAt(i)-'a'] = i;
        }
        boolean[] inStack = new boolean[26];
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            int idx = c - 'a';
            if(inStack[idx]){
                continue;
            }

            while(!stack.isEmpty() && stack.peek() > c && lastIdx[stack.peek() - 'a'] > i){
                char removed = stack.pop();
                inStack[removed - 'a'] = false;
            }

            stack.push(c);
            inStack[idx] = true;
        }
        StringBuilder sb = new StringBuilder();
        for(char c : stack){
            sb.append(c);
        }
        return sb.toString();
        
    }
}