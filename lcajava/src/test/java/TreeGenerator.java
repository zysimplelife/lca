import charlie.lca.Node;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Created by ezhayog on 7/18/2015.
 */
public class TreeGenerator {
    private static final  Logger logger = LoggerFactory.getLogger(TreeGenerator.class);
    public static final String TAB_STR = "\t";
    public static final String NULL_LEAF = "E";

    /**
     * Generate a Random Binary Tree within
     * @param range  node value comes from 0 to range
     * @param count  counts of nodes
     * @return
     */
    public static Node generateRandomBinaryTree(int range,int count,int... fixedValues){
        Random generator = new Random();
        // generate the Integer fist;
        Set<Integer> generated = new LinkedHashSet<Integer>();

        while(generated.size() < count - fixedValues.length){
            generated.add(generator.nextInt(range));
        }

        // add fixed value first
        for(int fixedValue : fixedValues){
            generated.add(fixedValue);
        }

        Node root = new Node(-1);
        for(Integer value:generated){
            fillTree(root,value);
        }

        return root;
    }

    /**
     * return  Tree height
     * @param root
     * @return
     */
    public static int getHeight(Node root){
        if(root  == null) return 0;

        int l = getHeight(root.getLeft()) + 1 ;
        int r = getHeight(root.getRight()) + 1;

        return l > r?l:r;
    }

    /**
     * format print Tree
     * @param root
     */
    public static void printTree(Node root){
        logger.info("Tree height is {}",getHeight(root));
        List<StringBuffer> lines = new ArrayList<StringBuffer>();
        generateStrings(root,lines,0);
        for(StringBuffer line : lines){
            logger.info(line.toString());
        }

    }

    private static void generateStrings(Node root,List<StringBuffer> lines,int layer ){
        if(lines.size() ==  layer){
            StringBuffer sb = new StringBuffer();
            lines.add(sb);

            for(StringBuffer line :lines){
                line.insert(0, TAB_STR);
            }

        }

        lines.get(layer).append(TAB_STR);

        if(root == null){
            lines.get(layer).append(NULL_LEAF);
            return;
        }

        lines.get(layer).append(root);


        generateStrings(root.getLeft(), lines, layer + 1);
        generateStrings(root.getRight(), lines, layer + 1);
    }


    private static void fillTree(Node root,Integer value){
        if(root.getLeft() == null){
            root.setLeft(new Node(value));
            return;
        }

        if(root.getRight() == null){
            root.setRight(new Node(value));
            return;
        }

        if(getHeight(root.getLeft()) <= getHeight(root.getRight())){
            fillTree(root.getLeft(),value);
        }else{
            fillTree(root.getRight(),value);
        }

    }





}
