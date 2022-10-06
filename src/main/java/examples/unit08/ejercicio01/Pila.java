package examples.unit08.ejercicio01;

import java.util.Stack;

public class Pila {
    private Stack<Integer> stack = new Stack<>();

    /**
     * Push a number  over the stack
     * @param num a number between 3 and 19
     */
    public void push(Integer num) {
        if (num > 2 && num < 20)
            stack.push(num);

    }

    /**
     * Return an element of the top stack and delete it
     * @return a number on the top of the stack
     */
    public Integer pop() {
        if (isEmpty())
            return null;
        return stack.pop();
    }

    /**
     * @return true if the stack is empty otherwise false
     */
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    /**
     * Return an element of the top stack without delete it
     * @return a number on the top of the stack
     */
    public Integer top() {
        if (isEmpty())
            return null;
        return stack.peek();
    }

    public int size() {
        return stack.size();
    }
}
