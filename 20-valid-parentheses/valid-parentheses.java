class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> st = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(' || ch == '[' || ch == '{') {
                st.push(ch);
            } else {
                // if the ch is a closing bracket 
                // if the stack is empty there is no matching
                if(st.isEmpty()) {
                    return false;
                }

                // Otherwise, get the top of the stack and check if its the matching openineg bracket
                char top = st.peek();

                if((ch == ')' && top == '(') || (ch == ']' && top == '[') || (ch == '}' && top == '{')) {
                    st.pop();
                } else {
                    return false;
                }
            }
        }

        // it the stack is empty all openeing brackets have closed, so return true, 
        // otherwise there is unwanted brackets are there so return false;

        return st.isEmpty();
    }
}