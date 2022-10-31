import java.util.Arrays;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class PrimeGenerator implements Runnable{

    private final String threadName;
    private int taskNum;
    private int numPrimes;

    public PrimeGenerator(String _name) {
        this.threadName = _name;
        this.taskNum = 0;
    }

    public static List<Integer> sieveOfEratosthenes(int n) {
        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);
        for (int p = 2; p * p <= n; p++) {
            if (prime[p]) {
                for (int i = p * 2; i <= n; i += p) {
                    prime[i] = false;
                }
            }
        }
        List<Integer> primeNumbers = new LinkedList<>();
        for (int i = 2; i <= n; i++) {
            if (prime[i]) {
                primeNumbers.add(i);
            }
        }
        return primeNumbers;
    }

    private void printPrimes(List<Integer> primes) {
        String printOut =
                "Thread Name: " + this.threadName + 
                "\nTask Number: " + this.taskNum +
                "\nPrime Upper Bound: " + this.numPrimes +
                "\nNumber of Primes: " + primes.size() +
                "\nHighest Prime: " + primes.get(primes.size() - 1) +
                "\nCurrentTime: " + Calendar.getInstance().get(Calendar.SECOND);
        System.out.println(printOut);
        System.out.println(primes + "\n");
    }

    public void setTaskNum(int _taskNum) {
        this.taskNum = _taskNum;
    }

    public void setPrimeNums(int _numPrimes) {
        this.numPrimes = _numPrimes;
    }

    @Override
    public void run() {
        Random rand = new Random();
        int low = 10;
        int high = 100;
        int total = rand.nextInt(high-low) + low;
        
        for(int i = 0; i <= total; i++) {
            this.setPrimeNums((int)(Math.random()*1000) + 2);
            List<Integer> primes = sieveOfEratosthenes(this.numPrimes);
            this.setTaskNum(i+1);
            printPrimes(primes);
        }
    }
}
