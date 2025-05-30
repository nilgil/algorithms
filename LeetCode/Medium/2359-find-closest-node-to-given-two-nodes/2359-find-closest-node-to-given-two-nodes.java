class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int[] dist1 = new int[n];
        int[] dist2 = new int[n];
        Arrays.fill(dist1, -1);
        Arrays.fill(dist2, -1);
        markDistance(edges, dist1, node1);
        markDistance(edges, dist2, node2);

        int min = Integer.MAX_VALUE;
        int result = -1;
        for (int i = 0; i < n; i++) {
            if (dist1[i] >= 0 && dist2[i] >= 0) {
                int maxDist = Math.max(dist1[i], dist2[i]);
                if (maxDist < min) {
                    min = maxDist;
                    result = i;
                }
            }
        }
        return result;
    }

    private void markDistance(int[] edges, int[] dist, int start) {
        int depth = 0;
        while (start != -1 && dist[start] == -1) {
            dist[start] = depth++;
            start = edges[start];
        }
    }
}