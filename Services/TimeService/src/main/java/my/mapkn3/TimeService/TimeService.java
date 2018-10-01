package my.mapkn3.TimeService;

import javax.jws.WebService;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebService(name = "Time", serviceName = "TimeService")
public class TimeService {
    public String getTime() {
        Date timeNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("HH:mm:ss E dd.MM.yyyy");
        return formatForDateNow.format(timeNow);
    }
}