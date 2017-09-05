package getstarted;
import java.util.concurrent.TimeUnit;

import com.yammer.metrics.Metrics;
import com.yammer.metrics.core.Histogram;
import com.yammer.metrics.reporting.ConsoleReporter;

/**
 * Created by zhangw on 2017/9/4.
 * Histograms 直方图
 */
public class TestHistograms {
    //定义Histograms
    private static Histogram histo = Metrics.newHistogram(TestHistograms.class,"histo-sizes");

    /**
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        ConsoleReporter.enable(1,TimeUnit.SECONDS);
        int i=0;
        while(true){
            histo.update(i++);
            Thread.sleep(1000);
        }
    }
}
