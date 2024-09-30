package stack;

import java.util.Arrays;

public class Stack {
    private int[] items;
    private int count = 0;

    private Stack minItems = new Stack();

    public Stack() {
        this.items = new int[10];
    }

    public void push(int value){
        if (items.length == count)
            throw new StackOverflowError();

        if (minItems.isEmpty() || value <= minItems.peek()) {
            minItems.push(value);
        }

        items[count++] = value;

    }

    public int pop(){
        if (isEmpty())
            throw new IllegalStateException();

        if (minItems.peek() == items[count]){
            minItems.pop();
        }

        return items[--count];
    }

    public  int peek(){
        return items[count-1];
    }

    public boolean isEmpty(){
        return count == 0;
    }

    public int min() {
        return minItems.peek();
    }

    @Override
    public String toString() {
        var printedStack = Arrays.copyOfRange(items,0,count);
        return Arrays.toString(printedStack);
    }
}
