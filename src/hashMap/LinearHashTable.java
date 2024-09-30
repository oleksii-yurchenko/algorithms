package hashMap;

import java.util.Arrays;
import java.util.LinkedList;

public class CustomHashTable {
    private class Entry {
        private int key;
        private String value;

        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "{key="+key+"; value="+value+"}";
        }
    }

    private LinkedList<Entry>[] items;

    public CustomHashTable(int length) {
        items = new LinkedList[length];
    }

    public void put(int key, String value){
        var entry = getEntry(key);
        if (entry != null){
            entry.value = value;
            return;
        }

        var bucket = getBucketOrCreate(key);
        bucket.addLast(new Entry(key, value));
    }

    public String get(int key){
        var entry = getEntry(key);
        return (entry != null) ? entry.value : null;
    }

    public void remove(int key){
        if (getEntry(key) == null)
            throw new IllegalArgumentException();

        getBucket(key).remove(getEntry(key));
    }

    @Override
    public String toString() {
        var printArray = new String[items.length];

        for (int i = 0; i < items.length; i++) {
            if (items[i] == null)
                printArray[i] = "null";
            else printArray[i] = items[i].toString();
        }

        return Arrays.toString(printArray);
    }

    private int hash(int key){
        return key % items.length;
    }

    private LinkedList<Entry> getBucket(int key){
        return items[hash(key)];
    }

    private LinkedList<Entry> getBucketOrCreate(int key){
        if (items[hash(key)] == null) items[hash(key)] = new LinkedList<>();
        return items[hash(key)];
    }

    private Entry getEntry(int key){
        if (getBucket(key) != null){
            for (var entry : getBucket(key))
                if (entry.key == key)
                    return entry;
        }

        return null;
    }
}
