package Day1

object PatternMatching2 extends App{
  def swapper(input: AnyRef) = input match {
    case x :: y :: xs => List(y,x)
    case (x, y) => (y,x)
    case (x, y, _) => (y,x)
    case Array(x, y) => Array(y,x)
    case _ => "Oh No that's not accepted"
  }
  println(s"swapper(List(1) is ${swapper(List(1))}")
  println(s"swapper(List(1,2)) is ${swapper(List(1,2))}")
  println(s"swapper(List(1,2,3)) is ${swapper(List(1,2,3))}")
  // println(s"swapper(1) is ${swapper(1)}") Causes an error
  println(s"swapper(1,2) is ${swapper(1,2)}")
  println(s"swapper(1,2,3) is ${swapper(1,2,3)}")
  println(s"swapper(Array(1)) is ${swapper(Array(1))}")
  println(s"swapper(Array(1,2)) is ${swapper(Array(1,2))}")
  println(s"swapper(Array(1,2,3)) is ${swapper(Array(1,2,3))}")
}
