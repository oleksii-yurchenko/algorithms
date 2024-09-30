package queue;

import java.util.Queue;
import java.util.Stack;

public class QueueExercises {

    public static void reverse(Queue<Integer> queue){
        // add
        // remove
        // isEmpty
        var stack = new Stack<Integer>();

        while (!queue.isEmpty()){
            var element = queue.remove();
            stack.push(element);
        }

        while (!stack.isEmpty()){
            var element = stack.pop();
            queue.add(element);
        }
    }
}
