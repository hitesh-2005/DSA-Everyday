class MyHashMap {

    public class MapEntry {
        int value;
        int key;

        MapEntry next;

        MapEntry(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }

        MapEntry(int key, int value, MapEntry next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    MapEntry[] map;
    int size;

    public MyHashMap() {
        size = 10000;
        map = new MapEntry[size];
    }

    public void put(int key, int value) {
        int bucket = findBucket(key);

        if (map[bucket] != null) {
            MapEntry entry = map[bucket];

            while (entry != null && entry.key != key) {
                entry = entry.next;
            }

            if (entry != null) {
                entry.value = value;
            } else {
                map[bucket] = new MapEntry(key, value, map[bucket]);
            }

        } else {
            map[bucket] = new MapEntry(key, value);
        }
    }

    public int get(int key) {
        int bucket = findBucket(key);
        if (map[bucket] != null) {
            MapEntry entry = map[bucket];

            while (entry != null) {
                if (entry.key == key) {
                    return entry.value;
                }
                entry = entry.next;
            }
        }

        return -1;
    }

    public void remove(int key) {
        int bucket = findBucket(key);
        if (map[bucket] != null) {
            MapEntry entry = map[bucket];

            if (entry.key == key) {
                map[bucket] = entry.next;
                return;
            }

            MapEntry prev = entry;
            entry = entry.next;

            while (entry != null) {
                if (entry.key == key) {
                    prev.next = entry.next;
                    entry.next = null;
                    return;
                }
                prev = entry;
                entry = entry.next;
            }
        }
    }

    private int findBucket(int key) {
        return key % size;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */