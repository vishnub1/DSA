class Solution {
    public int fib(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;

        int num1 = 0, num2 = 1;

        while(n > 1) {
            int sum = num1 + num2;
            num1 = num2;
            num2 = sum;

            n--;
        }

        return num2;
    }
}