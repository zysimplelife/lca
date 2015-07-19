import charlie.lca.LCA;
import charlie.lca.LCADichotomy;
import charlie.lca.Node;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by ezhayog on 7/17/2015.
 */
public class LcaTesterMultiThread {
    private final static Logger logger = LoggerFactory.getLogger(LcaTesterMultiThread.class);
    private LCA lca = null;
    private static Node root100 = null;

    @BeforeClass
    public static void generateData() {
        root100 = TreeGenerator.generateRandomBinaryTree(500, 100, 9, 20);
    }

    @Before
    public void setUp() throws Exception {
        lca = new LCADichotomy();

    }


    @Test
    public void testMultiThread() throws Exception {

        final int numThreads = 100;
        final List<Throwable> exceptions = Collections.synchronizedList(new ArrayList<Throwable>());
        final ExecutorService threadPool = Executors.newFixedThreadPool(numThreads);

        try {
            final CountDownLatch allExecutorThreadsReady = new CountDownLatch(numThreads);
            final CountDownLatch afterInitBlocker = new CountDownLatch(1);
            final CountDownLatch allDone = new CountDownLatch(numThreads);

            for (int i = 0; i < numThreads; i++) {
                threadPool.submit(new Runnable() {
                    public void run() {

                        long count = allExecutorThreadsReady.getCount();
                        try {
                            allExecutorThreadsReady.countDown();
                            afterInitBlocker.await();
                            assertNotNull(lca.findLca(root100, new Node(9), new Node(20)));

                        } catch (final Throwable e) {
                            exceptions.add(e);
                        } finally {
                            allDone.countDown();
                        }
                    }
                });
            }
            assertTrue("Timeout initializing threads! Perform long lasting initializations before passing runnables to assertConcurrent", allExecutorThreadsReady.await(numThreads * 10, TimeUnit.MILLISECONDS));
            // start all test runners
            afterInitBlocker.countDown();

            assertTrue(" timeout! More than" + numThreads * 10 + "seconds", allDone.await(numThreads * 10, TimeUnit.SECONDS));
        } finally {
            threadPool.shutdownNow();
        }

        // assertTrue("failed with exception(s)" + exceptions, exceptions.isEmpty());
    }


}
