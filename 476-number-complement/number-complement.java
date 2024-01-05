class Solution {
    public int findComplement(int num) {
        int c = 0, t = num;
		//First, you need to find how many bits are present in the given number.
        while(t>0) {
            t = t>>1;
            c++;
        }
		//Now after that, create a mask of 1's about the size of num.
		//eg: if num = 5(101) then mask = 7(111) 
        int mask = (1<<(c))-1;
		//now this mask can be used to flip all the bits in num using XOR.
        return num^mask;
    }
}