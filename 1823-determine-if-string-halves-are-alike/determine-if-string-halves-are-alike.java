class Solution {
    public boolean halvesAreAlike(String s) {
        // s.length is even. so
        int n = s.length();

        String first = s.substring(0, n/2);
        String second = s.substring(n/2, n);

        int vowelInFirst = 0;
        int vowelInSecond = 0;

        for(int i = 0; i < first.length(); i++) {
            char v1 = first.charAt(i);
            if(v1 == 'A' || v1 == 'E' || v1 == 'I' || v1 == 'O' || v1 == 'U' || 
               v1 == 'a' || v1 == 'e' || v1 == 'i' || v1 == 'o' || v1 == 'u') {
                vowelInFirst++;
            }    

            char v2 = second.charAt(i);
            if(v2 == 'A' || v2 == 'E' || v2 == 'I' || v2 == 'O' || v2 == 'U' ||
               v2 == 'a' || v2 == 'e' || v2 == 'i' || v2 == 'o' || v2 == 'u') {
                vowelInSecond++;
            }
        }

        if(vowelInFirst == vowelInSecond)
            return true;
        return false;

    }
}