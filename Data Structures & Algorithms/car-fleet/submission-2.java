class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        
        int n = position.length;

        Integer[] idx = new Integer[n];

        for (int i = 0; i < n; i++) {
            idx[i] = i;
        }

        // Sort indices according to positions
        Arrays.sort(idx, (a, b) -> position[a] - position[b]);

        int fleets = 0;

        double lastTime = 0;

        // Traverse from right to left
        for (int i = n - 1; i >= 0; i--) {

            int j = idx[i];

            double time = (double)(target - position[j]) / speed[j];

            if (time > lastTime) {

                fleets++;

                lastTime = time;
            }
        }

        return fleets;
    }
}
