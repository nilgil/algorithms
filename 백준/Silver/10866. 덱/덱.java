import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        Deque deque = new Deque(n);
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (st.hasMoreTokens()) {
                int value = Integer.parseInt(st.nextToken());
                deque.execute(command, value);
            } else {
                int execute = deque.execute(command);
                sb.append(execute).append('\n');
            }
        }
        sb.deleteCharAt(sb.lastIndexOf("\n"));
        System.out.println(sb);
    }

    public static class Deque {

        private int front = 0;
        private int back = 0;
        private int size = 0;
        private final int[] nums;

        public Deque(int size) {
            this.nums = new int[size + 1];
        }

        public void execute(String command, int value) {
            switch (command) {
                case "push_front": {
                    pushFront(value);
                    return;
                }
                case "push_back": {
                    pushBack(value);
                    return;
                }
            }
            throw new UnsupportedOperationException();
        }

        public int execute(String command) {
            switch (command) {
                case "size": {
                    return size();
                }
                case "empty": {
                    return empty();
                }
            }
            if (empty() == 1) {
                return -1;
            }
            switch (command) {
                case "pop_front": {
                    return popFront();
                }
                case "pop_back": {
                    return popBack();
                }
                case "front": {
                    return front();
                }
                case "back": {
                    return back();
                }
            }
            throw new UnsupportedOperationException();
        }

        private void pushFront(int value) {
            size++;
            nums[front] = value;
            front = dec(front, nums.length);
        }

        private void pushBack(int value) {
            size++;
            back = inc(back, nums.length);
            nums[back] = value;
        }

        private int popFront() {
            size--;
            front = inc(front, nums.length);
            return nums[front];
        }

        private int popBack() {
            size--;
            int value = nums[back];
            back = dec(back, nums.length);
            return value;
        }

        private int size() {
            return size;
        }

        private int empty() {
            return size == 0 ? 1 : 0;
        }

        private int front() {
            return nums[inc(front, nums.length)];
        }

        private int back() {
            return nums[back];
        }

        private int dec(int pointer, int size) {
            if (--pointer < 0) {
                return size - 1;
            }
            return pointer;
        }

        private int inc(int pointer, int size) {
            if (++pointer >= size) {
                return 0;
            }
            return pointer;
        }
    }
}