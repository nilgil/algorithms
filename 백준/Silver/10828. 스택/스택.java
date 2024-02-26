import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    private static int head;
    private static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        nums = new int[n];
        head = -1;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("push")) {
                int operand = Integer.parseInt(st.nextToken());
                push(operand);
            } else {
                int result = execute(command);
                sb.append(result).append('\n');
            }
        }
        System.out.println(sb);
    }

    private static int execute(String command) {
        switch (command) {
            case "pop": {
                return pop();
            }
            case "size": {
                return size();
            }
            case "empty": {
                return empty();
            }
            case "top": {
                return top();
            }
        }
        throw new UnsupportedOperationException();
    }

    private static void push(int operand) {
        nums[++head] = operand;
    }

    private static int pop() {
        if (head == -1) {
            return -1;
        }
        return nums[head--];
    }

    private static int size() {
        return head + 1;
    }

    private static int empty() {
        return size() == 0 ? 1 : 0;
    }

    private static int top() {
        if (head == -1) {
            return -1;
        }
        return nums[head];
    }
}