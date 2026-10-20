class LFUCache {
    private final int capacity;
    private int minFreq;
    private final Map<Integer, Integer> keyToVal;
    private final Map<Integer, Integer> keyToFreq;
    private final Map<Integer, LinkedHashSet<Integer>> freqToKeys;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        this.keyToVal = new HashMap<>();
        this.keyToFreq = new HashMap<>();
        this.freqToKeys = new HashMap<>();
    }
    
    public int get(int key) {
        if (!keyToVal.containsKey(key)) {
            return -1;
        }
        updateFrequency(key);
        return keyToVal.get(key);
    }
    
    public void put(int key, int value) {
        if (capacity <= 0) {
            return;
        }
        
        if (keyToVal.containsKey(key)) {
            keyToVal.put(key, value);
            updateFrequency(key);
            return;
        }
        
        if (keyToVal.size() >= capacity) {
            evictLFUKey();
        }
        
        keyToVal.put(key, value);
        keyToFreq.put(key, 1);
        minFreq = 1;
        freqToKeys.computeIfAbsent(1, k -> new LinkedHashSet<>()).add(key);
    }
    private void updateFrequency(int key) {
        int currentFreq = keyToFreq.get(key);
        int newFreq = currentFreq + 1;
        
        keyToFreq.put(key, newFreq);
        
        LinkedHashSet<Integer> keysWithCurrentFreq = freqToKeys.get(currentFreq);
        keysWithCurrentFreq.remove(key);
        
        if (currentFreq == minFreq && keysWithCurrentFreq.isEmpty()) {
            minFreq++;
        }
        
        freqToKeys.computeIfAbsent(newFreq, k -> new LinkedHashSet<>()).add(key);
    }
    
    private void evictLFUKey() {
        LinkedHashSet<Integer> keysWithMinFreq = freqToKeys.get(minFreq);
        int keyToEvict = keysWithMinFreq.iterator().next();
        
        keysWithMinFreq.remove(keyToEvict);
        keyToVal.remove(keyToEvict);
        keyToFreq.remove(keyToEvict);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */