class Solution {
    public int largestRectangleArea(int[] heights) {
        
        Stack<Integer> st = new Stack<>();

        int maxArea = 0;

        int n = heights.length;

        for (int i = 0; i <= n; i++) {

            int currHeight = (i == n) ? 0 : heights[i];

            while (!st.isEmpty() && currHeight < heights[st.peek()]) {

                int h = heights[st.pop()];

                int right = i;

                int left;

                if (st.isEmpty()) {
                    left = -1;
                } else {
                    left = st.peek();
                }

                int width = right - left - 1;

                maxArea = Math.max(maxArea, h * width);
            }

            st.push(i);
        }

        return maxArea;
    }
}
