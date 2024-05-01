class Solution {
    public String reversePrefix(String word, char c) {
        int start = 0;
        int end = 0;

        // find the index of character c 
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(ch == c) {
                end = i;
                break;
            }
        }
        // if the character is not found, return the original word
        if(end == 0) return word;

        // convert the string to a character array for in-place manipulation
        char[] charArray = word.toCharArray();

        // Reverse the prefix 
        while(start < end) {
            char temp = charArray[start];
            charArray[start] = charArray[end];
            charArray[end] = temp;
            start++;
            end--;
        }

        // Conver the character array back to a string 
        return new String(charArray);
    }
}