class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> st = new Stack<>();

        for(char ch : s.toCharArray()) {
            if(ch == ')') {
                Queue<Character> que = new LinkedList<>();
                while(st.peek() != '(') {
                    que.add(st.pop());
                }
                st.pop(); // Pop the '(' from the stack

                // Push characters back to the stack to reverse the string between parentheses
                while(!que.isEmpty()) {
                    st.push(que.remove());
                }
            } else {
                st.push(ch);  // For characters '(', and 'a-z', push them onto the stack
            }
        }

        // The stack now contains the final string in reverse order
        String ans = "";
        while(!st.isEmpty()) {
            ans = st.pop() + ans;  // Pop characters from the stack and build the result string
        }

        return ans;
    }
}
