package gburkl;

/**
 * @author Georg Burkl
 * @version 2019-12-10
 */
public class StackTest {
    public static void main(String[] args) {
        IStack<String> stack = new ArrayStack<>(10);
        stack.push("Hallo");
        stack.push("Welt");
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack);
        stack = new ArrayStack<>(1);
        stack.push("Hallo");
        stack.push("Welt");
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack);
    }
}
