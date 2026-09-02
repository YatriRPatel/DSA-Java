class StockSpanner {
    private Deque<int[]> stk;

    public StockSpanner() {
         stk = new ArrayDeque<>();
        
    }
    
    public int next(int price) {
        int cnt = 1;
        while(!stk.isEmpty() && stk.peek()[0] <= price){
            cnt += stk.pop()[1];
        }
        stk.push(new int[] { price, cnt });
        return cnt;
        
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */