class RandomizedSet {
    ArrayList<Integer> list;
    Map<Integer, Integer> map;

    public RandomizedSet() {
        list = new ArrayList<>();    
        map = new HashMap<>();    
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)) return false; // already present
        list.add(val);
        map.put(val, list.size()-1);  // (val, index)
        return true;
    }
    
    public boolean remove(int val) {
        if(map.containsKey(val) == false) return false; // not present
        int index = map.get(val);
        Collections.swap(list, index, list.size()-1);
        int swappedWith = list.get(index);
        map.put(swappedWith, index);
        list.remove(list.size()-1);
        map.remove(val);
        return true;
    }
    
    public int getRandom() {
        Random random = new Random();
        int n = random.nextInt(list.size());
        return list.get(n);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */