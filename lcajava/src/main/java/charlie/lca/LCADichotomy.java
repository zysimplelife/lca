package charlie.lca;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by ezhayog on 7/17/2015.
 * This is the very common Algorithm of find LCA.
 * I got this Algorithm from web http://www.fusu.us/2013/06/p2-lowest-common-ancestor-in-binary-tree.html
 */
public class LCADichotomy implements LCA {
    private static final Logger logger = LoggerFactory.getLogger(LCADichotomy.class);
    private final ThreadLocal<Integer> foundNodes  = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };


    @Override
    public Node findLca(Node root, Node first, Node second) throws LCAException {
        Node lca = doFindLca(root, first, second);
        logger.debug("found nodes {}", foundNodes.get());
        if(foundNodes.get() == 2){
            return lca;
        }else{
            return null;
        }

    }

    private Node doFindLca(Node root, Node first, Node second) throws LCAException {
        if(root == null||first == null || second == null )  return null;

        // if two node are same, return one of them
        if(first.equals(second)) {
            return first;
        }

        // return root if one of them is equals to root.  it used as the stop condition for recursion
        if(root.equals(first) || root.equals(second)) {
            foundNodes.set(foundNodes.get()+1);
            return root;
        }

        Node left = doFindLca(root.getLeft(), first, second);
        Node right = doFindLca(root.getRight(),first,second);


        if (logger.isTraceEnabled()) {
            logger.trace("get the left {} and right {} in root {}", left,right,root);
        }


        if(left != null && right != null) {  // find node in both branch
            return root;
        }

        if(left != null) return left;

        if(right != null) return right;

        return null;
    }
}
