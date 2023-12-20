import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ComplexSceneriosDemo {

    private static final ExecutorService threadPool = Executors.newFixedThreadPool(4);

    public static void main(String[] args) throws InterruptedException, ExecutionException{
        System.out.println(executeAsync().get());
    }

    public static CompletableFuture<String> executeAsync(){
        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(()->"result1");
        CompletableFuture<String> cf2;

        CompletableFuture<String> cf3 = cf1.thenComposeAsync(
            (result)->CompletableFuture.supplyAsync(() -> result + "result2"));


        CompletableFuture<CompletableFuture<String>> cf4 = cf1.thenApplyAsync((result)->CompletableFuture.supplyAsync(()-> result + "result n"));
        
        CompletableFuture<Integer> cf5 = CompletableFuture.supplyAsync(()->123);

        CompletableFuture<Double> cf6 = cf5.thenCombineAsync(cf2, (stringResult, integerResult) -> {
            return 12.12;
        });
        
        return cf3;

    }

}
