package getstarted;
import java.util.concurrent.TimeUnit;

import com.yammer.metrics.Metrics;
import com.yammer.metrics.core.Meter;
import com.yammer.metrics.reporting.ConsoleReporter;
/**
 * Created by Administrator on 2017/9/4.
 */
public class TestMeters {
    private static Meter meter = Metrics.newMeter(TestMeters.class, "requests","requests", TimeUnit.SECONDS);

    public static void main(String[] args) throws InterruptedException{
        ConsoleReporter.enable(1,TimeUnit.SECONDS);
        while(true){
            meter.mark();
            meter.mark();
            Thread.sleep(1000);
        }
    }
}
