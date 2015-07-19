/**
 * Created by ezhayog on 7/19/2015.
 */

sealed abstract class Tree
case class Node (value:Int,left:Tree,right:Tree) extends Tree
case class Leaf(value:Int) extends Tree



