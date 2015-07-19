package charlie.lca;

/**
 * Created by ezhayog on 7/17/2015.
 */
public  interface LCA {
    /**
     * Find the Least Common Ancestor in given tree
     *
     * @param root  root of binary tree
     * @param first first node
     * @param second second node
     * @return null if not found common ancestor;
     * @throws LCAException
     */
    public Node findLca(Node root,Node first,Node second) throws LCAException;
}
