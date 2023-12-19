import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureDemo {

    private static final ExecutorService threadPool = Executors.newFixedThreadPool(10);
    public static void main(String[] args) throws ExecutionException, InterruptedException{
     
        CompletableFuture<Void> task1 = CompletableFuture.runAsync(() -> {
            System.out.println("Task1 is being executed " + Thread.currentThread().getName());
        });

        task1.get();
    }

    private static void executeWorkload(String name){
        System.out.println(name);
        sleep(3000);
    }

    private static void sleep(long milis){
        System.out.println("Sleeping for " + milis + " miliseconds");
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
