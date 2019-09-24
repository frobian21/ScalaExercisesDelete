package Day1

object Conditionals2 extends App{
  def sum(a: Int, b: Int, bool: Boolean):Int = {
    if(a == 0) b
    else if(b==0) a
          else if(bool) {a+b}
          else {a*b}
  }
  println(s"sum(2,0,true) is ${sum(2,0,true)}")
  println(s"sum(0,3,false) is ${sum(0,3,false)}")
  println(s"sum(0,0,false) is ${sum(0,0,false)}")
  println(s"sum(2,3,true) is ${sum(2,3,true)}")
  println(s"sum(2,3,false) is ${sum(2,3,false)}")
}
