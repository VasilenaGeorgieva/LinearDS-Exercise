package implementations;
import java.util.Stack;
import interfaces.Solvable;

public class BalancedParentheses implements Solvable {
    private String parentheses;
    private final char[][] Parenthesis = {{'(',')'},{'{','}'},{'[',']'}};

    public BalancedParentheses(String parentheses) {
        this.parentheses = parentheses;
    }

    private boolean isOpenParenthesis(char state) {
        for (char[] parenthesis : Parenthesis) {
            if (state == parenthesis[0]) {
                return true;
            }
        }

        return false;
    }

    @Override
    public Boolean solve() {
        Stack<Character> stack = new Stack<>();
        char[] parenthesisArr = this.parentheses.toCharArray();

        for (char c : parenthesisArr) {
            if (isOpenParenthesis(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty() || (!(IsMatch(stack.pop(), c)))) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean IsMatch(char openChar, char closeChar) {
        for (char[] parenthesis : Parenthesis) {
            if (openChar == parenthesis[0]) {
                return closeChar == parenthesis[1];
            }
        }
        return false;
    }

}
