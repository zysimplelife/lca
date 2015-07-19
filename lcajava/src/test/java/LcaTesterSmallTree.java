import charlie.lca.LCA;
import charlie.lca.LCADichotomy;
import charlie.lca.Node;
import org.junit.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static junit.framework.Assert.assertEquals;

/**
 * Created by ezhayog on 7/17/2015.
 */
public class LcaTesterSmallTree {
    private final static Logger logger = LoggerFactory.getLogger(LcaTesterSmallTree.class);
    private LCA lca = null;

    @Before
    public void setUp() throws Exception {
        lca = new LCADichotomy();
    }

    /**
     * Normal Case, both two node can be found in tree
     * @throws Exception
     */
    @org.junit.Test
    public void testNormalCase() throws Exception {
        Node root = givenNormalTree();
        TreeGenerator.printTree(root);
        assertEquals("Failed to find LCA node", new Node(10), lca.findLca(root, new Node(2), new Node(4)));
    }

    @org.junit.Test
    public void testOneIsAbsent() throws Exception {
        Node root = givenNormalTree();
        assertEquals(null,lca.findLca(root,new Node(2),new Node(7)));
    }

    @org.junit.Test
    public void testBothAreAbsent() throws Exception {
        Node root = givenNormalTree();
        assertEquals(null,lca.findLca(root,new Node(11),new Node(7)));
    }

    @org.junit.Test
    public void testNullNodesInput() throws Exception {
        Node root = givenNormalTree();
        assertEquals(null,lca.findLca(root,null,null));
    }

    @org.junit.Test
    public void testNullRootInput() throws Exception {
        assertEquals(null,lca.findLca(null,new Node(11),new Node(7)));
    }

    private Node givenNormalTree() {
        Node node1 = new Node(1);
        node1.setLeft(new Node(10));
        node1.setRight(new Node(5));
        node1.getLeft().setLeft((new Node(3)));
        node1.getLeft().setRight((new Node(4)));
        node1.getLeft().getLeft().setRight((new Node(2)));
        node1.getLeft().getLeft().setLeft((new Node(6)));
        return node1;
    }



}
