class MyHashMap {
    private int[] data = new int[1000001];  // array for keys from 0 to 1e6

    public MyHashMap() {
        Arrays.fill(data, -1);   // initially no key is present
    }

    public void put(int key, int value) {
        data[key] = value;       // directly store the value at index = key
    }

    public int get(int key) {
        return data[key];        // returns -1 if not present, else the stored value
    }

    public void remove(int key) {
        data[key] = -1;          // mark as removed
    }
}


/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */