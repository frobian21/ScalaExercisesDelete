package Day1

object Conditionals extends App{
  def sum(a: Int, b: Int, bool: Boolean):Int = {
    if(bool) {a+b}
    else {a*b}
  }
  println(s"sum(2,3,true) is ${sum(2,3,true)}")
  println(s"sum(2,3,false) is ${sum(2,3,false)}")
}
