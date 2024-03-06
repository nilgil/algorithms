import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int nowSec = getTotalSec(br.readLine());
        int atSec = getTotalSec(br.readLine());

        if (nowSec == atSec) {
            System.out.println("24:00:00");
            return;
        }

        int gapSec = atSec - nowSec;
        if (gapSec < 0) {
            gapSec += 24 * 60 * 60;
        }

        int hour = gapSec / (60 * 60);
        gapSec -= hour * 60 * 60;
        int min = gapSec / 60;
        gapSec -= min * 60;
        int sec = gapSec;

        System.out.printf("%02d:%02d:%02d", hour, min, sec);
    }

    private static int getTotalSec(String time) {
        StringTokenizer st = new StringTokenizer(time, ":");
        return Integer.parseInt(st.nextToken()) * 60 * 60
                + Integer.parseInt(st.nextToken()) * 60
                + Integer.parseInt(st.nextToken());
    }
}