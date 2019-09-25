package Day1

object Conditionals2 extends App{
  def sum(int1: Int, int2: Int, bool: Boolean):Int = {
    if(int1== 0) int2
    else if(int2==0) int1
          else if(bool) {int1+int2}
          else {int1*int2}
  }
  println(s"sum(2,0,true) is ${sum(2,0,true)}")
  println(s"sum(0,3,false) is ${sum(0,3,false)}")
  println(s"sum(0,0,false) is ${sum(0,0,false)}")
  println(s"sum(2,3,true) is ${sum(2,3,true)}")
  println(s"sum(2,3,false) is ${sum(2,3,false)}")
}
