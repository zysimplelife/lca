

/**
 * Created by ezhayog on 7/19/2015.
 */
object LCAFinder {
  def findLca(root: Tree, first: Int, second: Int): Tree = {

    if (isMatch(root, first) || isMatch(root, second)) return root

    val leftRoot = root match {
      case Node(_, left, _) => findLca(left, first, second)
      case _ => null
    }

    val rightRoot = root match {
      case Node(_, _, right) => findLca(right, first, second)
      case _ => null
    }

    if (leftRoot != null && rightRoot != null) {
      return root
    }

    if (leftRoot != null) {
      return leftRoot
    }

    if (rightRoot != null) {
      return rightRoot
    }

    return null;
  }

  private def isMatch(node: Tree, input: Int): Boolean = {
    return node match {
      case Leaf(v) if (v == input)  => true
      case Node(v, _, _) if (v == input) => true
      case _ => false
    }
  }

}
