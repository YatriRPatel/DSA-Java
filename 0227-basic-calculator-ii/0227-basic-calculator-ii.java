class Solution {
    public int calculate(String s) {
        Deque<Integer> stack = new ArrayDeque<>();

        int num = 0 , res = 0;
        char op = '+';

        for(int i = 0;i < s.length();i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)) num = num * 10 + (c - '0');
              if ((!Character.isDigit(c) && c != ' ') || i == s.length() - 1){
                if(op=='+') stack.push(num);
                else if(op =='-') stack.push(-num);
                else stack.push(op == '*' ? stack.pop() * num : stack.pop() / num);

                op = c;
                num = 0;
               }
        }
        while(!stack.isEmpty()) res += stack.pop();
        return res;
        
    }
}