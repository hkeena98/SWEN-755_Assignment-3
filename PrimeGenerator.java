import java.util.Arrays;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

public class PrimeGenerator implements Runnable{

    private String taskName;
    private int numPrimes;

    public PrimeGenerator(String name, int numPrimes) {
        this.taskName = name;
        this.numPrimes = numPrimes;
    }

    public static List<Integer> sieveOfEratosthenes(int n) {
        boolean prime[] = new boolean[n + 1];
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

    private String print(List<Integer> primes) {
        String boundString = "\nPrime Upper Bound: " + this.numPrimes;
        String primesString = "\nNumber of Primes: " + primes.size();
        String highestString = "\nHighest Prime: " + primes.get(primes.size() - 1);
        String timeString= "\nCurrentTime: " + Calendar.getInstance().get(Calendar.SECOND);
        return taskName + boundString + primesString + highestString + timeString;
    }

    @Override
    public void run() {;
        List<Integer> primes = sieveOfEratosthenes(this.numPrimes);
        System.out.println(print(primes));
        System.out.println(primes + "\n");
    }
}