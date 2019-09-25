package Day1

object Conditionals extends App{
  def sum(input1: Int, input2: Int, bool: Boolean):Int = {
    if(bool) {input1+input2}
    else {input1*input2}
  }
  println(s"sum(2,3,true) is ${sum(2,3,true)}")
  println(s"sum(2,3,false) is ${sum(2,3,false)}")
}
