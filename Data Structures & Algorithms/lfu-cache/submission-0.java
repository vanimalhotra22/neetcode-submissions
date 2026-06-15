class LFUCache {

    int capacity;
    int minFreq;

    HashMap<Integer, Integer> keyToValue;
    HashMap<Integer, Integer> keyToFreq;

    HashMap<Integer, LinkedHashSet<Integer>> freqToKeys;
    public LFUCache(int capacity) {
     
        this.capacity = capacity;

        minFreq = 0;

        keyToValue = new HashMap<>();

        keyToFreq = new HashMap<>();

        freqToKeys = new HashMap<>();   
    }
    
    public int get(int key) {
    
        if (!keyToValue.containsKey(key)) {

            return -1;
        }

        updateFreq(key);

        return keyToValue.get(key);    
    }
    
    public void put(int key, int value) {
          if (capacity == 0) {

            return;
        }

        // Key already exists
        if (keyToValue.containsKey(key)) {

            keyToValue.put(key, value);

            updateFreq(key);

            return;
        }

        // Cache full
        if (keyToValue.size() == capacity) {

            LinkedHashSet<Integer> set = freqToKeys.get(minFreq);

            int removeKey = set.iterator().next();

            set.remove(removeKey);

            if (set.size() == 0) {

                freqToKeys.remove(minFreq);
            }

            keyToValue.remove(removeKey);

            keyToFreq.remove(removeKey);
        }

        // Insert new key

        keyToValue.put(key, value);

        keyToFreq.put(key, 1);

        minFreq = 1;

        freqToKeys.putIfAbsent(1, new LinkedHashSet<>());

        freqToKeys.get(1).add(key);
    }

    private void updateFreq(int key) {

        int freq = keyToFreq.get(key);

        keyToFreq.put(key, freq + 1);

        LinkedHashSet<Integer> oldSet = freqToKeys.get(freq);

        oldSet.remove(key);

        if (oldSet.size() == 0) {

            freqToKeys.remove(freq);

            if (minFreq == freq) {

                minFreq++;
            }
        }

        freqToKeys.putIfAbsent(freq + 1, new LinkedHashSet<>());

        freqToKeys.get(freq + 1).add(key);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */