class Solution {
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();

        int start = 0;
        int end = arr.length-1;

        while(start < end) {
            if(isVowel(arr[start]) && isVowel(arr[end])) {
                // swap
                char temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            } 
            else if(isVowel(arr[start])) {
                end--;
            }
            else if(isVowel(arr[end])) {
                start++;
            } 
            else {
                start++;
                end--;
            }
        }
        // return new String(arr);
        return String.valueOf(arr);
    }

    // is Vowel
    public boolean isVowel(char ch) {
        if(ch == 'a' || ch == 'A') {
            return true;
        }
        else if (ch == 'e' || ch == 'E') {
            return true;
        }
        else if (ch == 'i' || ch == 'I') {
            return true;
        }
        else if (ch == 'o' || ch == 'O') {
            return true;
        }
        else if (ch == 'u' || ch == 'U') {
            return true;
        }
        else {
            return false;
        }
    }
}