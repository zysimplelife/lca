/**
 * Created by ezhayog on 7/19/2015.
 */

import org.scalatest.FlatSpec
class LcaBDD extends FlatSpec{
  def fixture =
    new {
      val node3 = Node(3,Leaf(5),Leaf(7))
      val node2 = Node(2,node3,Leaf(9))
      val node1 = Node(1,Leaf(4),node2)
    }

  behavior of "An Lca Finder "

  it should "can find common ancestor with different value" in {
    val f = fixture
    assertResult(f.node2){
      LCAFinder.findLca(f.node1,7,9)
    }
  }

  it should "return existing value if another is not in the tree" in {
    val f = fixture
    assertResult(Leaf(7)){
      LCAFinder.findLca(f.node1,7,11)
    }
  }

  it should "return null value if both value are not in the tree" in {
    val f = fixture
    assertResult(null){
      LCAFinder.findLca(f.node1,12,11)
    }
  }

  it should "return null if root is null" in {
    val f = fixture
    assertResult(null){
      LCAFinder.findLca(null,1,2)
    }
  }


}
