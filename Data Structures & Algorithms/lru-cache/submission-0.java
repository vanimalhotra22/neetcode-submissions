class LRUCache {
int capacity;

    LinkedHashMap<Integer, Integer> map;
    public LRUCache(int capacity) {
         this.capacity = capacity;

        map = new LinkedHashMap<>();
    
    }
    
    public int get(int key) {
          if (!map.containsKey(key)) {

            return -1;
        }

        int value = map.get(key);

        // Move key to end (most recently used)
        map.remove(key);

        map.put(key, value);

        return value;
    }
    
    public void put(int key, int value) {
         if (map.containsKey(key)) {

            map.remove(key);
        }

        // Cache full
        else if (map.size() == capacity) {

            int firstKey = map.keySet().iterator().next();

            map.remove(firstKey);
        }

        // Insert at end (most recently used)
        map.put(key, value);
    }
}
