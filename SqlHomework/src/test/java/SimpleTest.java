import com.solvd.connection_pool.Multithread;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class SimpleTest {

        @Test
        public void ConnectionPoolTest() throws InterruptedException {
            ThreadPoolExecutor service = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
            Multithread myThing = new Multithread("jdbc:mysql://localhost:3306/supermarket","root","root");
            for(int i=1; i<8; i++){
                service.submit(myThing);
            }
            service.awaitTermination(5, TimeUnit.SECONDS);
            service.shutdown();
            assertTrue(myThing.isRes());
        }

        @Test
        public void ConnectionPoolRelease() throws InterruptedException {
            ThreadPoolExecutor service = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
            Multithread myThing = new Multithread("jdbc:mysql://localhost:3306/supermarket","root","root");
            for(int i=1; i<8; i++){
                service.submit(myThing);
            }
            service.awaitTermination(5, TimeUnit.SECONDS);
            service.shutdown();
            assertTrue(myThing.isClosing());
        }
}
