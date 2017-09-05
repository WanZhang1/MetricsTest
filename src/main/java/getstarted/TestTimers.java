package getstarted;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import com.yammer.metrics.Metrics;
import com.yammer.metrics.core.Timer;
import com.yammer.metrics.core.TimerContext;
import com.yammer.metrics.reporting.ConsoleReporter;
/**
 * Created by zhangw on 2017/9/4.
 * Timer
 */
public class TestTimers {
    //定义Timer
    private static Timer timer = Metrics.newTimer(TestTimers.class, "responses", TimeUnit.MILLISECONDS,TimeUnit.SECONDS);

    /**
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        ConsoleReporter.enable(2,TimeUnit.SECONDS);
        Random rn = new Random();
        timer.time();
        System.out.println();
        while(true){
            TimerContext context = timer.time();
            Thread.sleep(rn.nextInt(1000));
            context.stop();
        }
    }
}
