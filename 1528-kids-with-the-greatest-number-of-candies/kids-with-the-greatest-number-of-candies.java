class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int n = candies.length;
        List<Boolean> result = new ArrayList<>();

        // finding the maximum in all array 
        int maxInArray = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            maxInArray = Math.max(maxInArray, candies[i]);
        }
        System.out.println(maxInArray);

        // now checking after giving the candies the ele should max of greater than max or not
        for(int i = 0; i < n; i++) {
            if(candies[i] + extraCandies >= maxInArray) {
                result.add(true);
            } else {
                result.add(false);
            }
        }

        return result;
    }
}