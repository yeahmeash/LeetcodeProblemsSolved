class MyHashSet {
    private boolean[] mp;

    public MyHashSet() {
        mp = new boolean[1000001];  // array from 0 to 1,000,000
        Arrays.fill(mp, false);     // initially no key is present
    }

    public void add(int key) {
        mp[key] = true;   // mark this number as present
    }

    public void remove(int key) {
        mp[key] = false;  // mark this number as absent
    }

    public boolean contains(int key) {
        return mp[key];   // return true if present, else false
    }
}


/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */