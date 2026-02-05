import java.util.Stack;

public class ReverseStack {
    static void helper(Stack<Integer> st, int val) {
        if (st.isEmpty()) {
            st.push(val);
        }
        int top = st.pop();
        helper(st, val);
        st.push(top);
    }

    static void reverseStack(Stack<Integer> st) {
        if (st.isEmpty()) {
            return;
        }
        int top = st.pop();
        reverseStack(st);
        helper(st, top);
    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        reverseStack(st);

        while (!st.isEmpty()) {
            System.out.println(st.pop());
        }
    }
}
