package stack;

import java.util.*;
import java.util.Stack;

public class StackExercises {

    static class Symbols {
        private static final Map<Character,Character> brackets = Map.of(
                '(',')',
                '<','>',
                '{','}',
                '[',']'
        );

        private static List<Character> getOpenedBrackets(){
             return new ArrayList<>(brackets.keySet());
        }

        private static List<Character> getClosedBrackets(){
            return new ArrayList<>(brackets.values());
        }

        private  static boolean bracketsMatched(char opened, char closed){
            return brackets.get(opened) == closed;
        }
    }


    public static boolean isBalancedString(String input){

        var stack = new Stack<Character>();

        for ( char ch : input.toCharArray()){
            if (Symbols.getOpenedBrackets().contains(ch)){
                stack.push(ch);
            }

            if (Symbols.getClosedBrackets().contains(ch)){
                if (stack.isEmpty()) return false;
                var previous = stack.pop();
                if (!Symbols.bracketsMatched(previous,ch)) return false;
            }
        }

        return stack.isEmpty();
    }



    public static String reverseString(String input){
        if (input == null)
            throw new IllegalArgumentException();

        var stack = new Stack<Character>();
        var output = new StringBuilder();

        for (char ch : input.toCharArray()) {
            stack.push(ch);
        }

        while (stack.isEmpty() != true) {
            output.append(stack.pop());
        }

        return output.toString();
    }
}
