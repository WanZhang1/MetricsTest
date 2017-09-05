package usermanual;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import com.yammer.metrics.HealthChecks;
import com.yammer.metrics.core.HealthCheck;
import com.yammer.metrics.reporting.ConsoleReporter;
/**
 * Created by Administrator on 2017/9/4.
 */
public class DatabaseHealthCheck extends HealthCheck {
    private static Database database;
    private static final Map<String, Result> results = HealthChecks.runHealthChecks();

    public DatabaseHealthCheck(Database database) {
        super("database");
        this.database =database;
    }

    @Override
    public Result check()throws Exception {

        if(database.isConnected()) {
            return Result.healthy();
        } else {
            return Result.unhealthy("Cannot connect to database" );
        }
    }

    public static void main(String[] args) throws Exception{
        Database db = new Database();
        DatabaseHealthCheck checkHealth = new DatabaseHealthCheck(db);
        HealthChecks.register(checkHealth);

        while(true){
            Map<String,Result> results = HealthChecks.runHealthChecks();
            for(Entry<String, Result> entry : results.entrySet()) {
                if (entry.getValue().isHealthy()) {
                    System.out.println(entry.getKey() +" is healthy");
                } else {
                    System.err.println(entry.getKey() +" is UNHEALTHY: " + entry.getValue().getMessage());
                }
            }
            Thread.sleep(1000);
        }
    }
}
class Database{
    static Random rn = new Random();

    public boolean isConnected() {
        // TODOAuto-generated method stub
        return rn.nextBoolean();
    }

}
