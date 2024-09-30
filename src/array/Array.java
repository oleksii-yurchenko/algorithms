import java.util.Arrays;

public class Array {
    private int[] store;
    private int count = 0;

    public Array(int length) {
        this.store = new int[length];
    }

    public void insert(int item){
        if (count == store.length){
            // int[] newStore = Arrays.copyOf(store, count + 1);
            store = cloneOf(store, count + 1);
        }

        store[count] = item;
        count++;
    }

    public void removeAt(int index){
        checkIndex(index);
        int[] newStore = new int[count - 1];

        for (int i = 0; i < count; i++) {
            if (i < index) newStore[i] = store[i];
            if (i > index)  newStore[i-1] = store[i];
        }

        store = newStore;
        count--;
    }

    public int indexOf(int item){
        for (int i = 0; i < count; i++) {
           if (store[i] == item) return i;
        }
        return -1;
    }

    public void print(){
        for (int i = 0; i < count; i++) {
            System.out.println(store[i]);
        }
    }

    public int max(){
        var max = store[0];
        for (int i = 1; i < count; i++) {
            if (store[i] > max) max = store[i];
        }
        return  max;
    }

    public Array intersect(Array arr){
        var result = new Array(0);

        for (int i = 0; i < count; i++) {
            if (arr.indexOf(store[i]) != -1) result.insert(store[i]);
        }

        return  result;
    }

    public Array reverse(){
        var result = new Array(count);
        for (int i = count - 1; i >= 0 ; i--) {
           result.insert(store[i]);
        }
        return result;
    }

    public void insertAt(int item, int index){
        checkIndex(index);

        var result = cloneOf(store, count + 1);

        result[index] = item;
        for (int i = index + 1; i < count + 1; i++) {
            result[i] = store[i-1];
        }

        store = result;
        count++;

    }

    private int[] cloneOf(int[] arr, int newLength){
        if (newLength <= count)
            throw new IllegalArgumentException();

        int[] newArr = new int[newLength];
        for (int i=0; i < arr.length; i++){
            newArr[i] = arr[i];
        }

        return newArr;
    }

    private void checkIndex(int index){
        if (index < 0 || index >= count)
            throw new IllegalArgumentException();
    }
}
