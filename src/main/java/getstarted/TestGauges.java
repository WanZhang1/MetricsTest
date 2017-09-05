package getstarted;


import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import com.yammer.metrics.Metrics;
import com.yammer.metrics.core.Counter;
import com.yammer.metrics.core.Gauge;
import com.yammer.metrics.reporting.ConsoleReporter;


/**
 * Created by Administrator on 2017/9/4.
 */
public class TestGauges {
    public static Queue<String> queue = new LinkedList<String>();

    public static void main(String[] args) throws InterruptedException{
        ConsoleReporter.enable(5,TimeUnit.SECONDS);

        Gauge<Integer> g = Metrics.newGauge(TestGauges.class, "pending-jobs", new Gauge<Integer>(){
            @Override
            public Integer value(){
                return queue.size();
            }
        });
        //queue.add("ssss");
        System.out.println(g.value());
        while(true){
            Thread.sleep(1000);
            queue.add("ssss");
        }
    }
}
