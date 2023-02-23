package QueueInterface2;

import java.util.Stack;

public class StackUpdater {

    public static void updateStack(Stack<Character> stack) {
        if (stack.size() >= 3) {
            
            char[] removed = new char[3];
            for (int i = 0; i < 3; i++) {
                removed[i] = stack.remove(0);
            }
            
            for (int i = 2; i >= 0; i--) {
                stack.push(removed[i]);
            }
        }
    }

    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();
        stack.push('a');
        stack.push('b');
        stack.push('c');
        stack.push('d');
        stack.push('e');
        System.out.println("Original stack: " + stack);
        updateStack(stack);
        System.out.println("Updated stack: " + stack);
    }
}
