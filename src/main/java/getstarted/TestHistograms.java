package getstarted;
import java.util.concurrent.TimeUnit;

import com.yammer.metrics.Metrics;
import com.yammer.metrics.core.Histogram;
import com.yammer.metrics.reporting.ConsoleReporter;

/**
 * Created by Administrator on 2017/9/4.
 */
public class TestHistograms {
    private static Histogram histo = Metrics.newHistogram(TestHistograms.class,"histo-sizes");

    /**
     * TODO
     * @author scutshuxue.chenxf
     * @param args
     * void
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        // TODOAuto-generated method stub

        ConsoleReporter.enable(1,TimeUnit.SECONDS);
        int i=0;
        while(true){
            histo.update(i++);
            Thread.sleep(1000);
        }
    }
}
