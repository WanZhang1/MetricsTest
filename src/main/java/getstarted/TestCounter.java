package getstarted;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

import com.yammer.metrics.Metrics;
import com.yammer.metrics.core.Counter;
import com.yammer.metrics.reporting.ConsoleReporter;
/**
 * Created by zhangw on 2017/9/4.
 * Counter计数器
 */
public class TestCounter {
    //定义Counter
    private final Counter pendingJobs = Metrics.newCounter(TestCounter.class, "pending-jobs");
    //定义队列
    private final Queue<String> queue = new LinkedList<String>();

    /**
     * 增加方法
     * @param str
     */
    public void add(String str) {
        pendingJobs.inc();
        queue.offer(str);
    }

    /**
     * 减少方法
     * @return
     */
    public String take() {
        pendingJobs.dec();
        return queue.poll();
    }

    /**
     * 主函数
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[]args) throws InterruptedException {
        TestCounter tc =new TestCounter();
        ConsoleReporter.enable(1,TimeUnit.SECONDS);//每秒在控制台报告一次
        while(true){
            tc.add("1");
            Thread.sleep(1000);
        }
    }

}
