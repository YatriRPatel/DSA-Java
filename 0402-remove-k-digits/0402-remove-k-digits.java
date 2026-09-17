class Solution {
    public String removeKdigits(String num, int k) {
        int len = num.length();
        if(k == len){
            return "0";
        }

        char[] stack = new char[len];
        int top = 0;

        for(int i = 0; i<len; i++){
            char currDigit = num.charAt(i);

            while(top>0 && k>0 && stack[top-1]>currDigit){
                top--;
                k--;
            }

            stack[top++] = currDigit;
        }
        top-=k;

        StringBuilder result = new StringBuilder();
        boolean leadingZero = true;

        for(int i = 0; i<top ; i++){
            if (leadingZero && stack[i] == '0') {
                continue;
            }
            leadingZero = false;
            result.append(stack[i]);
        }
        return result.length() == 0 ? "0" : result.toString();
    }
}