package Day1

object PatternMatching1 extends App{
  def conditional1(num1:Int, num2:Int, bool:Boolean):Int= (num1,num2,bool) match {
    case (x,y,true) => x+y
    case (x,y,false) => x*y
  }
  println(s"conditional1(3,4,true) is ${conditional1(3,4,true)}")
  println(s"conditional1(3,4,false) is ${conditional1(3,4,false)}")
}
