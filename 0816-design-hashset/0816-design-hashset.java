class MyHashSet {
    private boolean[] mp;

    public MyHashSet() {
        mp = new boolean[1000001];
        Arrays.fill(mp, false);
    }

    public void add(int key) {
        mp[key] = true;
    }

    public void remove(int key) {
        mp[key] = false;
    }

    public boolean contains(int key) {
        return mp[key];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */