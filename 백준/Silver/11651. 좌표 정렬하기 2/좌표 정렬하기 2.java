import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Point> points = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            Point point = new Point(x, y);
            points.add(point);
        }

        Collections.sort(points);

        StringBuilder sb = new StringBuilder();
        for (Point point : points) {
            sb.append(point.x).append(' ').append(point.y).append('\n');
        }
        System.out.println(sb);
    }

    private static class Point implements Comparable<Point> {
        private final int x;
        private final int y;

        private Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            int compare = Integer.compare(this.y, o.y);
            if (compare != 0)
                return compare;
            else
                return Integer.compare(this.x, o.x);
        }
    }
}