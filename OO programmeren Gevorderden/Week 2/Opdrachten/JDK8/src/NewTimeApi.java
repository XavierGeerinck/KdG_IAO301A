import java.time.Month;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 * Created by xaviergeerinck on 20/11/13.
 */
public class NewTimeApi {
    public static void main(String[] args) {
        ZonedDateTime zdt = ZonedDateTime.now();
        int nanos = zdt.getNano();
        //int millis = zdt.get(MILLIS_OF_SECOND);
        int second = zdt.getSecond();
        int minute = zdt.getMinute();
        int hour = zdt.getHour();
        int day = zdt.getDayOfMonth();
        Month month = zdt.getMonth();
        int monthval = zdt.getMonthValue();
        int year = zdt.getYear();

        System.out.println(zdt);
    }
}
