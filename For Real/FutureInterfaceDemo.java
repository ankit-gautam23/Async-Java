import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureInterfaceDemo{

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(10);

        Future<String> future1 = threadPool.submit(()->{
            System.out.println("Task 1 is being executed");
            sleep(3000);
            return "Task 1 is compeleted";
        });
         Future<String> future2 = threadPool.submit(()->{
            System.out.println("Task 2 is being executed");
            sleep(1000);
            return "Task 2 is compeleted";
        });

        try {
            String result1 = future1.get();
            System.out.println(result1);

            // Here the result1 and result2 will be printed immediatly after the first one. As execution of second future is
            // completed but result presentation can only take place after result1 in Future.

            //That's a limitation of future interface.

            String result2 = future2.get();
            System.out.println(result2);
        } catch (InterruptedException | ExecutionException ee) {
            ee.printStackTrace();
        }
    }

    private static void sleep(long milis){
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    
}