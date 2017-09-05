package getstarted;


import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import com.yammer.metrics.Metrics;
import com.yammer.metrics.core.Counter;
import com.yammer.metrics.core.Gauge;
import com.yammer.metrics.reporting.ConsoleReporter;


/**
 * Created by zhangw on 2017/9/4.
 * Gauges度量
 */
public class TestGauges {
    //定义队列
    public static Queue<String> queue = new LinkedList<String>();

    public static void main(String[] args) throws InterruptedException{
        ConsoleReporter.enable(5,TimeUnit.SECONDS);//每5秒控制台打印一次
        //定义Gauges
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
