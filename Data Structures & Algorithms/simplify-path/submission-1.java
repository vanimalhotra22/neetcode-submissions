class Solution {
    public String simplifyPath(String path) {
         Stack<String> st = new Stack<>();

        String[] parts = path.split("/");

        for (String s : parts) {

            if (s.equals("") || s.equals(".")) {
                continue;
            }

            else if (s.equals("..")) {

                if (!st.isEmpty()) {
                    st.pop();
                }
            }

            else {

                st.push(s);
            }
        }

        if (st.isEmpty()) {
            return "/";
        }

        StringBuilder ans = new StringBuilder();

        for (String dir : st) {

            ans.append("/");

            ans.append(dir);
        }

        return ans.toString();
    }
}  
    