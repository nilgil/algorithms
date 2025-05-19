class Solution {

    public String simplifyPath(String path) {
        List<String> filtered = Arrays.stream(path.split("/"))
                .filter(s -> !s.isEmpty() && !s.equals("."))
                .collect(Collectors.toList());

        Deque<String> deque = new LinkedList<>();
        for (String dir : filtered) {
            if (dir.equals("..") && !deque.isEmpty()) {
                deque.pollLast();
            } else {
                deque.offerLast(dir);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append('/');
        while (!deque.isEmpty()) {
            String poll = deque.pollFirst();
            sb.append(poll).append('/');
        }

        if (sb.length() > 1) {
            sb.deleteCharAt(sb.length() - 1);
        }

        return sb.toString();
    }
}