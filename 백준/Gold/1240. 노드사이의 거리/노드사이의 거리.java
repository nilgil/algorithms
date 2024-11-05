import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int n, m;
	static List<Node>[] graph;

	static class Node {
		int next;
		int distance;

		public Node(int next, int distance) {
			this.next = next;
			this.distance = distance;
		}
	}

	public static void main(String[] args) throws Exception {
		input();
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			sb.append(bfs(start, end)).append('\n');
		}
		System.out.println(sb);
	}

	private static int bfs(int start, int end) {
		boolean[] visited = new boolean[n + 1];
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(start, 0));
		visited[start] = true;

		while (!queue.isEmpty()) {
			Node node = queue.poll();
			if (node.next == end) {
				return node.distance;
			}
			for (Node next : graph[node.next]) {
				if (!visited[next.next]) {
					int nextNode = next.next;
					int distance = node.distance + next.distance;
					queue.offer(new Node(nextNode, distance));
					visited[next.next] = true;
				}
			}
		}
		return -1;
	}

	private static void input() throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		graph = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}

		int edgeCount = n - 1;
		while (edgeCount-- > 0) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph[u].add(new Node(v, w));
			graph[v].add(new Node(u, w));
		}
	}
}
