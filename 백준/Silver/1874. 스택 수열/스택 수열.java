import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        Stack<Integer> stack = new Stack<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int target = Integer.parseInt(br.readLine());
            while (true) {
                if (stack.isEmpty() || stack.peek() < target) {
                    stack.push(queue.poll());
                    sb.append('+').append('\n');
                } else if (stack.peek() == target) {
                    stack.pop();
                    sb.append('-').append('\n');
                    break;
                } else {
                    System.out.println("NO");
                    return;
                }
            }
        }
        System.out.println(sb);
    }
}