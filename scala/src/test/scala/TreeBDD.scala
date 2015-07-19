/**
 * Created by ezhayog on 7/19/2015.
 */

import org.scalatest.FlatSpec

class TreeSpec extends FlatSpec {

  def fixture =
    new {
      val node3 = Node(3,Leaf(5),Leaf(7))
      val node2 = Node(2,node3,Leaf(9))
      val node1 = Node(1,Leaf(4),node2)
    }

  def isDefined(root:Tree,value:Int):Boolean = {
      return root match {
        case Leaf(v) if(v == value) => true
        case Node(v, _, _) if (v == value) => true
        case Node(_,left,right) => isDefined(left,value) || isDefined(right,value)
        case _ => false
      }
  }

  behavior of "An Normal Tree"

  it should "can be print" in {
    val f = fixture
    println(f.node1)
  }

  it should "value can be found in tree" in {
    val f = fixture
    assert(isDefined(f.node1,5))
  }

  it should "some value can't be found in tree" in {
    val f = fixture
    assert(isDefined(f.node1,11) == false)
  }

}
