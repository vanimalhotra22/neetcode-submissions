class TimeMap {
 HashMap<String, HashMap<Integer, String>> map;
    public TimeMap() {
          map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        
        map.putIfAbsent(key, new HashMap<>());

        map.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
         if (!map.containsKey(key)) {
            return "";
        }

        HashMap<Integer, String> temp = map.get(key);

        int maxTime = -1;

        for (int time : temp.keySet()) {

            if (time <= timestamp && time > maxTime) {
                maxTime = time;
            }
        }

        if (maxTime == -1) {
            return "";
        }

        return temp.get(maxTime);
    }
}
