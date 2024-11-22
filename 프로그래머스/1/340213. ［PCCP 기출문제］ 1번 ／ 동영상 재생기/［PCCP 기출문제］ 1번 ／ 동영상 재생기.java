class Solution {
    
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        System.out.println(video_len);
        System.out.println(pos);
        System.out.println(op_start);
        System.out.println(op_end);
        for(String command: commands) {
            System.out.println(command);
        }
        Video video = new Video(new Time(video_len), new Time(pos), new Time(op_start), new Time(op_end));
        video.skipOp();
        for (String command : commands) {
            if (command.equals("next")) {
                video.next();
            } else if (command.equals("prev")) {
                video.prev();
            }
            video.skipOp();
        }
        return video.position.toString();
    }

    static class Video {
        Time start = new Time(0, 0);
        Time length;
        Time position;
        Time opStart;
        Time opEnd;

        public Video(Time length, Time position, Time opStart, Time opEnd) {
            this.length = length;
            this.position = position;
            this.opStart = opStart;
            this.opEnd = opEnd;
        }

        public void skipOp() {
            if (position.compareTo(opStart) >= 0 && position.compareTo(opEnd) <= 0) {
                position = new Time(opEnd.minute, opEnd.second);
            }
        }

        public void next() {
            position.next();
            if (position.compareTo(length) > 0) {
                position = new Time(length.minute, length.second);
            }
        }

        public void prev() {
            position.prev();
            if (position.compareTo(start) < 0) {
                position = new Time(0, 0);
            }
        }
    }

    static class Time implements Comparable<Time> {
        int minute;
        int second;

        public Time(int minute, int second) {
            this.minute = minute;
            this.second = second;
        }

        public Time(String time) {
            this(Integer.parseInt(time.substring(0, 2)),
                    Integer.parseInt(time.substring(3)));
        }

        public void next() {
            second += 10;
            if (second >= 60) {
                second -= 60;
                minute += 1;
            }
        }

        public void prev() {
            second -= 10;
            if (second < 0) {
                second += 60;
                minute -= 1;
            }
        }

        @Override
        public int compareTo(Time o) {
            if (this.minute == o.minute) {
                return Integer.compare(this.second, o.second);
            }
            return Integer.compare(this.minute, o.minute);
        }

        @Override
        public String toString() {
            return String.format("%02d", minute) + ":" + String.format("%02d", second);
        }
    }
}