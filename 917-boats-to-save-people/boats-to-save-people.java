class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);  // tc longn
        int left = 0, right = people.length-1;
        int boats = 0;

        while(left <= right) {

            if(people[left] + people[right] <= limit) {
                left++;
                right--;
            } else { 
                right--;
            }
            boats++;
        }
        return boats;
    }
}
// TC - 0(nlogn)