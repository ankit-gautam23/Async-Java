import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExceptionCFDemo {
    
    private static final ExecutorService threadPool = Executors.newFixedThreadPool(4);
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println(executeAsync().get());
    }   
    
    public static CompletableFuture<String> executeAsync()
    {
        return CompletableFuture.supplyAsync(()->"Task 1 result")
        .thenApplyAsync((result)->{
            System.out.println("Task 2 executing...");
            return result + "1";
        }).thenApplyAsync((result)->{
            System.out.println("Task 3 executing...");
            return result + "1";
        }).thenApplyAsync((result)->{
            System.out.println("Task 4 executing...");
            return result + "1";
        }).thenApplyAsync((result)->{
            System.out.println("Task 5 executing...");
            return result + "1";
        });

    }
}
