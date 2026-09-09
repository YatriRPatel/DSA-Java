class Solution {
    private int index = 0;
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        int k = 0;

        while(index < s.length()){
            char ch = s.charAt(index++);

            if(Character.isDigit(ch)){
                k = k * 10 + (ch - '0');
            }else if(ch == '['){
                String nested = decodeString(s); 
                while (k-- > 0) sb.append(nested);
                k=0;
            }else if (ch == ']'){
                break;
            }else{
                sb.append(ch);
            }
        }
        return sb.toString();
        
    }
}