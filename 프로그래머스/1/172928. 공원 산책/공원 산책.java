class Solution {
    public int[] solution(String[] park, String[] routes) {
        boolean[][] map = new boolean[park.length][park[0].length()];

        int[] now = new int[]{0, 0};
        for (int i = 0; i < park.length; i++) {
            String line = park[i];
            for (int j = 0; j < line.length(); j++) {
                char c = line.charAt(j);
                if (c == 'S') {
                    now = new int[]{i, j};
                    map[i][j] = true;
                } else {
                    map[i][j] = c == 'O';
                }
            }
        }

        for (String command : routes) {
            String[] split = command.split(" ");
            String way = split[0];
            int distance = Integer.parseInt(split[1]);

            int x = now[0];
            int y = now[1];
            if (way.equals("E")) {
                if (y + distance > map[0].length - 1) {
                    continue;
                }
                boolean flag = false;
                for (int i = 1; i <= distance; i++) {
                    if (!map[x][y + i]) {
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    continue;
                }
                now[1] += distance;
            } else if (way.equals("W")) {
                if (y - distance < 0) {
                    continue;
                }
                boolean flag = false;
                for (int i = 1; i <= distance; i++) {
                    if (!map[x][y - i]) {
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    continue;
                }
                now[1] -= distance;
            } else if (way.equals("N")) {
                if (x - distance < 0) {
                    continue;
                }
                boolean flag = false;
                for (int i = 1; i <= distance; i++) {
                    if (!map[x - i][y]) {
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    continue;
                }
                now[0] -= distance;
            } else if (way.equals("S")) {
                if (x + distance > map.length - 1) {
                    continue;
                }
                boolean flag = false;
                for (int i = 1; i <= distance; i++) {
                    if (!map[x + i][y]) {
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    continue;
                }
                now[0] += distance;
            }
        }
        return now;
    }
}