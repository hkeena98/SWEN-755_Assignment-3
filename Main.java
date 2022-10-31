/**
 * @author Henry Keena, Gavin Burris, Prateek Narayanan
 * 
 * @description This file is the Main class by which to test the "Scheduling" 
 */

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        System.out.println("\nBeginning Thread Pool...\n");

        int numThreads = 12;
        ScheduledThreadPoolExecutor threadPool = new ScheduledThreadPoolExecutor(numThreads);

        System.out.println("Scheduling Threads in Pool...\n");

        List<Runnable> tasks = new ArrayList<>();
        
        for(int i = 0; i < numThreads; i++) {
            tasks.add(new PrimeGenerator("PrimeNumberGenerator Thread #" + (i+1)));
        }

        for(Runnable task: tasks) {
            threadPool.schedule(task, (int) (Math.random()*20), TimeUnit.SECONDS);
        }
        threadPool.shutdown();
    }
}