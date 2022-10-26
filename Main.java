import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Henry Keena, Gavin Burris, Prateek Narayanan
 * 
 * Link to Scheduled Thread Pooling Tutorial - https://www.geeksforgeeks.org/scheduledthreadpoolexecutor-class-in-java/#:~:text=ScheduledThreadPoolExecutor%20class%20in%20Java%20is,a%20fixed%2Dsized%20Thread%20Pool.
 */

public class Main {

    public static void main(String[] args) {
        int numThreads = 12;
        ScheduledThreadPoolExecutor threadPool
                = new ScheduledThreadPoolExecutor(numThreads);

        List<Runnable> tasks = new ArrayList<>();
        for(int i = 0; i < numThreads; i++) {
            tasks.add(new PrimeGenerator("task" + i, (int) (Math.random()*1000) + 2));
        }

        for(Runnable task: tasks) {
            threadPool.schedule(task, (int) (Math.random()*20), TimeUnit.SECONDS);
        }
        threadPool.shutdown();
    }
}