class Solution {
    public String makeGood(String s) {
        StringBuilder sb = new StringBuilder();

        for(char c:s.toCharArray()){
            int length = sb.length();

            if(length>0 && Math.abs(sb.charAt(length-1)-c)==32){
                sb.deleteCharAt(length-1);
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
}