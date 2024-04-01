package Lab7;

import java.util.Date;
public class Dates {
    public static void main(String[] args) {
        Date now = new Date();
        System.out.println(now);

        System.out.println(now.getTime());

        long milliseconds = now.getTime();
        System.out.println(milliseconds);

        Date dateFromTime = new Date(milliseconds);

        long numberOfMilliseconds = 8765434876L;
        Date date = new Date(numberOfMilliseconds);
        System.out.println(date);

        if (date.before(now)) {
            System.out.println();
        }
    }

}
