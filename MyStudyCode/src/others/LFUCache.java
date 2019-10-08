package others;

import java.util.HashMap;
import java.util.Map;

class LFUCache {
    private int key;
    private int value;
    private int capacity;
    private Map<LFUCache, Integer> lfuCache;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        lfuCache = new HashMap<>();
    }

    public LFUCache(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public int get(int key) {
//        others.LFUCache lf = lfuCache.g();
        return 0;
    }

    public void put(int key, int value) {

        if(lfuCache.size() < capacity) {
//            lfuCache.push(new others.LFUCache(key, value));
       } else {

        }
    }
}