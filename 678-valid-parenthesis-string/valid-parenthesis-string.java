class Solution {
    public boolean checkValidString(String s) {
        int low = 0;  // minimum number of open parentheses
        int high = 0; // maximum number of open parentheses
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                low++;   // Increase low because ( adds to open parentheses
                high++;  // Increase high because it also adds to open parentheses
            } else if (c == ')') {
                low--;   // Decrease low because ) can close an open parenthesis
                high--;  // Decrease high for the same reason
                
                // We cannot have less than 0 open parentheses
                if (high < 0) {
                    return false;  // More ) than ( means invalid
                }
            } else { // c == '*'
                low--;   // Treat * as ) or empty
                high++;  // Treat * as ( 
            }
            
            // Ensure that low doesn't drop below 0
            if (low < 0) {
                low = 0;
            }
        }
        
        // At the end, low must be 0 to ensure all open parentheses are closed
        return low == 0;
    }
}
