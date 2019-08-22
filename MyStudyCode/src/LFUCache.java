import java.util.*;

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
//        LFUCache lf = lfuCache.g();
        return 0;
    }

    public void put(int key, int value) {

        if(lfuCache.size() < capacity) {
//            lfuCache.push(new LFUCache(key, value));
       } else {

        }
    }
}