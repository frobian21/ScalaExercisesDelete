package Day2

object UniqueSum extends App{
  def uniqueSummation(input1: Int, input2: Int, input3: Int): Int = (input1, input2, input3) match {
    case _ if input1==input2 && input2==input3 => 0
    case _ if input1==input2 => input3
    case _ if input1==input3 => input2
    case _ if input2==input3 => input1
    case _ => input1+input2+input3
  }
  println(s"uniqueSummation(1,2,3) is ${uniqueSummation(1,2,3)}")
  println(s"uniqueSummation(3,3,3) is ${uniqueSummation(3,3,3)}")
  println(s"uniqueSummation(1,1,2) is ${uniqueSummation(1,1,2)}")
}