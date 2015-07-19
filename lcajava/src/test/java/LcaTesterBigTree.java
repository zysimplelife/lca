import charlie.lca.LCA;
import charlie.lca.LCADichotomy;
import charlie.lca.Node;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.rules.Timeout;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

/**
 * Created by ezhayog on 7/17/2015.
 */
public class LcaTesterBigTree {
    private final static Logger logger = LoggerFactory.getLogger(LcaTesterBigTree.class);
    private LCA lca = null;
    private static Node root100 = null;
    private static Node root1000 = null;
    private static Node root10000 = null;
    private static Node root100000 = null;

    @BeforeClass
    public static void generateData(){
        root100 = TreeGenerator.generateRandomBinaryTree(500,100,9,20);
        root1000 = TreeGenerator.generateRandomBinaryTree(5000,1000,9,20);
        root10000 = TreeGenerator.generateRandomBinaryTree(50000,10000,9,20);
        root100000 = TreeGenerator.generateRandomBinaryTree(500000,100000,9,20);
    }

    @Before
    public void setUp() throws Exception {
        lca = new LCADichotomy();

    }

    /**
     * Normal Case, both two node can be found in tree
     * @throws Exception
     */
    @org.junit.Test (timeout = 100)
    public void test100NodesCase() throws Exception {
        assertNotNull(lca.findLca(root100, new Node(9), new Node(20)));
    }

    /**
     * Normal Case, both two node can be found in tree
     * @throws Exception
     */
    @org.junit.Test (timeout = 1000)
    public void test1000NodesCase() throws Exception {

        assertNotNull(lca.findLca(root1000, new Node(9), new Node(20)));
    }

    /**
     * Normal Case, both two node can be found in tree
     * @throws Exception
     */
    @org.junit.Test (timeout = 1000)
    public void test10000NodesCase() throws Exception {

        assertNotNull(lca.findLca(root10000, new Node(9), new Node(20)));
    }

    /**
     * Normal Case, both two node can be found in tree
     * @throws Exception
     */
    @org.junit.Test (timeout = 1000)
    public void test10000N0odesCase() throws Exception {
        assertNotNull(lca.findLca(root10000, new Node(9), new Node(20)));
    }




}
